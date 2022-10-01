package AdventureGame;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player,1, "Güvenli Ev");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz!");
        System.out.println("Canınız Yenilendi!");
        return true;
    }
}
