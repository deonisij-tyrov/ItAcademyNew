package lection06;

public class Mage extends Hero {
    private int mana;

    public Mage(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Mage " + super.getName() + " attacks");
        enemy.takeDamage(this.getAttackPower());
        mana++;
        if (this.getHealth() < 5 && mana > 2) {
            therapy(this);
            mana -= 2;
        }
    }

    public void therapy(Hero hero) {
        System.out.println("The mage " + super.getName() + " is restore");
        hero.healthAdd(getHealth()/3);
    }
}
