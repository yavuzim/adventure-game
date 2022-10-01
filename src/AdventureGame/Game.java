package AdventureGame;

import java.util.Scanner;

public class Game  {
    public static Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen Bir İsim Giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Merhaba "+player.getName()+", bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        player.characters();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("*** Lütfen Bir Karakter Seçiniz ***");
        System.out.print("Karaket Numarası : ");
        int charId = input.nextInt();
        player.selectChar(charId);
        System.out.println("---------------------------------------------------------------------------------------------");
        player.normalLocations();
        System.out.println("---------------------------------------------------------------------------------------------");
        while (true){
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
            int locId = input.nextInt();
            boolean control = player.selectLoc(locId);
            if(!control) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
