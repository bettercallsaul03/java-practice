// Угнивенко Дмитрий Б763-2
/*В символьном файле находится информация об N числах с плавающей запятой
с указанием локали каждого числа отдельно. Прочитать информацию из файла.
Проверить на корректность, то есть являются ли числа числами. Преобразовать
к числовымзначениями вычислить сумму и среднее значениепрочитанных чисел.
Создать собственный класс исключения. Предусмотреть обработку исключений, возникающих при
нехватке памяти, отсутствии самого файла по заданному адресу,
отсутствии или некорректности требуемой записи в файле, недопустимом значении числа
(выходящим за пределы максимально допустимых значений) и т.д
 */

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String filename = "test.txt";
        List<Double> numbers = new ArrayList<>();
        double sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {

                    String[] parts = line.split(" ");
                    if (parts.length != 2) {
                        throw new InvalidNumberException("Некорректный формат записи: " + line);
                    }

                    Locale locale = new Locale(parts[0]);
                    NumberFormat format = NumberFormat.getInstance(locale);
                    Number number = format.parse(parts[1]);
                    double doubleValue = number.doubleValue();

                    if (doubleValue > Double.MAX_VALUE || doubleValue < -Double.MAX_VALUE) {
                        throw new InvalidNumberException("Недопустимое значение числа: " + doubleValue);
                    }

                    numbers.add(doubleValue);
                    sum += doubleValue;

                } catch (ParseException e) {
                    System.err.println("Ошибка парсинга числа: " + line);
                } catch (InvalidNumberException e) {
                    System.err.println(e.getMessage());
                }
            }

            double average = numbers.size() > 0 ? sum / numbers.size() : 0;
            System.out.println("Сумма: " + sum);
            System.out.println("Среднее значение: " + average);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + filename);
        } catch (OutOfMemoryError e) {
            System.err.println("Недостаточно памяти для обработки файла");
        }
    }
}
