# MiniMinecraft

A simple 2D Minecraft-like game built with Java. It is a basic attempt to create a 2D game where the player can move around, place, and remove blocks in an expanding world.

## Features

- **2D World Generation**: The game generates a simple 2D world with different types of blocks (air, dirt, grass, stone, water).
- **Player Movement**: The player can move around the world using keyboard inputs.
- **Block Placement and Removal**: The player can place and remove blocks in the world.
- **Dynamic World Expansion**: The world expands dynamically as the player moves towards the edges.

## Controls

- **W**: Move up
- **S**: Move down
- **A**: Move left
- **D**: Move right
- **Space**: Toggle block (place/remove)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher
- Maven

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/YadavYashvant/miniminecraft.git
    cd miniminecraft
    ```

2. **Build the project**:
    ```sh
    mvn clean install
    ```

3. **Run the game**:
    ```sh
    mvn exec:java -Dexec.mainClass="com.yashvant.MiniMinecraftGame"
    ```

## Project Structure

- `src/main/java/com/yashvant/Block.java`: Defines the different types of blocks and their properties.
- `src/main/java/com/yashvant/World.java`: Manages the grid of blocks and handles world generation and expansion.
- `src/main/java/com/yashvant/GamePanel.java`: Handles rendering, player interactions, and block placement/removal.
- `src/main/java/com/yashvant/MiniMinecraftGame.java`: Initializes and runs the game.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.