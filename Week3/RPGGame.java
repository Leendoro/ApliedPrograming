package Week3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// ORC QUEST TEXT RPG

// Character class represents the player or enemies
class Character {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name; // Getter for the name field
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        return attackPower;
    }

    public void heal(int amount) {
        health += amount;
    }
}

// Enemy class inheriting from Character (Inheritance Example)
class Enemy extends Character {
    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // Enemy-specific behavior could be added here
}

// Player class inheriting from Character and implementing Fightable interface (Interface Example)
class Player extends Character implements Fightable {
    public Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void fight(Character enemy) {
        Random rand = new Random();
        int damage = rand.nextInt(attack()) + 1;
        enemy.takeDamage(damage);
        System.out.println(getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
    }
}

// Interface for fighting functionality
interface Fightable {
    void fight(Character enemy);
}

// Main class to run the RPG game
public class RPGGame {
    private static ArrayList<Enemy> enemies = new ArrayList<>();
    private static Player player;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the player
        System.out.println("Enter your character's name:");
        String playerName = scanner.nextLine();
        player = new Player(playerName, 100, 20);

        // Create enemies
        enemies.add(new Enemy("Goblin", 50, 10));
        enemies.add(new Enemy("Orc", 80, 15));

        // Game loop
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\nYour character: " + player.getName() + " | Health: " + player.getHealth());
            System.out.println("Enemies left: ");
            for (int i = 0; i < enemies.size(); i++) {
                System.out.println((i + 1) + ". " + enemies.get(i).getName() + " (Health: " + enemies.get(i).getHealth() + ")");
            }

            // Player chooses an enemy to fight
            System.out.println("Choose an enemy to fight (1-" + enemies.size() + "), or press 0 to quit:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting game.");
                gameRunning = false;
                break;
            }

            // Battle phase
            if (choice >= 1 && choice <= enemies.size()) {
                Enemy enemy = enemies.get(choice - 1);
                battle(player, enemy);
                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " has been defeated!");
                    enemies.remove(enemy);
                }
            } else {
                System.out.println("Invalid choice, please try again.");
            }

            // Check if all enemies are defeated
            if (enemies.isEmpty()) {
                System.out.println("All enemies have been defeated! You win!");
                break;
            }
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    // Function to handle battle between player and enemy
    private static void battle(Player player, Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Battle Begins ---");
            player.fight(enemy);  // Player attacks
            if (enemy.isAlive()) {
                enemy.takeDamage(enemy.attack());  // Enemy attacks
                System.out.println(enemy.getName() + " attacks for " + enemy.attack() + " damage!");
            }
            if (player.isAlive() && !enemy.isAlive()) {
                break;
            }
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " has been defeated! Game Over.");
        }
    }
}
