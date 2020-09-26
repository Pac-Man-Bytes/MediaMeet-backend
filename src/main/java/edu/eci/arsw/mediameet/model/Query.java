package edu.eci.arsw.mediameet.model;

import java.io.Serializable;

public class Query implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

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
