package AdventureGame;

import java.util.Scanner;

public class Player {
    private int damage; // hasar
    private int health; // sağlık;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        GameChar[] gameChars = {new Samurai(), new Knight(), new Archer()};
        System.out.println("############################################################");
        System.out.println("\t\t\t** KARAKTERLER ** ");
        for (GameChar gameChar : gameChars) {
            charPrint(gameChar);
        }
        System.out.println("############################################################");
        System.out.print("Karakter Seç : ");
        int selectChar = input.nextInt();
        if (selectChar > 0 && selectChar < gameChars.length + 1)
            initPlayer(gameChars[selectChar - 1]);
        else System.out.println("Hatalı!!");
    }

    private void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        charPrint(gameChar);
    }

    private void charPrint(GameChar gameChar) {
        System.out.println("Karakter : " + gameChar.getName()
                + " \t Hasar : " + gameChar.getDamage()
                + " \t Sağlık : " + gameChar.getHealth()
                + " \t Para : " + gameChar.getMoney());
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
