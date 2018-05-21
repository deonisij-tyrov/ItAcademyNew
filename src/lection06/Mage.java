package lection06;

public class Mage extends Hero {
    public static final String ANSI_YELLOW = "\u001B[33m";
    private final int MANA_FOR_ABILITY = 2;
    private final int CRITICAL_HIALTH = 20;
    private int mana;

    public Mage(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(ANSI_YELLOW + "Mage " + super.getName() + " attacks");
        enemy.takeDamage(this.getAttackPower());
        mana++;
        if (this.getHealth() < CRITICAL_HIALTH && mana > MANA_FOR_ABILITY) {
            therapy(this);
            mana -= 2;
        }
    }

    public void therapy(Hero hero) {
        System.out.println(ANSI_YELLOW + "The mage " + super.getName() + " is restore");
        hero.healthAdd(getHealth() / 3);
    }
}
