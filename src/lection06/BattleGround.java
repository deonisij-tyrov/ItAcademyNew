package lection06;

import static lection06.TrainingGround.checkLive;
import static lection06.TrainingGround.fight;

public class BattleGround {

    public static void main(String[] args) {
        fight1();
        System.out.println("\n___________________________");
        fight2();
        System.out.println("\n___________________________");
        fight3();
        System.out.println("\n___________________________");
    }

    private static void fight1() {
        System.out.println("Fight 1");
        Warrior warrior = new Warrior("MyWarrior", 300, 50, 3);

        Enemy[] enemies = new Enemy[2];
        enemies[0] = new Zombie(100, 10);
        enemies[1] = new Vampire(80, 20);

        int numberOfMoves = 0;
        while (checkLive(warrior) && checkLive(enemies)) {
            fight(enemies, warrior);
            numberOfMoves++;
        }
        if (checkLive(warrior) == true) {
            System.out.print("heroes win. Step : " + numberOfMoves);
        } else {
            System.out.println("heroes dead. Step : " + numberOfMoves);
        }
    }

    private static void fight2() {
        System.out.println("Fight 2");
        Mage mage = new Mage("MyMage", 100, 40, 20);

        Enemy[] enemies = new Enemy[2];
        enemies[0] = new Zombie(100, 10);
        enemies[1] = new Vampire(80, 20);

        int numberOfMoves = 0;
        while (checkLive(mage) && checkLive(enemies)) {
            fight(enemies, mage);
            numberOfMoves++;
        }
        if (checkLive(mage) == true) {
            System.out.print("heroes win. Step : " + numberOfMoves);
        } else {
            System.out.println("heroes dead. Step : " + numberOfMoves);
        }
    }

    private static void fight3() {
        System.out.println("Fight 3");
        Archer archer = new Archer("MyWarrior", 200, 50);

        Enemy[] enemies = new Enemy[2];
        enemies[0] = new Zombie(100, 10);
        enemies[1] = new Vampire(80, 20);

        int numberOfMoves = 0;
        while (checkLive(archer) && checkLive(enemies)) {
            fight(enemies, archer);
            numberOfMoves++;
        }
        if (checkLive(archer) == true) {
            System.out.print("heroes win. Step : " + numberOfMoves);
        } else {
            System.out.println("heroes dead. Step : " + numberOfMoves);
        }
    }
}
