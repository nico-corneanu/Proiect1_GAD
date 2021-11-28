package com.company;

public class HorrorFactory implements ProductsAbstractFactory {
    @Override public Horror create() {return new Horror();}
}