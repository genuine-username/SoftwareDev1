// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package Week9;

import java.util.ArrayList;

public class Objects {
    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();

        enemies.add(new Enemy("Basic", 10f, 5f));
        enemies.add(new InconsistentEnemy("Inconsistent", 20f, 3f));
        enemies.add(new CompoundingEnemy("Compounding", 15f, 5f));

        // The "player"'s stats
        float playerHealth = 64f;
        float playerDamage = 5;
        float playerArmor = 1;

        // The main loop for the "game"
        int i = 1;
        while (true) {
            // Display the turn number
            System.out.println("\nTurn: " + String.valueOf(i));

            // Do enemy attacks
            System.out.println("\nEnemies attack: ");
            for (Enemy enemy : enemies) {
                playerHealth -= enemy.performAttack(playerArmor);
            }

            // If the player is dead, then give the game over message and quit otherwise
            // print health
            if (playerHealth <= 0) {
                System.out.println("\nThe player has been defeated! Game Over!\n");
                break;
            } else {
                System.out.println("\nPlayer is at " + String.valueOf(playerHealth) + " health");
            }

            // Perform the player's attacks
            System.out.println("\nPlayer attacks for " + String.valueOf(playerDamage) + " damage each:");
            for (Enemy enemy : enemies) {
                enemy.takeDamage(playerDamage);
            }

            // Check if the enemies are dead
            boolean stillAlive = false;
            for (Enemy enemy : enemies) {
                if (enemy.alive) {
                    stillAlive = true;
                    break;
                }
            }

            if (!stillAlive) {
                System.out.println("\nVictory!!!!!\n");
                break;
            }

            i++;
        }
    }
}

class Enemy {
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
     * @param playerArmor
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
     * @param damage
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
}

class InconsistentEnemy extends Enemy {
    boolean evenAttack = true;

    /**
     * Creates an enemy which does double damage ever-other attack
     * 
     * @param name
     * @param health
     * @param damage
     */
    public InconsistentEnemy(String name, float health, float damage) {
        super(name, health, damage);
    }

    /**
     * Performs an attack on the player and print the result
     * 
     * @param playerArmor
     * @return the final damage output
     */
    public float performAttack(float playerArmor) {
        float totalDamage;

        // Multiply the damage by 2 every other attack
        if (evenAttack) {
            totalDamage = (damage * 2) / playerArmor;
            evenAttack = false;
        } else {
            totalDamage = damage / playerArmor;
            evenAttack = true;
        }

        System.out.println("Enemy " + name + " dealt " + String.valueOf(totalDamage) + " damage");
        return totalDamage;
    }
}

class CompoundingEnemy extends Enemy {

    ArrayList<Float> previousAttacks = new ArrayList<Float>();

    /**
     * An enemy which adds the previous damage that it did each round to it's
     * current damage
     * 
     * @param name
     * @param health
     * @param damage
     */
    public CompoundingEnemy(String name, float health, float damage) {
        super(name, health, damage);
    }

    public float performAttack(float playerArmor) {
        // Sum all of the previously done damage
        float previousDamage = 0;
        for (float attack : previousAttacks) {
            previousDamage += attack;
        }

        // Deal damage
        float totalDamage = (damage + previousDamage) / playerArmor;
        previousAttacks.add(totalDamage);

        System.out.println("Enemy " + name + " dealt " + String.valueOf(totalDamage) + " damage");
        return totalDamage;
    }

}