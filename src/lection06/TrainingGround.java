package lection06;

public class TrainingGround {
    public static void main(String[] args) {

        Hero[] heroes = new Hero[3];
        Warrior warrior = new Warrior("MyWarrior", 300,50, 3);
        Mage mage = new Mage("MyMage", 100, 20, 2);
        Archer archer = new Archer("MyArcher",200, 35);
        heroes[0] = warrior;
        heroes[1] = mage;
        heroes[2] = archer;

        Enemy[] enemies = new Enemy[5];
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Zombie(100, 5);
        }
int i = 0;
        while (checkLive(heroes) && checkLive(enemies)) {
            fight(heroes, enemies);
            i++;
        }
        if (checkLive(heroes) == true) {
            System.out.print("heroes win" + i);
        }
        else {System.out.println("heroes dead" + i);}
    }


    private static boolean checkLive (Mortal... mortal) {
        for (Mortal m : mortal) {
            if (m.isAlive() == true) {
                return true;
            }
        }
        return false;
    }

    private static void fight (Hero[] heroes, Enemy[] enemies) {
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                Enemy enemy = enemies[(int)(Math.random() * enemies.length)];
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                Hero hero = heroes[(int)(Math.random() * heroes.length)];
                if (hero.isAlive()) {
                    enemy.attackHero(hero);
                }
            }
        }
    }
}
