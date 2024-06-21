//Угнивенко Дмитрий Б763-2
//Вариант А.12. Создать класс Календарь с внутренним классом,
// с помощью объектов которого можно хранить информацию о выходных и праздничных днях.


class Calendar {

    class Weekend {
        private String date;
        private String holiday;

        public Weekend(String date, String holiday) {
            this.date = date;
            this.holiday = holiday;
        }

        public void show() {
            System.out.println("Выходной день: " + date);
            System.out.println("Праздник: " + holiday + "\n");

        }
    }
}
public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        Calendar.Weekend dayOff1 = calendar.new Weekend("12.06.2024", "День России");
        dayOff1.show();

        Calendar.Weekend dayOff2 = calendar.new Weekend("01.05.2024", "Первое мая");
        dayOff2.show();
    }
}
