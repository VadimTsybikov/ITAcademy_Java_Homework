package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта Беларусбанка
 */
public class BelarusBankLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://belarusbank.by/api/kursExchange", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        //извлечение массива данных о филиалах банка из полученных данных (между квадратными скобками)
        int contentStart = content.indexOf('[') + 1;
        int endStart = content.lastIndexOf(']');
        String allDeptsInfo = content.substring(contentStart, endStart);

        //обработка каждого блока информации о филиале банка (пока обрабатывается только первый филиал)
        while (allDeptsInfo.length() > 0) {
            //извлечение очередного блока между фигурными скобками и удаление из полной строки
            contentStart = allDeptsInfo.indexOf('{');
            endStart = allDeptsInfo.indexOf('}', contentStart) + 1;
            String pureDeptInfo = allDeptsInfo.substring(contentStart, endStart);
            allDeptsInfo = allDeptsInfo.substring(endStart);

            //извлечение курса конверсии из блока
            Matcher sellRateMatcher = Pattern.compile("\"" + currencyName + "_out\":\"(\\d+).(\\d+)\"").matcher(pureDeptInfo);
            if (sellRateMatcher.find()) {
                String sellRate = pureDeptInfo.substring(sellRateMatcher.start(), sellRateMatcher.end()).split(":")[1].replace('"', '\0');
                return Double.parseDouble(sellRate);
            }
        }
        return 0;
    }
}