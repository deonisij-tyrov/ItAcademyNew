package lection06;

public class Warrior extends Hero implements Mortal {
    private int stepToAbility;

    public Warrior(String name, int health, int attackPower, int stepToAbility) {
        super(name, health, attackPower);
        this.stepToAbility = stepToAbility;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Warrior " + super.getName() + " attacks");
        enemy.takeDamage(this.getAttackPower());
        if (stepToAbility-- == 0) {
            fury(enemy);
        }
    }

    public void fury(Enemy enemy) {
            System.out.println("The warrior " + super.getName() + " is furious:");
            attackEnemy(enemy);
    }
}
