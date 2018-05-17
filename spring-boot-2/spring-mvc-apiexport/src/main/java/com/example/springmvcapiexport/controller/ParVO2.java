package com.example.springmvcapiexport.controller;

import java.io.Serializable;

public class ParVO2 implements Serializable {


    /**
     * first : 0
     * rows : 10
     * sortOrder : 1
     */

    private int first;
    private int rows;
    private int sortOrder;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
