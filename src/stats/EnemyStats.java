package stats;

public class EnemyStats extends Stats {
    
    public EnemyStats(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }
}
