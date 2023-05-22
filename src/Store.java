public class Store extends Place{
    private String exp;
    public Store() {
        super(5, "Mağaza", "Mağazaya Hoşgeldin.");
        this.exp = "Mağazan Silah ve Zırh Satın Alabilirsin.";
        System.out.println(this.exp);
    }
}
