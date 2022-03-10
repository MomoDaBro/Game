public class Enemy {

    String enemyName;
    int enemyHealth;
    int enemyDamage;

    public Enemy(String enemyName, int enemyHealth, int enemyDamage) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
    }

    public String GetName() {
        return enemyName;
    }

    public int GetDamage() {
        return enemyDamage;
    }

    public int GetHealth() {
        return enemyHealth;
    }

}
