package com.example.sinyakkirill.lab_4_5.organization;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public enum Organizations {
    Epam("Epam", 100), Pek("Pek Inc.", 1200);

    Organizations(String name, int profit){
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    String name;
    int profit;
}
