package lection06;

public class Zombie extends Enemy {
    private static final String ANSI_RED = "\u001b[31m";
    private final int ROSE_AGAIN_HP = 50;
    private boolean riseAgain = true;

    public Zombie(int health, int attackPower) {
        super(health, attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (this.isAlive() == false && riseAgain == true) {
            this.riseAgain();
        }
    }

    public void riseAgain() {
        System.out.println(ANSI_RED + "Zombie rises\n");
        riseAgain = false;
        this.setHealth(ROSE_AGAIN_HP);
    }

    public void attackHero(Hero hero) {
        System.out.println(ANSI_RED + "Zombie attacks hero " + hero.getName());
        hero.takeDamage(this.getAttackPower());
    }
}
