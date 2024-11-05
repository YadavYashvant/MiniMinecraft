package com.yashvant;

public class Block {
    public enum Type {
        AIR, DIRT, GRASS, STONE, WATER
    }

    private Type type;

    public Block(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}