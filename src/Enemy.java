public class Enemy {

    private final String enemyName;
    private final int enemyDamage;
    private int enemyHealth;

    public Enemy(String enemyName, int enemyHealth, int enemyDamage) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
    }

    public void takeDamage(int damage) {
        this.enemyHealth -= damage;
    }

    public String getName() {
        return enemyName;
    }

    public int getDamage() {
        return enemyDamage;
    }

    public int getHealth() {
        return enemyHealth;
    }

}