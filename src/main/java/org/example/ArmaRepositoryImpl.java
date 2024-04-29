package org.example;
import java.sql.*;
import java.util.*;

public class ArmaRepositoryImpl implements IRepository<Arma>{
    private Connection con;
    private static Set<Arma> armaCached = new HashSet<>();
    public ArmaRepositoryImpl(){
        this.con = ArmaService.getConnection();
    }

    @Override
    public List<Arma> findAll() throws SQLException {
        List<Arma> armas = new ArrayList<>();
        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM armas");
        while (rs.next()){
            Arma arma = bdToEntity(rs);
            armas.add(arma);
            System.out.println( "ID: " + rs.getInt("id") + " - " + rs.getString("nombre") + " - Tier: " + rs.getString("tier") + " - Tipo: " + rs.getString("tipo"));
        }
        return armas;

    }

    public Arma findById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Arma arma = null;
        System.out.println("Introduce el ID del arma: ");
        int id = scanner.nextInt();
        PreparedStatement st = con.prepareStatement("SELECT * FROM armas where id = ?");
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("nombre") + " - Tier: " + rs.getString("tier") + " - Tipo: " + rs.getString("tipo"));
        }
        if (rs.next()){
            arma = bdToEntity(rs);
        }
        return arma;
    }


    public void save() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PreparedStatement st = null;
        System.out.println("Introduce el nombre del arma: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el tier del arma: ");
        String tier = scanner.nextLine();
        System.out.println("Introduce el tipo de arma: ");
        String precio = scanner.nextLine();
        String query = "INSERT INTO armas (nombre,tier,tipo) VALUES(?,?,?)";
        st = con.prepareStatement(query);
        st.setString(1, nombre);
        st.setString(2,tier);
        st.setString(3,precio);
        st.executeUpdate();
        System.out.println("Se ha guardado correctamente!");
    }


    public void delete() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        findAll();
        System.out.println("\nIntroduce el ID del arma que quieras eliminar: ");
        int id = scanner.nextInt();
        PreparedStatement st = con.prepareStatement("DELETE FROM armas WHERE id = ?");
        st.setInt(1, id);
        st.executeUpdate();
        st.close();
        System.out.println("Se ha eliminado correctamente!");
    }

    @Override
    public Arma bdToEntity(ResultSet rs) throws SQLException {
        Arma arma = new Arma(rs.getInt("id"),rs.getString("nombre"),rs.getString("tier"),rs.getString("tipo"));
        return arma;
    }

}
