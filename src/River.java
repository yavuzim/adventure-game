public class River extends Place{
    public River(GameCharacter gameCharacter) {
        super(4, "Nehir", "Dikkat nehirde su içerken dikaktli ol ayılar saldırabilir. Ayılar öldürerek para ödülü kazanır ve ganimetleri alabilirsin.",gameCharacter);
    }
    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
    }

    @Override
    public void wareList() {

    }
}
