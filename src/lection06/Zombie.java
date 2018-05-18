package lection06;

public class Zombie extends Enemy {
    private boolean rise = true;

    public Zombie(int health, int attackPower) {
        super(health, attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (this.isAlive() == false && rise == true) {
            this.rise();
        }
    }

    public void rise() {
        System.out.println("Zombie rises\n");
        rise = false;
        this.setHealth(50);
    }

}
