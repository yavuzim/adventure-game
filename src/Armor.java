public abstract class Armor {
    private int id;
    private String armorName;
    private int defence;
    private int money;

    public Armor(int id, String armorName, int defence, int money) {
        this.id = id;
        this.armorName = armorName;
        this.defence = defence;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getArmorName() {
        return armorName;
    }

    public int getDefence() {
        return defence;
    }

    public int getMoney() {
        return money;
    }
}
