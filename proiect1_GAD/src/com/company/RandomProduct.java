package com.company;

public class RandomProduct extends Product{
    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    private int availableStock;
}
