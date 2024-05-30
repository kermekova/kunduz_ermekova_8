package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {
    private int healthSteal = 0;
    int roundCounter;

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HEALTH_STEAL);
        this.healthSteal= healthSteal;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        roundCounter++;
        if (roundCounter % 2 == 0) {
            boss.setHealth(boss.getHealth() - healthSteal);
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            randomHero.setHealth(randomHero.getHealth() + healthSteal);
            System.out.println("Hacker " + this.getName() + " stole health from boss and gave it to " + randomHero.getName());
        }

    }
}
