package lection06;

public abstract class Hero implements Mortal {
    private String name;
    private int health;
    private int attackPower;


    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    protected void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("this hero "+ getName() +" have " + health + "hp\n");
    }

    public void healthAdd(int healthToAdd) {
        health += healthToAdd;
    }

    public abstract void attackEnemy(Enemy enemy);
}
