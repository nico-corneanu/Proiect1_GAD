package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    //eager initialisation of singleton shop
    private static final Shop instance = new Shop();
    private Shop() { }
    private int dailyRevenue;
    private int numberOfProducts;

    public static Shop getInstance() {
        return instance;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }
    //number of products in the shop
    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getDailyRevenue() {
        return dailyRevenue;
    }

    public void setDailyRevenue(int dailyRevenue) {
        this.dailyRevenue = dailyRevenue;
    }
    ArrayList<Classics> classicsStock = new ArrayList<>(50);
    ArrayList<ComicBook> comicBookStock = new ArrayList<>(50);
    ArrayList<Fantasy> fantasyStock = new ArrayList<>(50);
    ArrayList<Horror> horrorStock = new ArrayList<>(50);
    ArrayList<Mystery> mysteryStock = new ArrayList<>(50);
    ArrayList<RandomProduct> randomProductStock = new ArrayList<>(50);


    ClassicsFactory classicsFactory = new ClassicsFactory();
    Classics classics = classicsFactory.create();

    ComicBookFactory comicBookFactory = new ComicBookFactory();
    ComicBook comicBook = comicBookFactory.create();

    FantasyFactory fantasyFactory = new FantasyFactory();
    Fantasy fantasy = fantasyFactory.create();

    HorrorFactory horrorFactory = new HorrorFactory();
    Horror horror = horrorFactory.create();

    MysteryFactory mysteryFactory = new MysteryFactory();
    Mystery mystery = mysteryFactory.create();

    RandomFactory randomFactory = new RandomFactory();
    RandomProduct randomProduct = randomFactory.create();

    public void sellProcess() {
        classics.setAvailableStock(100);
        comicBook.setAvailableStock(58);
        fantasy.setAvailableStock(80);
        horror.setAvailableStock(300);
        mystery.setAvailableStock(69);

        setNumberOfProducts(classics.getAvailableStock() + comicBook.getAvailableStock() + fantasy.getAvailableStock()
        + horror.getAvailableStock() + mystery.getAvailableStock());

        System.out.println("Hello, what can we do for you?\n");
        System.out.println("Please enter what category you want to buy:\n");

        Scanner sc = new Scanner(System.in);
        String category = sc.nextLine();
        System.out.println("Please enter the quantity you wanna buy\n");
        int quantity = sc.nextInt();
        System.out.println("Enter the amount of money for the product:\n");
        int money = sc.nextInt();

        if(category.equals("Classics")) {
            int cost = classics.buyProduct(classics.getAvailableStock(), 5, quantity, money);
            setDailyRevenue(getDailyRevenue() + cost);
        } else if(category.equals("ComicBook")) {
            comicBook.buyProduct(comicBook.getAvailableStock(), 15, quantity, money);
        } else if(category.equals("Fantasy")) {
            fantasy.buyProduct(fantasy.getAvailableStock(), 25, quantity, money);
        } else if(category.equals("Horror")) {
            horror.buyProduct(horror.getAvailableStock(), 6, quantity, money);
        } else if(category.equals("Mystery")) {
            mystery.buyProduct(mystery.getAvailableStock(), 12, quantity, money);
        } else {
            System.out.println("Please enter a valid category!\n");
        }
    }

    public void buyProcess() {
        Scanner sc = new Scanner(System.in);
        int sellPrice = sc.nextInt();
        randomProduct.sellProduct(dailyRevenue, sellPrice);
        if(randomProduct.sellProduct(dailyRevenue, sellPrice)) {
            setDailyRevenue(getDailyRevenue() - sellPrice);
            setNumberOfProducts(getNumberOfProducts() + 1);
        }
    }
}
