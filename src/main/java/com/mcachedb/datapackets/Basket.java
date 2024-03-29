package com.mcachedb.datapackets;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Basket implements Serializable {
    private String basketName;
    private HashMap<String, Row> rows ;
    private Date createdAt;

    public Basket(String basketName, HashMap<String, Row> rows, Date createdAt) {
        this.basketName = basketName;
        this.rows = rows;
        this.createdAt = createdAt;
    }

    public Basket() {
        this.rows = new HashMap<>();
    }

    public void addRow(Row row){
        rows.put(row.getRowId(), row);
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public void setRows(HashMap<String, Row> rows) {
        this.rows = rows;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBasketName() {
        return basketName;
    }

    public HashMap<String, Row> getRows() {
        return rows;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
