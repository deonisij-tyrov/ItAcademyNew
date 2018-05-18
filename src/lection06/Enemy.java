package lection06;

public class Enemy implements Mortal {
    private int health;
    private int attackPower;

    public Enemy(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("this enemy have " + health + "hp\n");
    }


    public void attackHero(Hero hero) {
        System.out.println("Enemy attacks hero " + hero.getName());
        hero.takeDamage(this.getAttackPower());
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}
