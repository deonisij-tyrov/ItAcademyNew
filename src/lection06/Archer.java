package lection06;

public class Archer extends Hero {

    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Archer " + super.getName() + " attacks");
        if (Math.random() * 10 > 2) {
            goodShot(enemy);
        } else {
            enemy.takeDamage(this.getAttackPower());
        }

    }

    public void goodShot(Enemy enemy) {
        System.out.println("The archer " + super.getName() + " makes head shot:");
        enemy.takeDamage(enemy.getHealth());
    }

}
