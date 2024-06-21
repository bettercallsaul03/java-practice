//Угнивенко Дмитрий Б763-2
//Вариант A.5. Найти в строке наибольшее число цифр, следующих подряд.

public class Main {
    public static void main(String[] args) {
        String inputString = "abc123def456ghi78222299999999999992222290";
        int longestSequence = findLongNum(inputString);
        System.out.println("Наибольшее число цифр, следующих подряд: " + longestSequence);
    }

    public static int findLongNum(String s) {
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentLength++;

            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 0;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        return maxLength;
    }
}
