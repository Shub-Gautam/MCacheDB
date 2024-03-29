package com.mcachedb.manage;

import com.mcachedb.datapackets.Database;

import java.io.Serializable;
import java.util.HashMap;

/**
 * in future versions
 * Create logic and checks if the database contain some files or is empty
 * give necessary warnings to the user and exceptions along with the force methods
**/

// Under Development -- Shubham Gautam
public class DatabaseManager implements Serializable {
    HashMap<String, Database> databases ;

    public DatabaseManager(HashMap<String, Database> databases) {
        this.databases = databases;
    }

    public DatabaseManager() {
        this.databases = new HashMap<>();
    }

    public Database getDatabase(String dbName){
        return databases.get(dbName);
    }

    public void addDatabase(Database database){
        this.databases.put(database.getDbName(),database);
    }

    public HashMap<String, Database> getDatabases() {
        return databases;
    }

    public void setDatabases(HashMap<String, Database> databases) {
        this.databases = databases;
    }
}
