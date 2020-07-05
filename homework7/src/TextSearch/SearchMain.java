package TextSearch;

import TextSearch.core.EasySearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SearchMain {
    public static void main(String[] args) {
        String execPath = Paths.get("").toAbsolutePath().toString();
        String filePath = execPath + "\\Война и мир.txt";
        String[] lines = readAllBytesJava7(filePath).split("\n");

        //определение количества слов
        EasySearch easySearch = new EasySearch();
        System.out.println("Количество слов \"война\": " + easySearch.search(lines, "война"));
        System.out.println("Количество слов \"и\": " + easySearch.search(lines, "и"));
        System.out.println("Количество слов \"мир\": " + easySearch.search(lines, "мир"));
        System.out.println();

        //определение слов, использованных в тексте
        HashSet<String> usedWords = new HashSet<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                String[] words = line.split("\\P{L}+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        usedWords.add(word);
                    }
                }
            }
        }
        System.out.println("Количество уникальных слов в тексте: " + usedWords.size());
        System.out.println();

        //подсчет количества появления слов в тексте
        HashMap<String, Integer> usedWordsCnt = new HashMap<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                String[] words = line.split("\\P{L}+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (!usedWordsCnt.containsKey(word)) {
                            usedWordsCnt.put(word, 1);
                        } else {
                            Integer curCnt = usedWordsCnt.get(word) + 1;
                            usedWordsCnt.replace(word, curCnt);
                        }
                    }
                }
            }
        }
        //сортировка по убыванию количества
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(usedWordsCnt.entrySet());
        Collections.sort(sortedEntries,
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            }
        );
        //вывод ТОП-10
        System.out.println("ТОП 10 слов, появившихся в романе \"Война и мир\":");
        for(int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> item = sortedEntries.get(i);
            System.out.printf("%d. %s - %d раз\n", i + 1, item.getKey(), item.getValue());
        }
    }

    //чтение файла
    private static String readAllBytesJava7(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}