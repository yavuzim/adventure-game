package AdventureGame;

import java.util.Scanner;

public class Game {
    private String draw;
    Player player;
    Scanner input = new Scanner(System.in);
    Characters[] characters;

    public Game(){
        draw = "****************************************************************************";
        System.out.println(this.draw);
        System.out.println("Macera Oyununa Hoşgeldiniz. Lütfen Kullanıcı Adınızı Girin!");
        System.out.println(this.draw);
        characters = new Characters[]{new Archer(),new Knight(), new Samurai()};
    }

    public void welcome(Player player){
        this.player = player;
        System.out.println("Kullanıcı Adınız -> "+this.player.getUserName());
        draw = "--------------------------------------------------------------------";
        System.out.println(this.draw);
        System.out.println("******** KARAKTER SEÇİN ********");
        characterList();
        Characters character = this.selectChar(this.characters);
        System.out.println("-Seçilen Karaker-");
        System.out.println("Karakter : "+character.getCharName()
                +"\t\t"+"Hasar : "+character.getDamage()
                +"\t\t"+"Sağlık : "+character.getHealth()
                +"\t\t"+"Para : "+character.getMoney());
        System.out.println(this.draw);
    }
    private Characters selectChar(Characters[] characters){
        System.out.print("Seçmek İstediğiniz Karakterin Numarasını Girin : ");
        int selectChar = input.nextInt();
        return characters[selectChar - 1];
    }
    private void characterList(){
        for(int i=1; i<=this.characters.length; i++){
            System.out.println("Karakter : "+this.characters[i-1].getCharName()
                    +"\t\t"+"Hasar : "+this.characters[i-1].getDamage()
                    +"\t\t"+"Sağlık : "+this.characters[i-1].getHealth()
                    +"\t\t"+"Para : "+this.characters[i-1].getMoney());
        }
    }
}
