package AdventureGame;

public abstract class Monsters {
    private int id;
    private String monsterName;
    private int damage;
    private int health;
    private int money;

    public Monsters(int id, String monsterName, int damage, int health, int money) {
        this.id = id;
        this.monsterName = monsterName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
}
