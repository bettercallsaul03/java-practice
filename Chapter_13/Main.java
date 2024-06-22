//Угнивенко Дмитрий Б763-2

//Вариант А. 8. Погода. В БД хранится информация о погоде в различных регионах.
//Для погоды необходимо хранить:
//• регион;
//• дату;
//• температуру;
//• осадки.
//Для регионов необходимо хранить:
//• название;
//• площадь;
//• тип жителей.
//Для типов жителей необходимо хранить:
//• название;
//• язык общения.
//• Вывести сведения о погоде в заданном регионе.
//Вывести даты, когда в заданном регионе шел снег и температура была ниже
//заданной отрицательной.
//• Вывести информацию о погоде за прошедшую неделю в регионах, жители
//которых общаются на заданном языке.
//• Вывести среднюю температуру за прошедшую неделю в регионах с площадью больше заданной.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherQueries weatherQueries = new WeatherQueries();

        System.out.println("Добро пожаловать в систему управления погодой!");
        System.out.println("Введите название региона, чтобы получить информацию о погоде:");
        String regionName = scanner.nextLine();

        weatherQueries.printWeatherInfoByRegion(regionName);

        System.out.println("Введите максимальную отрицательную температуру для поиска снега:");
        double maxTemperature = scanner.nextDouble();
        weatherQueries.printSnowDates(regionName, maxTemperature);

        scanner.nextLine();

        System.out.println("Введите язык для поиска информации о погоде за прошедшую неделю:");
        String language = scanner.nextLine();
        weatherQueries.printWeatherInfoByLanguage(language);

        System.out.println("Введите минимальную площадь для поиска средней температуры:");
        double minArea = scanner.nextDouble();
        weatherQueries.printAverageTemperatureByArea(minArea);

        scanner.close();
    }
}
