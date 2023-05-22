public class SafeHouse extends Place{
    public SafeHouse(GameCharacter gameCharacter) {
        super(1, "Güvenli Ev", "Güvenli Evde Canınız Yenilenir.",gameCharacter);
    }
    @Override
    public void gameStart(Place place, GameCharacter gameCharacter) {
        System.out.println(place.getExplanation());
        if(gameCharacter.getHEALTH()!=gameCharacter.getHealth()){
            System.out.println("+"+(gameCharacter.getHEALTH() - gameCharacter.getHealth())+" can yüklendi!");
            gameCharacter.setHealth(gameCharacter.getHEALTH());
            System.out.println("CANINIZ YENİLENDİ");
        }
        else {
            System.out.println("Canınız Zaten Full");
        }

    }

    @Override
    public void wareList() {

    }
}
