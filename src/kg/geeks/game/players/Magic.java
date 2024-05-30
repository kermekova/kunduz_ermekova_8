package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private int damageBoost = 0;
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
damageBoost+= RPG_Game.random.nextInt(5)+1;
for(Hero hero: heroes) {
    hero.setDamage(hero.getDamage()+ damageBoost);
    System.out.println("Magic " + this.getName() + " boosted damage for all heroes");
}
    }
}