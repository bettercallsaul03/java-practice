//Угнивенко Дмитрий Б763-2
//Вариант A. 27. Преобразовать каждый элемент списка, цену без добавленной стоимости
//в цену с добавленной стоимостью.


import java.util.ArrayList;
import java.util.List;


class Item {
    private String name;
    private double basePrice;
    private double priceWithTax;


    public Item(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.priceWithTax = basePrice;
    }


    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
    
    public void calculatePriceWithTax(double taxRate) {
        this.priceWithTax = basePrice * (1 + taxRate / 100);
    }


    @Override
    public String toString() {
        return "Товар: " + name +
                ". Цена без налога: " + basePrice +
                ", Цена с учетом налога: " + priceWithTax;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Item("Кефир", 100));
        items.add(new Item("Энвелоуп", 200));
        items.add(new Item("Смартфон Vivo", 30000));

        System.out.println("Товары до налога: ");
        for (Item item : items) {
            System.out.println("Товар: " + item.getName() + ". Цена без налога: " + item.getBasePrice());
        }

        double nalog = 20;
        for (Item item : items) {
            item.calculatePriceWithTax(nalog);
        }

        System.out.println("\nТовары с учетом налога: ");
        items.forEach(System.out::println);
    }
}
