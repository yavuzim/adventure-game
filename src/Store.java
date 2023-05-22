public class Store extends Place{
    public Store(GameCharacter gameCharacter) {
        super(5, "Mağaza", "Mağazan Silah ve Zırh Satın Alabilirsin.",gameCharacter);
    }
    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
    }

    @Override
    public void wareList() {

    }
}
