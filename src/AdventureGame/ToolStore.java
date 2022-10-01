package AdventureGame;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, 2, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        System.out.println("Silah ya da zırh alabilirsiniz!");
        return true;
    }

    public void tools() {
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
    }
    public void selectTool(int id) {
        switch (id) {
            case 1:
                selectWeapon();
                break;
            case 2:
                selectArmor();
                break;
        }
    }

    private void selectWeapon() {
        System.out.println("** SİLAHLAR **");
        Weapon[] weapons = {new Revolver(),new Sword(), new Rifle()};
        for(Weapon weapon : weapons){
            System.out.println("ID : "+weapon.getId()
            +"\t\t Silah : "+weapon.getName()
            +"\t\t Hasar : "+weapon.getDamage()
            +"\t\t Para : "+weapon.getPrice());
        }
        System.out.print("Lütfen Silah Seçiniz : ");
        int revolverId = Game.input.nextInt();
        switch (revolverId){
            case 1 : printWeapon(new Revolver()); break;
            case 2 : printWeapon(new Sword()); break;
            case 3: printWeapon(new Rifle()); break;
            default: printWeapon(new Revolver()); break;
        }
    }
    private void printWeapon(Weapon weapon){
        weapon.setId(weapon.getId());
        weapon.setName(weapon.getName());
        weapon.setDamage(weapon.getDamage());
        weapon.setPrice(weapon.getPrice());
        System.out.println("ID : "+weapon.getId()
        +"\t\t Silah : "+weapon.getName()
        +"\t\t Hasar : "+weapon.getDamage()
        +"\t\t Para : "+weapon.getPrice());

    }

    private void selectArmor() {
        System.out.println("** ZIRHLAR **");
    }
    private  void printArmor(Weapon weapon){

    }

}
