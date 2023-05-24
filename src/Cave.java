import java.util.Random;
import java.util.Scanner;

public class Cave extends Place {
    private String[] foods;
    private int zombieCount;
    Scanner input = new Scanner(System.in);

    public Cave(GameCharacter gameCharacter) {
        super(2, "Mağara", "Mağarada yemek ararken dikaktli ol zombiler saldırabilir. Zobileri öldürerek paralarını ve ganimetleri alabilirsin.", gameCharacter);
    }

    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        this.zombieCount = 3;
        System.out.println("Dikkat!!!! Mağarada " + this.zombieCount + " Tane Zombi Var!");
        int rnd;
        System.out.println(place.getExplanation());
        String output = "e";
        Random random = new Random();
        while (!output.equals("q")) {
            System.out.print("Mağaradan Çıkmak İçin q, mağarada kalmak için e tuşuna basınız : ");
            output = input.nextLine();
            if (!output.equals("q")) {
                if (this.zombieCount > 0)
                    rnd = random.nextInt(0, 2);
                else rnd = 0;
                if (rnd == 0) {
                    this.wareList();
                    int count = random.nextInt(0, foods.length);
                    System.out.println(foods[count] + " eşyası alındı!");
                } else {
                    if (this.zombieCount > 0) {
                        Zombie zombie = new Zombie();
                        System.out.println("********************************");
                        System.out.println("EYVAH ZOMBİ SALDIRISI!!!");
                        System.out.println("Canavar : " + zombie.getCharName()
                                + " - Hasar : " + zombie.getDamage()
                                + " - Sağlık : " + zombie.getHealth()
                                + " - Para : " + zombie.getMoney());
                        System.out.println("********************************");
                        while (true) {
                            input.nextLine();
                            int n = random.nextInt(0, 2);
                            if (n == 0) {
                                // zombi darbe alacak.
                                System.out.println("Zombiye Bir Darbe Vurdunuz!");
                                zombie.setHealth(zombie.getHealth() - gameCharacter.getDamage());
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tZombinin Canı : " + zombie.getHealth());
                                if (zombie.getHealth() <= 0) {
                                    this.zombieCount--;
                                    System.out.println("Zombiyi Öldürdünüz!");
                                    if (this.zombieCount > 0)
                                        System.out.println("Mağarada " + this.zombieCount + " Tane Zombi Kaldı.");
                                    else System.out.println("Mağaradaki Zombilerin Hepi Öldü!");
                                    gameCharacter.setMoney(gameCharacter.getMoney() + zombie.getMoney());
                                    break;
                                }
                            } else {
                                // biz darbe alacağız.
                                System.out.println("Zombiden darbe yediniz!");
                                gameCharacter.setHealth(gameCharacter.getHealth() - zombie.getDamage());
                                System.out.println("Canınız : " + gameCharacter.getHealth() + "\tZombinin Canı : " + zombie.getHealth());
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
        foods = new String[]{"Et", "Fasulye", "Lahana", "Domates", "Salatalık", "Elma", "Portakal"};
        for (int i = 0; i < foods.length; i++) {
            System.out.println((i + 1) + " - " + foods[i]);
        }
    }
}
