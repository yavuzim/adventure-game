import java.util.Scanner;

public class Store extends Place {
    private Gun[] guns;
    private Armor[] armors;
    Scanner input = new Scanner(System.in);

    public Store(GameCharacter gameCharacter) {
        super(5, "Mağaza", "Mağazan Silah ve Zırh Satın Alabilirsin.", gameCharacter);
        guns = new Gun[]{new Pistol(), new Rifle(), new Sword()};
        armors = new Armor[]{new Mild(), new Middle(), new Heavy()};
    }

    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
        wareList();
        String select = "";
        while ((!select.equals("s") && !select.equals("S")) && (!select.equals("z") && !select.equals("Z"))) {
            System.out.println("Silah Seçimi İçin s, zırh seçimi z tuşuna basınız.");
            System.out.print("Seç : ");
            select = input.nextLine();
            if (select.equals("s") || select.equals("S"))
                selectGun(gameCharacter);
            else if (select.equals("z") || select.equals("Z"))
                selectArmor(gameCharacter);
            else System.out.println("Yanlış Tuşlama!");
        }
        System.out.println("Mağazadan Çıktınız!");
    }

    @Override
    public void wareList() {
        System.out.println("********** SİLAHLAR **********");
        for (Gun gun : this.guns) {
            System.out.println("ID : " + gun.getId()
                    + "\t\tSilah : " + gun.getGunName()
                    + "\t\tHasar : " + gun.getDamage()
                    + "\t\tFiyat : " + gun.getMoney());
        }
        System.out.println("********** ZIRHLAR **********");

        for (Armor armor : armors) {
            System.out.println("ID : " + armor.getId()
                    + "\t\tZırh : " + armor.getArmorName()
                    + "\t\tEngelleme : " + armor.getDefence()
                    + "\t\tFiyat : " + armor.getMoney());
        }
    }

    private void gunList() {
        System.out.println("********** SİLAHLAR **********");
        for (Gun gun : this.guns) {
            System.out.println("ID : " + gun.getId()
                    + "\t\tSilah : " + gun.getGunName()
                    + "\t\tHasar : " + gun.getDamage()
                    + "\t\tFiyat : " + gun.getMoney());
        }
    }

    private void armorList() {
        System.out.println("********** ZIRHLAR **********");
        for (Armor armor : this.armors) {
            System.out.println("ID : " + armor.getId()
                    + "\t\tZırh : " + armor.getArmorName()
                    + "\t\tEngelleme : " + armor.getDefence()
                    + "\t\tFiyat : " + armor.getMoney());
        }
    }

    private boolean gunControl() {
        if (gameCharacter.getGun() == null)
            return true;
        return false;
    }

    private void selectGun(GameCharacter gameCharacter) {
        System.out.println("Silah Seçimi Yapınız");
        System.out.println();
        if (gunControl()) {
            System.out.println("Üzerinizde Silah Yok Silah Seçimi Yapmak İster Misiniz? (e/h)");
            System.out.print("Seç : ");
            String e_h = input.nextLine();
            if (e_h.equals("e")) {
                selectGun();
            } else System.out.println("Silah Alınmadı!");
        } else {
            System.out.println(gameCharacter.getGun().getGunName() + " silahını taşıyorsunuz!");
            System.out.println("Sadece Bir Silah Taşıyabilirsiniz. Elinizdeki Silahı Bırakıp Yeni Silah Almak İster Misin? (e/h)");
            System.out.print("Seç : ");
            String e_h = input.nextLine();
            if (e_h.equals("e")) {
                gameCharacter.setGun(null);
                selectGun();
            }
        }
    }

    private void selectGun() {
        gunList();
        System.out.println();
        System.out.println("Seçmek İstediğiniz Silahın ID Numrası : ");
        int id = input.nextInt();
        for (Gun gun : this.guns) {
            if (id == gun.getId()) {
                gameCharacter.setGun(gun);
                System.out.println("Seçilen Silah : " + gameCharacter.getGun().getGunName());
            }
        }

    }

    private boolean armorControl() {
        if (gameCharacter.getArmor() == null)
            return true;
        return false;
    }

    private void selectArmor(GameCharacter gameCharacter) {
        System.out.println("Zırh Seçimi Yapınız");
        System.out.println();
        if (armorControl() == true) {
            System.out.println("Zırhınız Yok, Zırh Seçimi Yapmak İster Misin? (e/h)");
            System.out.print("Seç : ");
            String e_h = input.nextLine();
            if (e_h.equals("e")) {
                selectArmor();
            } else {
                System.out.println("Zırh Seçimi Yapılmadı!");
            }
        } else {
            System.out.println(gameCharacter.getArmor().getArmorName() + " zırhını taşıyorsunuz!");
            System.out.println("Yeni Zırh Almak İçin Üzerinizdeki Zırhı Çıkarmanız Gerek. Yeni Zırh Almak İstiyor Musun? (e/h)");
            System.out.print("Seç : ");
            String e_h = input.nextLine();
            if (e_h.equals("e")) {
                gameCharacter.setArmor(null);
                selectArmor();
            }
        }
    }

    private void selectArmor() {
        armorList();
        System.out.println();
        System.out.println("Seçmek İstediğiniz Zırhın ID Numrası : ");
        int id = input.nextInt();
        for (Armor armor : this.armors) {
            if (id == armor.getId()) {
                gameCharacter.setArmor(armor);
                System.out.println("Seçilen Zırh : " + gameCharacter.getArmor().getArmorName());
            }
        }
    }
}
