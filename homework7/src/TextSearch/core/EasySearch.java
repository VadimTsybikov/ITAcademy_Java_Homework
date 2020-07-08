package TextSearch.core;

public class EasySearch implements ISearchEngine {
    private static final String wordSeparators = " ,.:;!?\"()";      //символы-разделители слов

    @Override
    public int search(String[] source, String toFind) {
        int foundCnt = 0;
        for (String str : source) {
            if (!str.isEmpty()) {
                //выравнивание регистра для case-insensitive search
                str = str.toLowerCase();
                toFind = toFind.toLowerCase();

                int foundPos = 0;
                do {
                    foundPos = str.indexOf(toFind.toLowerCase(), foundPos);
                    if (foundPos > -1) {
                        //начало слова отделено от остальных слов?
                        boolean isStartsAlone = (foundPos == 0) || ((foundPos > 0) && (wordSeparators.indexOf(str.charAt(foundPos - 1)) > -1));
                        //конец слова отделен от остальных слов?
                        boolean isEndsAlone = (foundPos + toFind.length() == str.length()) || (wordSeparators.indexOf(str.charAt(foundPos + toFind.length())) > -1);
                        //если да - это наше слово, увеличить счетчик слов
                        if (isStartsAlone && isEndsAlone) {
                            foundCnt++;
                        }
                        //переходим за конец найденного слова для продолжения поиска
                        foundPos += toFind.length();
                    }
                } while (foundPos > -1);
                //повторять все это, пока в оставшейса части строки есть искомое слова
            }
        }
        return foundCnt;
    }
}