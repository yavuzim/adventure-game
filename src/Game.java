import java.util.Random;
import java.util.Scanner;

public class Game {
    Player player;
    GameCharacter gameCharacter;
    Scanner input = new Scanner(System.in);

    public Game() {
        System.out.println("**************************************************************************************");
        System.out.println("****** MACERA OYUNUNA HOŞGELDİNİZ! ******");
        System.out.println("LÜTFEN KULLANICI ADINIZI GİRİN");
        this.login();
        System.out.println("ID : " + this.player.getId() + "\nKullanıcı Adı : " + this.player.getUsername());
        System.out.println("**************************************************************************************");
    }

    private void login() {
        player = new Player();
        Random random = new Random();
        System.out.print("Kullanıcı Adı : ");
        String username = input.nextLine();
        this.player.setUsername(username);
        this.player.setId(random.nextInt(1, 16000));
    }

    public void start() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("*** OYUN BAŞLADI ***");
        System.out.println("....................................................");
        System.out.println("Lütfen Karakter Seçimi Yapınız!");
        GameCharacter[] gameCharacters = {new Samurai(), new Archer(), new Knight()};
        this.characterList(gameCharacters);
        System.out.print("Karakter ID : ");
        int charId = input.nextInt();
        for (int i = 0; i < gameCharacters.length; i++)
            if (charId == gameCharacters[i].getId())
                gameCharacter = gameCharacters[i];
        System.out.println("Seçilen Karakter : \n ID : " + gameCharacter.getId() + " Adı : " + gameCharacter.getCharName() + " Hasar : " + gameCharacter.getDamage()
                + " Sağlık : " + gameCharacter.getHealth() + " Para : " + gameCharacter.getMoney());
        System.out.println("....................................................");

        System.out.println("------------------------------------------------------------------");
    }

    private void characterList(GameCharacter[] gameCharacters) {
        for (GameCharacter gameCharacter : gameCharacters) {
            System.out.println("ID : " + gameCharacter.getId()
                    + "\t\tAd : " + gameCharacter.getCharName()
                    + "\t\tHasar : " + gameCharacter.getDamage()
                    + "\t\tSağlık : " + gameCharacter.getHealth()
                    + "\t\tPara : " + gameCharacter.getMoney());
        }
    }
}
