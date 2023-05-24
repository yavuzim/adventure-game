import java.util.Random;
import java.util.Scanner;

public class River extends Place {
    private String[] water;
    private int bearCount;
    Scanner input = new Scanner(System.in);

    public River(GameCharacter gameCharacter) {
        super(4, "Nehir", "Dikkat nehirde su içerken dikaktli ol ayılar saldırabilir. Ayılar öldürerek para ödülü kazanır ve ganimetleri alabilirsin.", gameCharacter);
    }

    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
        this.bearCount = 3;
        int defence = 0;
        if (gameCharacter.getArmor() != null)
            defence = gameCharacter.getArmor().getDefence();
        System.out.println("Dikkat!!!! Nehir Çevresinde " + this.bearCount + " Tane Ayı Var!");
        int rnd;
        String output = "e";
        Random random = new Random();
        while (!output.equals("q")) {
            System.out.print("Nehirden Çıkmak İçin q, nehirde kalmak için e tuşuna basınız : ");
            output = input.nextLine();
            if (!output.equals("q")) {
                if (this.bearCount > 0)
                    rnd = random.nextInt(0, 2);
                else rnd = 0;
                if (rnd == 0) { // 0 ise eşya toplayacakç
                    this.wareList();
                    int count = random.nextInt(0, water.length);
                    System.out.println(water[count] + " eşyası alındı!");
                } else { // 1 ise ayı saldırısı olacak.
                    if (this.bearCount > 0) {
                       Bear bear = new Bear();
                        System.out.println("********************************");
                        System.out.println("EYVAH AYI SALDIRISI!!!");
                        System.out.println("Canavar : " + bear.getCharName()
                                + " - Hasar : " + bear.getDamage()
                                + " - Sağlık : " + bear.getHealth()
                                + " - Para : " + bear.getMoney());
                        System.out.println("********************************");
                        while (true) {
                            input.nextLine();
                            int n = random.nextInt(0, 2);
                            if (n == 0) {
                                // zombi darbe alacak.
                                if (gameCharacter.getGun() != null) {
                                    System.out.println("Elinizde " + gameCharacter.getGun().getGunName() + " var.");
                                    System.out.println("Ayıya Bir Darbe Vurdunuz!");
                                    bear.setHealth(bear.getHealth() - gameCharacter.getGun().getDamage());
                                } else {
                                    System.out.println("Elinizde Silah Yok!");
                                    System.out.println("Ayıya Bir Darbe Vurdunuz!");
                                    bear.setHealth(bear.getHealth() - gameCharacter.getDamage());
                                }
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tAyının Canı : " + bear.getHealth());
                                if (bear.getHealth() <= 0) {
                                    this.bearCount--;
                                    System.out.println("Ayıyı Öldürdünüz!");
                                    if (this.bearCount > 0)
                                        System.out.println("Mağarada " + this.bearCount + " Tane Ayı Kaldı.");
                                    else System.out.println("Mağaradaki Ayıların Hepi Öldü!");
                                    gameCharacter.setMoney(gameCharacter.getMoney() + bear.getMoney());
                                    break;
                                }
                            } else {
                                // biz darbe alacağız.
                                System.out.println("Ayıdan darbe yediniz!");
                                if (defence > 0) {
                                    System.out.println("Zırhınızın Sağlığı : " + gameCharacter.getArmor().getDefence());
                                    defence--;
                                    if (defence <= 0) {
                                        gameCharacter.setArmor(null);
                                        System.out.println("Zırhınız Parçalandı");
                                    }
                                } else {
                                    gameCharacter.setHealth(gameCharacter.getHealth() - bear.getDamage());
                                }
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tAyının Canı : " + bear.getHealth());
                                if (gameCharacter.getHealth() <= 0) {
                                    gameCharacter.setDead(false);
                                    break;
                                }
                            }
                        }
                    } else System.out.println("Ayı Kalmadı!");
                    if (gameCharacter.isDead() == false) {
                        break;
                    } else {
                        System.out.println("Paranız arttı! Paranız : " + gameCharacter.getMoney());
                    }
                }
            }
        }
    }

    @Override
    public void wareList() {
        System.out.println("Su");
    }
}
