import core.*;

public class Test {
    public static void main(String[] args) {
        SiteLoader loader = new NBRBLoader();
        System.out.println(loader.getClass());
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
        System.out.println();

        loader = new AlphaBankLoader();
        System.out.println(loader.getClass());
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
        System.out.println();

        loader = new BelarusBankLoader();
        System.out.println(loader.getClass());
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
        System.out.println();

        loader = new BPSSberbankLoader();
        System.out.println(loader.getClass());
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
        System.out.println();

        loader = new BelAgroPromBankLoader();
        System.out.println(loader.getClass());
        System.out.println("EUR->BYN: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUS->BYN: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD->BYN: " + loader.load(SiteLoader.Currency.USD));
        System.out.println();
    }
}