package com.example.challengerapproaching;

public class character {

    private String name;

    private String [] moves;

    public character(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String[] getMoves() {
        return moves;
    }
}
