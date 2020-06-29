package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта БПС-Сбербанка
 */
public class BelAgroPromBankLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://belapb.by/ExCardsDaily.php?ondate=06/29/2020", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        //поиск тэга с наименованием валюты
        String curNameTagPattern = "<CharCode>" + currencyName + "</CharCode>";
        Matcher currencyNameDivMatcher = Pattern.compile(curNameTagPattern).matcher(content);
        if (currencyNameDivMatcher.find()) {
            //поиск тэга с курсом валюты
            String rateDivPattern = "<RateBuy>(\\d+).(\\d+)</RateBuy>";
            Matcher rateDivMatcher = Pattern.compile(rateDivPattern).matcher(content);
            if (rateDivMatcher.find(currencyNameDivMatcher.end())) {
                //извлечение курса из тэга
                String ratePattern = "(\\d+).(\\d+)";
                Matcher rateMatcher = Pattern.compile(ratePattern).matcher(content);
                if (rateMatcher.find(rateDivMatcher.start())) {
                    String rate = content.substring(rateMatcher.start(), rateMatcher.end());
                    return Double.parseDouble(rate);
                }
            }
        }
        return 0;
    }
}