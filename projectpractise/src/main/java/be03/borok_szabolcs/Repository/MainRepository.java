package be03.borok_szabolcs.Repository;

import java.sql.SQLException;

import java.io.FileNotFoundException;

import be03.borok_szabolcs.Database.OpenDatabaseConnection;

public abstract class MainRepository<T> implements IMainRepository<T> {
    
    OpenDatabaseConnection databaseConnection;

    public MainRepository() {

        try {
            databaseConnection = new OpenDatabaseConnection();
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("A kapcsolat nem lehetseges, ellenorizze az adatbazist es/vagy a config file-t.");
        }

        databaseConnection.getConnection();
    }




}
