package lection06;

public class Vampire extends Enemy {
    public static final String ANSI_CYAN = "\u001B[36m";

    public Vampire(int health, int attackPower) {
        super(health, attackPower);
    }

    @Override
    public void attackHero(Hero hero) {
        System.out.println(ANSI_CYAN + "Vampire attacks hero " + hero.getName());
        hero.takeDamage(this.getAttackPower());
    }

    @Override
    public void takeDamage(int damage) {
        if (Math.random() * 10 > 8) {
            System.out.println(ANSI_CYAN + "this enemy dodged the attack");
            System.out.println("this enemy have " + getHealth() + "hp\n");
        } else {
            super.takeDamage(damage);
        }

    }
}
