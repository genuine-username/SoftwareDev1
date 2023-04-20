// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package Week7;

public class enemy {
    float health;
    float damage;
    float x, y;
    float direction;

    /**
     * Create an enemy
     * @param health the enemy's health
     * @param damage the damage the enemy can do
     * @param x its x position
     * @param y its y position
     */
    public enemy(float health, float damage, float x, float y) {
        this.health = health;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public float performAttack(float playerArmor) {
        return damage / playerArmor;
    }
}
