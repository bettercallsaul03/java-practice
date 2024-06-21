/Угнивенко Дмитрий Б763-2
// Компьютер. Возможности: создать новую модель компьютера; установить
//цену; добавить объем оперативной памяти; изменить разрешение экрана;
//изменить процессор компьютера; добавить новые комплектующие в базовую комплектацию.
// Добавить специализированные методы для Computer,
//SmartPhone, Pad:
class Computer {
    private String model;
    private double price;
    private int ramSizeGB;
    private String screenResolution;
    private String processor;

    public Computer(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addRAM(int sizeGB) {
        this.ramSizeGB += sizeGB;
    }

    public void changeRes(String resolution) {
        this.screenResolution = resolution;
    }

    public void changeProcessor(String processor) {
        this.processor = processor;
    }

    public void addComponent(String component) {
        System.out.println("Добавлено новое комплектующее: " + component);
    }

    public void calc(String message) {
        System.out.println(message);
    }


    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

    public String getRes() {
        return screenResolution;
    }

    public String getProcessor() {
        return processor;
    }
}

class Smartphone extends Computer {
    public Smartphone(String model) {
        super(model);
    }

    public void Call(String phoneNumber) {
        System.out.println("Звонок на номер: " + phoneNumber + " с " + getModel() + "\n");
    }
}

class Pad extends Computer {
    public Pad(String model) {
        super(model);
    }

    public void draw(String drawingTool) {
        System.out.println("Рисование " + drawingTool + " на " + getModel());
    }
}


public class Main {
    public static void main(String[] args) {

        Computer desktop = new Computer("PC");
        desktop.setPrice(80000);
        desktop.addRAM(16);
        desktop.changeRes("1920x1080");
        desktop.changeProcessor("i5 14600k");
        desktop.calc("вычисляю");

        System.out.println("Модель: " + desktop.getModel());
        System.out.println("Цена: " + desktop.getPrice() + " Р");
        System.out.println("Оперативная память: " + desktop.getRamSizeGB() + "gb");
        System.out.println("Разрешение экрана: " + desktop.getRes());
        System.out.println("Процессор: " + desktop.getProcessor());
        desktop.addComponent("Оперативная память");


        Smartphone iphone = new Smartphone("iPhone 15");
        iphone.setPrice(99999.99);
        iphone.addRAM(6);
        iphone.changeRes("2532x1170");
        iphone.changeProcessor("Apple A17 Bionic");


        System.out.println("\nМодель: " + iphone.getModel());
        System.out.println("Цена: " + iphone.getPrice() + " Р");
        System.out.println("Оперативная память: " + iphone.getRamSizeGB() + "gb");
        System.out.println("Разрешение экрана: " + iphone.getRes());
        System.out.println("Процессор: " + iphone.getProcessor());


        iphone.Call("+79838811883");

        Pad ipad = new Pad("iPad Pro");
        ipad.setPrice(89999.99);
        ipad.addRAM(6);
        ipad.changeRes("2732x2048");
        ipad.changeProcessor("Apple M1");
        ipad.addComponent("Карта памяти на 1 Тб");
        iphone.addComponent("Чехол");

        System.out.println("\nМодель: " + ipad.getModel());
        System.out.println("Цена: " + ipad.getPrice() + " Р") ;
        System.out.println("Оперативная память: " + ipad.getRamSizeGB() + "gb");
        System.out.println("Разрешение экрана: " + ipad.getRes());
        System.out.println("Процессор: " + ipad.getProcessor());

        ipad.draw("стилусом");
    }
}
