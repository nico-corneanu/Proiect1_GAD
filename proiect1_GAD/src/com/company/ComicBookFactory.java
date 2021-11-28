package com.company;

public class ComicBookFactory implements ProductsAbstractFactory {
    @Override public ComicBook create() {return new ComicBook();}
}

