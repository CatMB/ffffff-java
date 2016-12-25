package com.catmb.ffffff;


public class Hero {
    private static Hero hero;
    private Hero() {

    }
    public static Hero getInstance() {
        if(hero == null) {
            hero = new Hero();
        }
        return hero;
    }
}
