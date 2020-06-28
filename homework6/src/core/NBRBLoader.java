package core;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" + currencyName.getId(), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        int contentStart = content.indexOf('{') + 1;
        int endStart = content.lastIndexOf('}');
        String pureContent = content.substring(contentStart, endStart);

        for (String part : pureContent.split(",")) {
            String[] parts = part.split(":");
            if (parts[0].equals("\"Cur_OfficialRate\"")) {
                String currencyStr = parts[1];
                return Double.parseDouble(currencyStr);
            }
        }
        return 0;
    }
}