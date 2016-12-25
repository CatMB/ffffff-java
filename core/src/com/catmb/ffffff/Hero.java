package com.catmb.ffffff;


public class Hero {
    private static Hero instance = null;
    protected Hero() {
    }
    public static Hero getInstance() {
        if(instance == null) {
            instance = new Hero();
        }
        return instance;
    }
}
