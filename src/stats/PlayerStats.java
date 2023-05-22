package stats;

public class PlayerStats extends Stats {
    public float fireRateMultiplier;
    public int score = 0;
    public PlayerStats(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
    }

    public void addScore(int score) {
        this.score += score;
    }

    
}
