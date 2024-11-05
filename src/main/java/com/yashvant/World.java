package com.yashvant;

import java.util.Random;

public class World {
    private final int width;
    private final int height;
    private final Block[][] blocks;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocks = new Block[width][height];
        generateWorld();
    }

    private void generateWorld() {
        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (y < height / 2) {
                    blocks[x][y] = new Block(Block.Type.AIR);
                } else if (y == height / 2) {
                    blocks[x][y] = new Block(Block.Type.GRASS);
                } else {
                    blocks[x][y] = new Block(Block.Type.DIRT);
                }
            }
        }
    }

    public Block getBlock(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return blocks[x][y];
        }
        return null;
    }

    public void setBlock(int x, int y, Block block) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            blocks[x][y] = block;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}