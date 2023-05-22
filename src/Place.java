public abstract class Place {
    private int id;
    private String placeName;
    private String explanation;

    public Place(int id, String placeName, String explanation) {
        this.id = id;
        this.placeName = placeName;
        this.explanation = explanation;
    }
}
