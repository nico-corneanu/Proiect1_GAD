package com.company;

public class FantasyFactory implements ProductsAbstractFactory {
    @Override public Fantasy create() {return new Fantasy();}
}