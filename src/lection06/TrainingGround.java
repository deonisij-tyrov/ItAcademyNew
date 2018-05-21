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

        Enemy[] enemies = new Enemy[4];
        enemies[0] = new Zombie(100, 20);
        enemies[1] = new Zombie(100, 20);
        enemies[2] = new Vampire(100, 20);
        enemies[3] = new Vampire(100, 20);

        int numberOfMoves = 0;
        while (checkLive(heroes) && checkLive(enemies)) {
            fight(enemies, heroes);
            numberOfMoves++;
        }
        if (checkLive(heroes) == true) {
            System.out.print("heroes win. Step : " + numberOfMoves);
        }
        else {System.out.println("heroes dead. Step : " + numberOfMoves);}
    }


    public static boolean checkLive (Mortal... mortal) {
        for (Mortal m : mortal) {
            if (m.isAlive() == true) {
                return true;
            }
        }
        return false;
    }

    public static void fight ( Enemy[] enemies, Hero... heroes) {
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
