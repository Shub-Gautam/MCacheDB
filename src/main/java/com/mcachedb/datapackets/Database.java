package com.mcachedb.datapackets;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private String dbName ;
    private HashMap<String,Basket> baskets ;
    private Date createdAt ;

    public Database() {
    }

    public Database(String dbName, HashMap<String,Basket> baskets, Date createdAt) {
        this.dbName = dbName;
        this.baskets = baskets;
        this.createdAt = createdAt;
    }

    public void addBasket(Basket basket){
        this.baskets.put(basket.getBasketName(),basket);
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public HashMap<String,Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(HashMap<String,Basket> baskets) {
        this.baskets = baskets;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Basket getBasket(String basketName) {
        return this.baskets.get(basketName);
    }
}
