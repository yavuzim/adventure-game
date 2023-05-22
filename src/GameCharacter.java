public abstract class GameCharacter {
    private int id;
    private String charName;
    private int damage; // hasar
    private final int HEALTH;
    private int health; // sağlık
    private int money;
    private boolean isDead;

    public GameCharacter(int id, String charName, int damage,int HEALT, int health, int money,boolean isDead) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.HEALTH = HEALT;
        this.health = health;
        this.money = money;
        this.isDead = isDead;
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
}
