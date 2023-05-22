public class Woods extends Place{
    public Woods(GameCharacter gameCharacter) {
        super(3, "Orman", "Dikkat ormanda odun toplarken dikaktli ol vampirler saldırabilir. Vampirleri öldürerek paralarını ve ganimetleri alabilirsin.",gameCharacter);
    }
    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
    }

    @Override
    public void wareList() {

    }
}
