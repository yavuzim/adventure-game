package AdventureGame;

public abstract class Weapon {
    private int id;
    private String weaponName;
    private int damage;
    private int money;

    public Weapon(int id, String weaponName, int damage, int money) {
        this.id = id;
        this.weaponName = weaponName;
        this.damage = damage;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }
}
