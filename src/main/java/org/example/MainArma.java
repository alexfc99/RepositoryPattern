package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainArma {
    private static int currentScreen = 0;
    private static final ArmaRepositoryImpl armaRepository = new ArmaRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        int opcion;
        printTitle();
        while(true) {
            printMenu();
            opcion = getOption();
            if (opcion == 0) break;
            if (currentScreen == 0) {
                switch (opcion) {
                    case 1: armaRepository.findAll();
                    break;
                    case 2: armaRepository.findById();
                    break;
                    case 3: armaRepository.save();
                    break;
                    case 4: armaRepository.delete();
                }
            }
        }
    }
    private static void printTitle(){

        System.out.println(AnsiColor.RED.getCode());
        System.out.println("\n" +
                "\n" +
                "▓█████▄ ▄▄▄      ██▀███  ██ ▄█▀     ██████ ▒█████  █    ██ ██▓     ██████ \n" +
                "▒██▀ ██▒████▄   ▓██ ▒ ██▒██▄█▒    ▒██    ▒▒██▒  ██▒██  ▓██▓██▒   ▒██    ▒ \n" +
                "░██   █▒██  ▀█▄ ▓██ ░▄█ ▓███▄░    ░ ▓██▄  ▒██░  ██▓██  ▒██▒██░   ░ ▓██▄   \n" +
                "░▓█▄   ░██▄▄▄▄██▒██▀▀█▄ ▓██ █▄      ▒   ██▒██   ██▓▓█  ░██▒██░     ▒   ██▒\n" +
                "░▒████▓ ▓█   ▓██░██▓ ▒██▒██▒ █▄   ▒██████▒░ ████▓▒▒▒█████▓░██████▒██████▒▒\n" +
                " ▒▒▓  ▒ ▒▒   ▓▒█░ ▒▓ ░▒▓▒ ▒▒ ▓▒   ▒ ▒▓▒ ▒ ░ ▒░▒░▒░░▒▓▒ ▒ ▒░ ▒░▓  ▒ ▒▓▒ ▒ ░\n" +
                " ░ ▒  ▒  ▒   ▒▒ ░ ░▒ ░ ▒░ ░▒ ▒░   ░ ░▒  ░ ░ ░ ▒ ▒░░░▒░ ░ ░░ ░ ▒  ░ ░▒  ░ ░\n" +
                " ░ ░  ░  ░   ▒    ░░   ░░ ░░ ░    ░  ░  ░ ░ ░ ░ ▒  ░░░ ░ ░  ░ ░  ░  ░  ░  \n" +
                "   ░         ░  ░  ░    ░  ░            ░     ░ ░    ░        ░  ░     ░  \n" +
                " ░                                                                        \n" +
                "\n");
        System.out.println(AnsiColor.RESET.getCode());
    }
    public static void printMenu(){
        System.out.println(AnsiColor.RED.getCode());
        System.out.println("--------------------------------------------------------------------------------------------");
        if (currentScreen == 0){
            System.out.println("0 Salir | 1 Mostrar Armas | 2 Buscar por ID | 3 Añadir Arma | 4 Borrar Arma");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(AnsiColor.RESET.getCode());
    }

    private static int getOption(){
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        try{
            option = Integer.parseInt(scanner.nextLine());
            if ((currentScreen == 0 && option > 4) ){
                System.out.println("Incorrect Option");
            }
        }catch (IllegalArgumentException iae){
            System.out.println("Incorrect Option");
        }
        return  option;
    }
}