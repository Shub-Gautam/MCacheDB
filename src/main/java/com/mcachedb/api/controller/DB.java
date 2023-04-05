package com.mcachedb.api.controller;

import com.mcachedb.datapackets.Basket;
import com.mcachedb.datapackets.Database;
import com.mcachedb.manage.DatabaseManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController(value = "local")
public class DB {
    DatabaseManager databaseManager = new DatabaseManager();

    @GetMapping("/dbs")
    public ResponseEntity<List<String>> getDB(){
//        Check if the database is null or not, if so the send appropriate response
        HashMap<String, Database> dbs =  databaseManager.getDatabases();
        List<String> list = new ArrayList<>();
        dbs.forEach((key,value) ->{
            list.add(key);
        });
        return ResponseEntity.ok(list);
    }

    @PostMapping("/db/{name}")
    public ResponseEntity<String> makeDB(@PathVariable("name") String name){
        Database newDataBase = new Database(name,new HashSet<Basket>(),new Date());
        databaseManager.addDatabase(newDataBase);
        return ResponseEntity.ok("Successfull");
    }
}
