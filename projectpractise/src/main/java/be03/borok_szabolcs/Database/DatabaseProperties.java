package be03.borok_szabolcs.Database;

import java.util.List;

public class DatabaseProperties {
    // Hozzunk letre 5 tulajdonsagot az osztalyon belul - egyiknek sincs get es set metodusa

    String  URL;
    String  databaseName;
    Boolean encrypt;
    String  userName;
    String  password;


    public DatabaseProperties(List<String> raw_properties) {
        // 1. Vizsgaljatok meg, hogy a parameter az NULL-e, ha nem, akkor 5 elem van-e es ha 5 eleme van,
        // akkor vizsgaljatok meg, hogy az egyes elemek tartalmazzak-e az alabbi neveket: 
        // DATABASE_URL, DATABASE_NAME, DATABASE_ENCRYPT, DATABASE_USER, DATABASE_PASSWORD
        //2. Ha az elso pont minden feltetele IGAZ, akkor gyujtsuk ki a hozzajuk tartozo ertekeket (pl.: localhost, Advent...)
        // 3. publikus metodus, nem statikus, ami egy olyan String-et allit elo, 
        // ami megfelel az adatbazis kapcsolat letrehozasahoz szukseges URL-nek.
        // (jdbc:sqlserver://DATABASE_URL;databaseName=DATABASE_NAME,...)

        if (raw_properties != null && raw_properties.size() == 5 && checkValues(raw_properties)) {
            this.URL = raw_properties.get(0).split("=")[1]; 
            this.databaseName = raw_properties.get(1).split("=")[1]; 
            this.encrypt = Boolean.valueOf(raw_properties.get(2).split("=")[1]); 
            this.userName = raw_properties.get(3).split("=")[1]; 
            this.password = raw_properties.get(4).split("=")[1];            
        }
    }

    private Boolean checkValues(List<String> raw_properties) {
        Boolean isCorrect = true;
        isCorrect &= raw_properties.get(0).contains("DATABASE_URL");
        isCorrect &= raw_properties.get(1).contains("DATABASE_NAME");
        isCorrect &= raw_properties.get(2).contains("DATABASE_ENCRYPT");
        isCorrect &= raw_properties.get(3).contains("DATABASE_USER");
        isCorrect &= raw_properties.get(3).contains("DATABASE_PASSWORD");
        return isCorrect;
    }

    public String getDBURL() {
        return 
        "jdbc:sqlserver://" + this.URL + 
        ";databaseName=" + this.databaseName + 
        ";encrypt=" + this.encrypt +
        ";user=" + this.userName +
        ";password=" + this.password +
        ";";
    }

















    

}
