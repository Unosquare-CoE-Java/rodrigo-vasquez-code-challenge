package com.unosquare.challenge.datastructure01;

class Item {

    private Integer number;

    private Integer timesAccessed;

    public Item(Integer number) {
        this.number = number;
        this.timesAccessed = 0;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTimesAccessed() {
        return timesAccessed;
    }

    public void setTimesAccessed(Integer timesAccessed) {
        this.timesAccessed = timesAccessed;
    }
}
