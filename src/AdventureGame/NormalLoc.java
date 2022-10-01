package AdventureGame;

public abstract class NormalLoc extends Location{
    private int id;
    public NormalLoc(Player player,int id, String name) {
        super(player, name);
        this.id = id;

    }
        @Override
    public boolean onLocation() {
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
