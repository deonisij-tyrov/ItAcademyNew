package lection06;

public class Archer extends Hero {
    public static final String ANSI_GREEN = "\u001B[32m";

    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(ANSI_GREEN + "Archer " + super.getName() + " attacks");
        if (Math.random() * 10 > 8) {
            goodShot(enemy);
        } else {
            enemy.takeDamage(this.getAttackPower());
        }

    }

    public void goodShot(Enemy enemy) {
        System.out.println(ANSI_GREEN + "The archer " + super.getName() + " makes head shot:");
        enemy.takeDamage(enemy.getHealth());
    }

}
