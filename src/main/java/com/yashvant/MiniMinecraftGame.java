package com.yashvant;

import javax.swing.*;

public class MiniMinecraftGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Minecraft");
        GamePanel panel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}