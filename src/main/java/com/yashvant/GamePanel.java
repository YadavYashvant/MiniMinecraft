package com.yashvant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener, MouseListener {
    private final int blockSize = 20;
    private final World world;
    private int playerX, playerY;

    public GamePanel() {
        this.world = new World(40, 30);
        this.playerX = world.getWidth() / 2;
        this.playerY = world.getHeight() / 2;
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                Block block = world.getBlock(x, y);
                if (block != null) {
                    switch (block.getType()) {
                        case AIR -> g.setColor(Color.CYAN);
                        case DIRT -> g.setColor(new Color(139, 69, 19));
                        case GRASS -> g.setColor(Color.GREEN);
                        case STONE -> g.setColor(Color.GRAY);
                        case WATER -> g.setColor(Color.BLUE);
                    }
                    g.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
                }
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x * blockSize, y * blockSize, blockSize, blockSize);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(playerX * blockSize, playerY * blockSize, blockSize, blockSize);
    }

    public void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;

        if (newX < 0 || newX >= world.getWidth() || newY < 0 || newY >= world.getHeight()) {
            world.expandWorld(world.getWidth() + 10, world.getHeight() + 10);
        }

        if (newX >= 0 && newX < world.getWidth() && newY >= 0 && newY < world.getHeight()) {
            playerX = newX;
            playerY = newY;
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W -> movePlayer(0, -1);
            case KeyEvent.VK_S -> movePlayer(0, 1);
            case KeyEvent.VK_A -> movePlayer(-1, 0);
            case KeyEvent.VK_D -> movePlayer(1, 0);
            case KeyEvent.VK_SPACE -> toggleBlock();
        }
    }

    private void toggleBlock() {
        Block block = world.getBlock(playerX, playerY);
        if (block != null) {
            if (block.getType() == Block.Type.AIR) {
                world.setBlock(playerX, playerY, new Block(Block.Type.DIRT));
            } else {
                world.setBlock(playerX, playerY, new Block(Block.Type.AIR));
            }
            repaint();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}