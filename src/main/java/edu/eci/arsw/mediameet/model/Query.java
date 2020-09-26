package edu.eci.arsw.mediameet.model;

import java.io.Serializable;

public class Query implements Serializable {
    private String query;

    public Query() {
    }

    public Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
