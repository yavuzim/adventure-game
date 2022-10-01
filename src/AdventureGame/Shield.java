package AdventureGame;

public abstract class Shield {
    private int id;
    private String name;
    private int health;
    private int price;

    public Shield(int id, String name, int health, int price) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
