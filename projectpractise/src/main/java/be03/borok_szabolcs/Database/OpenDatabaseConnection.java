package be03.borok_szabolcs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpenDatabaseConnection {
    private Connection connection;

    public OpenDatabaseConnection() throws FileNotFoundException, SQLException {
        DatabaseProperties databaseProperties = getDatabaseProperties();
        connection = DriverManager.getConnection(databaseProperties.getDBURL());
    }

    private DatabaseProperties getDatabaseProperties() throws FileNotFoundException {
        List<String> raw_properties = new ArrayList<>();
        File db_file = new File("config.txt");
        Scanner db_scanner = new Scanner(db_file);
        
        while (db_scanner.hasNextLine()) {
            raw_properties.add(db_scanner.nextLine());
        }
        return new DatabaseProperties(raw_properties);
    }

    public Connection getConnection() {
        return connection;
    }


}
