package com.company;

public class MysteryFactory implements ProductsAbstractFactory {
    @Override public Mystery create() {return new Mystery();}
}
