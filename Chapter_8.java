//Угнивенко Дмитрий Б763-2
//Вариант А. 14. В тексте найти и напечатать все слова максимальной и все слова минимальной длины.


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Оставь надежду, всяк сюда входящий";

        String[] words = text.split("[^А-Яа-я]+");

        List<String> maxLenWords = new ArrayList<>();
        List<String> minLenWords = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;

        int minLength = Integer.MAX_VALUE;

        for (String word : words) {
            int length = word.length();

            if (length > maxLength) {
                maxLength = length;
                maxLenWords.clear();
                maxLenWords.add(word);
            } else if (length == maxLength) {
                maxLenWords.add(word);
            }

            if (length < minLength) {
                minLength = length;
                minLenWords.clear();
                minLenWords.add(word);
            } else if (length == minLength) {
                minLenWords.add(word);
            }
        }

        System.out.println("Слова максимальной длины (" + maxLength + "): " + maxLenWords);
        System.out.println("Слова минимальной длины (" + minLength + "): " + minLenWords);
    }
}
