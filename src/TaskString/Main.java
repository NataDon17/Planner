package TaskString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void countWord(String s) {
        Stream<String> textStream = Arrays.stream(s.split("\\s+"));
        textStream
                .map(word -> word.replaceAll("[^A-Za-zА-Яа-яЁё]+", "").toLowerCase())
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                            int i = e2.getValue().compareTo(e1.getValue());
                            if (i == 0) {
                                i = e1.getKey().compareTo(e2.getKey());
                            }
                            return i;
                        }
                )
                .limit(10)
                .forEach(e -> System.out.println(e.getValue() + " " + e.getKey()));
    }

    public static void getQuantityWord(String s) {
        Stream<String> textStream = Arrays.stream(s.split("\\s+"));
        System.out.println("В тексте " + textStream.count() + " слов");
    }

    public static void main(String[] args) {
        //Карл у Клары украл кораллы, А Клара у Карла украла кларнет. Королева Клара сильно карала Кавалера Карла за кражу кораллов!

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Введите текст:");
        String text = scanner.next();
        getQuantityWord(text);
        System.out.println("ТОП-10:");
        countWord(text);
    }
}
