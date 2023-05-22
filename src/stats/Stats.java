package stats;

public abstract class Stats {
    public float maxHealth;
    public float currentHealth;
    public int speed;

    public void takeDamage(float damage) {
        if(damage > currentHealth) currentHealth = 0;
        else currentHealth -= damage;
    }
}
