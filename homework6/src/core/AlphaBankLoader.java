package core;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта Альфа-банк
 */
public class AlphaBankLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        //извлечение массива данных о валютах из полученных данных (между квадратными скобками)
        int contentStart = content.indexOf('[') + 1;
        int endStart = content.lastIndexOf(']');
        String allCurrenciesInfo = content.substring(contentStart, endStart);

        //обработка каждого блока информации о валюте
        while (allCurrenciesInfo.length() > 0) {
            //извлечение очередного блока между фигурными скобками и удаление из полной строки
            contentStart = allCurrenciesInfo.indexOf('{');
            endStart = allCurrenciesInfo.indexOf('}', contentStart) + 1;
            String pureCurrencyInfo = allCurrenciesInfo.substring(contentStart, endStart);
            allCurrenciesInfo = allCurrenciesInfo.substring(endStart);

            //проверка соответствия блока необходимой конверсии (currencyName->BYN)
            if ((pureCurrencyInfo.indexOf("\"sellIso\":\"" + currencyName + "\"") > -1) &&
                    (pureCurrencyInfo.indexOf("\"buyIso\":\"BYN\"") > -1)) {
                //извлечение курса конверсии из блока
                Matcher sellRateMatcher = Pattern.compile("\"sellRate\":(\\d+).(\\d+)").matcher(pureCurrencyInfo);
                if (sellRateMatcher.find()) {
                    String sellRate = pureCurrencyInfo.substring(sellRateMatcher.start(), sellRateMatcher.end()).split(":")[1];
                    return Double.parseDouble(sellRate);
                }
            }
        }
        return 0;
    }
}