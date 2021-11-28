package com.company;

public class Product {
    private float price;
    private String category;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int buyProduct(int availableStock, int price, int numberOfPieces, int moneyOffered) {
        int cost = 0;
        if(availableStock > 0) {
            System.out.println("We do have this product available!\n");
            if(availableStock - numberOfPieces > 0) {
                cost = numberOfPieces * price;
                System.out.println("Here is what you requested, it costs " + cost + "\n");
                if(moneyOffered >= cost) {
                    int change = moneyOffered - cost;
                    System.out.println("Thank you, here is your change!\n" + change);
                } else {
                    System.out.println("You do not have enough money to buy this product!\n");
                }
                availableStock -= numberOfPieces;
            }
        }
        return cost;
    }

    public boolean sellProduct(int dailyRevenue, int sellPrice) {
       boolean buy = false;
        System.out.println("We are greatful for this book you wanna sell! If the price is right " +
                "for us, we will purchase it!\n");
        if(sellPrice <= 0) {
            System.out.println("So thoughtfull of you! Thanks!\n");
        } else {
            if(dailyRevenue - sellPrice > 0) {
                buy = true;
                System.out.println("We will take good care of this book!\n");
            } else {
                System.out.println("We are sorry, we cannot purchase this book at the moment! =(\n");
            }
        }
        return buy;
    }
}
