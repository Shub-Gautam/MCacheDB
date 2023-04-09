package com.mcachedb.api.controller;

import com.mcachedb.datapackets.Basket;
import com.mcachedb.datapackets.Database;
import com.mcachedb.datapackets.Row;
import com.mcachedb.manage.DatabaseManager;
import com.mcachedb.response.db.AddRow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Database newDataBase = new Database(name,new HashMap<String,Basket>(),new Date());
        databaseManager.addDatabase(newDataBase);
        return ResponseEntity.ok("Successfull");
    }

    @GetMapping("bask/{db}")
    public ResponseEntity<HashMap<String,Basket>> getBaskets(@PathVariable String db){
        Database tempDatabase = databaseManager.getDatabase(db);
        return ResponseEntity.ok(tempDatabase.getBaskets());
    }

    @PostMapping("bask/create/{db}/{basket_name}")
    public ResponseEntity<String> setBasket(@PathVariable String basket_name, @PathVariable String db){
        Database tempDatabase = databaseManager.getDatabase(db);
        Basket newBasket = new Basket(basket_name,new HashMap<String, Row>(),new Date());
        tempDatabase.addBasket(newBasket);
        return ResponseEntity.ok("Basket Created Successfully");
    }

//    Under Processing
    @PostMapping("/db/{db}/bask/{basket_name}/add")
    public ResponseEntity<String> addRow(@PathVariable String basket_name, @PathVariable String db, @RequestBody AddRow data){
        Database tempDatabase = databaseManager.getDatabase(db);
        Basket basket = tempDatabase.getBasket(basket_name);
        Row row = new Row((System.currentTimeMillis() * 1000000L) + "",new HashMap<String,String>(),new Date(),new Date());
        row.getKeyValuesMap().put(data.getKey(),data.getValue());
        basket.addRow(row);
        return ResponseEntity.ok("1 Row added to the basket");
    }

    @GetMapping("/db/{db}/bask/{basket_name}/{key}")
    public ResponseEntity<Row> getRow(@PathVariable String basket_name, @PathVariable String db, @PathVariable String key){
        Database tempDatabase = databaseManager.getDatabase(db);
        Basket basket = tempDatabase.getBasket(basket_name);
        Row row = basket.getRows().get(key);
        return ResponseEntity.ok(row);
    }

    @GetMapping("/db/{db}/bask/{basket_name}/all")
    public ResponseEntity<List<Row>> getAllRowsInBasket(@PathVariable String basket_name, @PathVariable String db){
        Database tempDatabase = databaseManager.getDatabase(db);
        Basket basket = tempDatabase.getBasket(basket_name);
        List<Row> list = new ArrayList<>();
        basket.getRows().forEach((key,value)->{
            list.add(value);
        });
        return ResponseEntity.ok(list);
    }
}
