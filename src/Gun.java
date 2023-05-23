public abstract class Gun {
    private int id;
    private String gunName;
    private int damage;
    private int money;

    public Gun(int id, String gunName, int damage, int money) {
        this.id = id;
        this.gunName = gunName;
        this.damage = damage;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getGunName() {
        return gunName;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }
}
