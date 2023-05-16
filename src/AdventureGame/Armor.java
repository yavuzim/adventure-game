package AdventureGame;

public abstract class Armor {
    private int id;
    private String armorName;
    private int block;
    private int money;

    public Armor(int id, String armorName, int block, int money) {
        this.id = id;
        this.armorName = armorName;
        this.block = block;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getArmorName() {
        return armorName;
    }

    public int getBlock() {
        return block;
    }

    public int getMoney() {
        return money;
    }
}

