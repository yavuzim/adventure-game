import java.util.Random;
import java.util.Scanner;

public class Game {
    Player player;
    GameCharacter gameCharacter;
    Place place;
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
        System.out.println("************************** MACERA OYUNU MENU **************************");
        String logOut = "e";
        while (!logOut.equals("q")) {
            System.out.print("Oyunu Kapatmak İçin q, karakter seçimi yapmak için e tuşuna basınız : ");
            logOut = input.nextLine();
            if (!logOut.equals("q")) {
                System.out.println("Lütfen Karakter Seçimi Yapınız!");
                GameCharacter[] gameCharacters = {new Samurai(), new Archer(), new Knight()};
                this.characterList(gameCharacters);
                System.out.print("Karakter ID : ");
                int charId = input.nextInt();
                for (int i = 0; i < gameCharacters.length; i++)
                    if (charId == gameCharacters[i].getId()) {
                        gameCharacter = gameCharacters[i];
                    }
                System.out.println("Seçilen Karakter : \n ID : " + gameCharacter.getId()
                        + " Adı : " + gameCharacter.getCharName()
                        + " Hasar : " + gameCharacter.getDamage()
                        + " Sağlık : " + gameCharacter.getHealth()
                        + " Para : " + gameCharacter.getMoney());
                System.out.println("....................................................");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("------------------------------------------------------------------");
                System.out.println("*** OYUN BAŞLADI ***");
                System.out.println("....................................................");
                System.out.println("-Gideceğiniz Yeri Seçin.-");
                Place[] places = {new SafeHouse(gameCharacter), new Cave(gameCharacter), new Woods(gameCharacter), new River(gameCharacter), new Store(gameCharacter)};
                String placeId = "1";
                input.nextLine();
                while (!placeId.equals("q")) {
                    this.placeList(places);
                    System.out.print("Lütfen Mekan Seçin veya Oyunu Sonlandırın : ");
                    placeId  = input.nextLine();
                    if (!placeId.equals("q")) {
                        for (int i = 0; i < places.length; i++) {
                            if (Integer.valueOf(placeId) == places[i].getId()) {
                                place = places[i];
                            }
                        }
                        place.gameStart(place, gameCharacter);
                        if (gameCharacter.isDead() == false) {
                            System.out.println("ÖLDÜNÜZ!!!!");
                            break;
                        }
                    }
                }
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("------------------------------------------------------------------");
            }
        }
        System.out.println("OYUNDAN ÇIKIŞ YAPILDI.");
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

    private void placeList(Place[] places) {
        for (Place place : places) {
            System.out.println("ID : " + place.getId()
                    + "\t\tAd : " + place.getPlaceName());
        }
        System.out.println("-- OYUNU SONLANDIR (q)");
    }
}
