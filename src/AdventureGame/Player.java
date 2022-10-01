package AdventureGame;

import java.util.Scanner;

public class Player {
    private int id;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private String name;
    private int locId;
    private String locName;

    public Player(String name) {
        this.name = name;
    }

    GameChar[] gameChars;
    int[] a;

    public void characters() {
        gameChars = new GameChar[]{new Archer(), new Knight(), new Samurai()};
        System.out.println("-- KARAKTERLER --");
        for (GameChar gameChar : gameChars) {
            System.out.println("ID : " + gameChar.getId()
                    + "\t\tKarakter : " + gameChar.getName()
                    + "\t\t Hasar : " + gameChar.getDamage()
                    + "\t\t Sağlık : " + gameChar.getHealth()
                    + "\t\t Para : " + gameChar.getMoney());
        }
    }

    GameChar gameChar = null;

    public void selectChar(int id) {
        switch (id) {
            case 1:
                gameChar = initPlayer(new Samurai());
                break;
            case 2:
                gameChar = initPlayer(new Archer());
                break;
            case 3:
                gameChar = initPlayer(new Knight());
                break;
            default:
                gameChar = initPlayer(new Samurai());
                break;
        }
    }

    private GameChar initPlayer(GameChar gameChar) {
        this.setId(gameChar.getId());
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        return gameChar;
    }

    public void normalLocations() {
        System.out.println("** Bölgeler **");
        NormalLoc[] locations = {new SafeHouse(this), new ToolStore(this)};
        for (NormalLoc location : locations) {
            System.out.println("ID : " + location.getId()
                    + "\t\t Bölge : " + location.getName());
        }
    }

    public boolean selectLoc(int id) {
        NormalLoc normalLoc = null;
        boolean control = true;
        switch (id) {
            case 1:
                SafeHouse safeHouse = new SafeHouse(this);
                normalLoc = safeHouse;
                normalLoc.onLocation();
                break;
            case 2:
                ToolStore toolStore = new ToolStore(this);
                normalLoc = toolStore;
                control = normalLoc.onLocation();
                toolStore.tools();
                System.out.print("Alacağınız Nesne : ");
                int toolId = Game.input.nextInt();
                toolStore.selectTool(toolId);
                break;
            default:
                normalLoc = new SafeHouse(this);
                break;
        }
        System.out.println("ID : " + gameChar.getId()
                + "\t\tKarakter : " + gameChar.getName()
                + "\t\t Hasar : " + gameChar.getDamage()
                + "\t\t Sağlık : " + gameChar.getHealth()
                + "\t\t Para : " + gameChar.getMoney());

        System.out.println("ID : " + normalLoc.getId()
                + "\t\t Seçilen Bölge : " + normalLoc.getName());

        if (!control) {
            control = false;
        }
        return control;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
}
