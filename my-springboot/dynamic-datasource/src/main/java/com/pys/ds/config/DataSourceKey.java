package com.pys.ds.config;

public enum DataSourceKey {
    MASTER("master"),
    SLAVE("slave");

    private String name;

    public String getName() {
        return name;
    }

    DataSourceKey(String name) {
        this.name = name;
    }
}
