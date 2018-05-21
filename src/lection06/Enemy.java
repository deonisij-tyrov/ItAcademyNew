package lection06;

public abstract class Enemy implements Mortal {
    private int health;
    private int attackPower;

    public Enemy(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health >= 0 ? health : 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("this enemy have " + getHealth() + "hp\n");
    }


    public abstract void attackHero(Hero hero);

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}
