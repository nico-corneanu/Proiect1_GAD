package com.company;

public class ClassicsFactory implements ProductsAbstractFactory {
    @Override public Classics create() {return new Classics();}
}
