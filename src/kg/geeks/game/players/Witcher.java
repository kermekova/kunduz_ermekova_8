package kg.geeks.game.players;

public class Witcher extends Hero {
    private boolean isDead = false;
    private Hero revivedHero = null;

    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.REVIVE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (isDead) return;

        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0 && revivedHero == null) {
                revivedHero = hero;
                break;
            }
        }

        if (revivedHero != null) {
            revivedHero.setHealth(revivedHero.getHealth() + this.getHealth());
            this.setHealth(0);
            isDead = true;
            System.out.println("Witcher " + this.getName() + " revived " + revivedHero.getName());
        } else {
            // Takes damage from boss
            this.setHealth(this.getHealth() - boss.getDamage());
            System.out.println("Witcher " + this.getName() + " took damage from boss");
        }
    }
}

