package com.mcachedb.response.db;

public class AddRow {
    private String key;
    private String value;

    public AddRow(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AddRow{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void setValue(String value) {
        this.value = value;
    }
}
