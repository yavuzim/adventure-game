public abstract class GameCharacter {
    private int id;
    private String charName;
    private int damage; // hasar
    private final int HEALTH; // sabit sağlık
    private int health; // sağlık
    private final int MONEY;
    private int money;
    private boolean isDead;
    private Gun gun;
    private Armor armor;

    public GameCharacter(int id, String charName, int damage, int HEALTH, int health,int MONEY, int money, boolean isDead, Gun gun, Armor armor) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.HEALTH = HEALTH;
        this.health = health;
        this.MONEY = money;
        this.money = money;
        this.isDead = isDead;
        this.gun = gun;
        this.armor = armor;
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

    public int getHEALTH() {
        return HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMONEY() {
        return MONEY;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
