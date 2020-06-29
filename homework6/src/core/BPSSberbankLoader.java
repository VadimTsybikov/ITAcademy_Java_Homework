package core;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта БПС-Сбербанка
 */
public class BPSSberbankLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://www.bps-sberbank.by/page/currency-exchange-cards", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        //поиск блока с конверсиями
        int ratesDivPos = content.indexOf("<div class=\"TableDepartmentExchangeRates\">");
        if (ratesDivPos > -1) {
            //поиск строки с нужным наименованием валюты
            while (true) {
                //поиск блока с наименованием валюты
                String curNameDivPattern = "<span class=\"nameOfCurrency\"> (\\d+) " + currencyName + "</span>";
                Matcher currencyNameDivMatcher = Pattern.compile(curNameDivPattern).matcher(content);
                if (currencyNameDivMatcher.find(ratesDivPos)) {
                    //поиск блока с курсом валюты
                    String rateDivPattern = "<div class=\"currency\"><span>(\\d+),(\\d+)</span><span>(\\d+),(\\d+)</span></div>";
                    Matcher rateDivMatcher = Pattern.compile(rateDivPattern).matcher(content);
                    if (rateDivMatcher.find(currencyNameDivMatcher.end())) {
                        //извлечение курса из блока
                        String ratePattern = "(\\d+),(\\d+)";
                        Matcher rateMatcher = Pattern.compile(ratePattern).matcher(content);
                        if (rateMatcher.find(rateDivMatcher.start())) {
                            String rate = content.substring(rateMatcher.start(), rateMatcher.end()).replace(',', '.');
                            return Double.parseDouble(rate);
                        }
                    }
                }
            }
        }
        return 0;
    }
}