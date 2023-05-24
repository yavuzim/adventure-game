import java.util.Random;
import java.util.Scanner;

public class Woods extends Place {
    private String[] woods;
    private int vampireCount;
    Scanner input = new Scanner(System.in);

    public Woods(GameCharacter gameCharacter) {
        super(3, "Orman", "Dikkat ormanda odun toplarken dikaktli ol vampirler saldırabilir. Vampirleri öldürerek paralarını ve ganimetleri alabilirsin.", gameCharacter);
    }

    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
        this.vampireCount = 3;
        int defence = 0;
        if (gameCharacter.getArmor() != null)
            defence = gameCharacter.getArmor().getDefence();
        System.out.println("Dikkat!!!! Ormanda " + this.vampireCount + " Tane Vampir Var!");
        int rnd;
        String output = "e";
        Random random = new Random();
        while (!output.equals("q")) {
            System.out.print("Ormandan Çıkmak İçin q, ormanda kalmak için e tuşuna basınız : ");
            output = input.nextLine();
            if (!output.equals("q")) {
                if (this.vampireCount > 0)
                    rnd = random.nextInt(0, 2);
                else rnd = 0;
                if (rnd == 0) { // 0 ise odun toplayacakç
                    this.wareList();
                    int count = random.nextInt(0, woods.length);
                    System.out.println(woods[count] + " eşyası alındı!");
                } else { // 1 ise vampir saldırısı olacak.
                    if (this.vampireCount > 0) {
                        Vampire vampire = new Vampire();
                        System.out.println("********************************");
                        System.out.println("EYVAH VAMPİR SALDIRISI!!!");
                        System.out.println("Canavar : " + vampire.getCharName()
                                + " - Hasar : " + vampire.getDamage()
                                + " - Sağlık : " + vampire.getHealth()
                                + " - Para : " + vampire.getMoney());
                        System.out.println("********************************");
                        while (true) {
                            input.nextLine();
                            int n = random.nextInt(0, 2);
                            if (n == 0) {
                                // vampir darbe alacak.
                                if (gameCharacter.getGun() != null) {
                                    System.out.println("Elinizde " + gameCharacter.getGun().getGunName() + " var.");
                                    System.out.println("Zombiye Bir Darbe Vurdunuz!");
                                    vampire.setHealth(vampire.getHealth() - gameCharacter.getGun().getDamage());
                                } else {
                                    System.out.println("Elinizde Silah Yok!");
                                    System.out.println("Zombiye Bir Darbe Vurdunuz!");
                                    vampire.setHealth(vampire.getHealth() - gameCharacter.getDamage());
                                }
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tVampirin Canı : " + vampire.getHealth());
                                if (vampire.getHealth() <= 0) {
                                    this.vampireCount--;
                                    System.out.println("Vampiri Öldürdünüz!");
                                    if (this.vampireCount > 0)
                                        System.out.println("Ormandaki " + this.vampireCount + " Tane Vampir Kaldı.");
                                    else System.out.println("Ormandaki Vampirlerin Hepi Öldü!");
                                    gameCharacter.setMoney(gameCharacter.getMoney() + vampire.getMoney());
                                    break;
                                }
                            } else {
                                // biz darbe alacağız.
                                System.out.println("Vampirden darbe yediniz!");
                                if (defence > 0) {
                                    System.out.println("Zırhınızın Sağlığı : "+gameCharacter.getArmor().getDefence());
                                    defence--;
                                    if (defence <= 0) {
                                        gameCharacter.setArmor(null);
                                        System.out.println("Zırhınız Parçalandı");
                                    }
                                }else{
                                    gameCharacter.setHealth(gameCharacter.getHealth() - vampire.getDamage());
                                }
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tVampirin Canı : " + vampire.getHealth());
                                if (gameCharacter.getHealth() <= 0) {
                                    gameCharacter.setDead(false);
                                    break;
                                }
                            }
                        }
                    } else System.out.println("Zombi Kalmadı!");
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
        woods = new String[]{"Meşe","Çam"};
        for (int i = 0; i < woods.length; i++) {
            System.out.println((i + 1) + " - " + woods[i]);
        }
    }
}
