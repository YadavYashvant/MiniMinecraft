package com.yashvant;

import java.util.Random;

public class World {
    private int width;
    private int height;
    private Block[][] blocks;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocks = new Block[width][height];
        generateWorld();
    }

    private void generateWorld() {
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

    public void expandWorld(int newWidth, int newHeight) {
        Block[][] newBlocks = new Block[newWidth][newHeight];
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                if (x < width && y < height) {
                    newBlocks[x][y] = blocks[x][y];
                } else {
                    if (y < newHeight / 2) {
                        newBlocks[x][y] = new Block(Block.Type.AIR);
                    } else if (y == newHeight / 2) {
                        newBlocks[x][y] = new Block(Block.Type.GRASS);
                    } else {
                        newBlocks[x][y] = new Block(Block.Type.DIRT);
                    }
                }
            }
        }
        this.width = newWidth;
        this.height = newHeight;
        this.blocks = newBlocks;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}