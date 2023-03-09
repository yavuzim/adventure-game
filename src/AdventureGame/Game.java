package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.print("Lütfen İsim Giriniz : ");
        String playerName = input.nextLine();
        Player player  = new Player("playerName");

        System.out.println("Sayın "+player.getName()+" bu karanlık ve sisli adaya oyununa hoşgeldiniz!! Burada yaşananların hepsi gerçek!!");
        player.selectChar();
    }
}
