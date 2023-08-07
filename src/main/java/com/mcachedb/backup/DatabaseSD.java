package com.mcachedb.backup;

import com.mcachedb.datapackets.Database;
import com.mcachedb.manage.DatabaseManager;

import java.io.*;

public class DatabaseSD {

    public void serializerDB(String fileName, DatabaseManager databaseManager){

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(databaseManager);

            fos.close();
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public DatabaseManager deserializerDB(String fileName){

        DatabaseManager databaseManager = null ;

        try {
            FileInputStream fis = new FileInputStream("backup.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            databaseManager = (DatabaseManager) ois.readObject();

            fis.close();
            ois.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return databaseManager ;

    }
}
