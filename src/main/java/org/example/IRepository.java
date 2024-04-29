package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public interface IRepository<T> {
    List<T> findAll() throws SQLException;
    T findById() throws SQLException;
    void save()  throws SQLException;
    void delete() throws SQLException ;
    T bdToEntity(ResultSet rs) throws SQLException ;
}
