public abstract class GameCharacter {
    private int id;
    private String charName;
    private int damage; // hasar
    private int health; // sağlık
    private int money;

    public GameCharacter(int id, String charName, int damage, int health, int money) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
