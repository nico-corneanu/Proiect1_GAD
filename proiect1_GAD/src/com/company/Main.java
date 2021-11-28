package com.company;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Shop shop = Shop.getInstance();
	boolean isShop = true;
	    while(isShop) {
            System.out.println("Please enter what do you want to do:\n");
            Scanner sc = new Scanner(System.in);
            String action = sc.nextLine();
            if (action.equals("Buy")) {
                shop.sellProcess();
            } else if (action.equals("Sell")) {
                System.out.println("Please enter how much do you want for this book:\n");
                shop.buyProcess();
            } else if (action.equals("Exit")) {
                System.exit(0);
            } else{
                System.out.println("Please enter a valid action!\n");
            }
        }
    }
}
