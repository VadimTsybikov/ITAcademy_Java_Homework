import core.*;

public class Test {
    public static void main(String[] args) {
        SiteLoader loader = new BPSSberbankLoader();
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
    }
}