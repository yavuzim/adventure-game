package AdventureGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player();
        System.out.print("Kullanıcı Adı : ");
        String userName = new Scanner(System.in).nextLine();
        player.setUserName(userName);
        game.welcome(player);
    }
}
