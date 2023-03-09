package AdventureGame;

public class Draw {
    private String draw;

    public Draw(String draw) {
        this.draw = draw;
        for (int i = 1; i < 67; i++)
            System.out.print(this.draw);
        System.out.println();
    }
}
