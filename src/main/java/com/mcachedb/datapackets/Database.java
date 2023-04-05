package com.mcachedb.datapackets;

import java.util.Date;
import java.util.HashSet;

public class Database {
    private String dbName ;
    private HashSet<Basket> baskets ;
    private Date createdAt ;

    public Database() {
    }

    public Database(String dbName, HashSet<Basket> baskets, Date createdAt) {
        this.dbName = dbName;
        this.baskets = baskets;
        this.createdAt = createdAt;
    }

    public void addBasket(Basket basket){
        this.baskets.add(basket);
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public HashSet<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(HashSet<Basket> baskets) {
        this.baskets = baskets;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
