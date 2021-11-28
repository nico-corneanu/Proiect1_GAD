package com.company;

public class RandomFactory implements ProductsAbstractFactory {
    @Override public RandomProduct create() {return new RandomProduct();}
}