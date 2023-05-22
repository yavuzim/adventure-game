public abstract class Place {
    private int id;
    private String placeName;
    private String explanation;
    GameCharacter gameCharacter;

    public Place(int id, String placeName, String explanation,GameCharacter gameCharacter) {
        this.id = id;
        this.placeName = placeName;
        this.explanation = explanation;
        this.gameCharacter = gameCharacter;
    }
    public abstract void gameStart(Place place,GameCharacter gameCharacter);
    public abstract void wareList();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
