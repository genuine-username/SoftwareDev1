// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package Week10;

import java.util.ArrayList;
import java.util.Collections;

public class Interfaces {
    public static void main(String[] args) {
        // Create an ArrayList of enemies with names, 1-10, and a random amount of damage.
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < 10; i++) {
            enemies.add(new Enemy(String.valueOf(i), 1, (float) Math.random()));
        }

        // Print out the unsorted ArrayList
        System.out.println("\nUnsorted enemies: ");
        for (Enemy enemy : enemies) {
            System.out.println("Enemy: " + enemy.name + " deals " + enemy.damage + " damage");
        }

        Collections.sort(enemies);

        // Print out the sorted ArrayList
        System.out.println("\nSorted enemies: ");
        for (Enemy enemy : enemies) {
            System.out.println("Enemy: " + enemy.name + " deals " + enemy.damage + " damage");
        }
    }
}

class Enemy implements Comparable<Enemy> {
    String name;

    float health;
    float damage;

    boolean alive;

    /**
     * Create an enemy
     * 
     * @param health the enemy's health
     * @param damage the damage the enemy can do
     * @param x      its x position
     * @param y      its y position
     */
    public Enemy(String name, float health, float damage) {
        this.name = name;

        this.health = health;
        this.damage = damage;

        alive = true;
    }

    /**
     * Performs an attack on the player and print the result
     * 
     * @param playerArmor The amount of armor the player has
     * @return the final damage output
     */
    public float performAttack(float playerArmor) {
        float totalDamage = damage / playerArmor;
        System.out.println("Enemy " + name + " dealt " + String.valueOf(totalDamage) + " damage");
        return totalDamage;
    }

    /**
     * Deal damage to the enemy and print the result
     * 
     * @param damage The amount of damage to recieve
     * @return if the enemy is dead
     */
    public void takeDamage(float damage) {
        System.out.println("Enemy " + name + " recieved " + String.valueOf(damage) + " damage");
        health -= damage;

        if (health <= 0) {
            // The enemy has been defeated so print a message and then inform the code to
            // kill it
            System.out.println("Enemy " + name + " has been defeated!");
            alive = false;
        } else {
            // The enemy is not dead so print its health and don't kill it
            System.out.println("Enemy " + name + " is now at " + String.valueOf(health) + " health");
        }

    }

    /**
     * Compare to other enemies from greatest to smallest based on how much damage
     * they do
     * 
     * @param enemy
     * @return
     */
    @Override
    public int compareTo(Enemy enemy) {
        if (enemy.damage > damage) { // The enemy is greater if it does more damage
            return 1;
        } else if (enemy.damage < damage) { // The enemy is less if it does less
            return -1;
        } else { // Otherwise consider it equal
            return 0;
        }
    }
}