//Угнивенко Дмитрий Б763-2
//Вариант A.
// 3. Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не
//станет ждать больше определенного времени и уедет на другую стоянку.

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Boolean> parkingSpaces;

    public ParkingLot(int numberOfSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 0; i < numberOfSpaces; i++) {
            parkingSpaces.add(false); 
        }
    }

    public synchronized boolean tryPark(long maxWaitTimeMillis) throws InterruptedException {
        long endTime = System.currentTimeMillis() + maxWaitTimeMillis;
        while (!hasFreeSpace()) {
            long waitTime = endTime - System.currentTimeMillis();
            if (waitTime <= 0) {
                return false; 
            }
            wait(waitTime);
        }
        parkCar();
        return true;
    }

    public synchronized void leave(int spaceIndex) {
        parkingSpaces.set(spaceIndex, false);
        notifyAll();
    }

    private boolean hasFreeSpace() {
        for (Boolean occupied : parkingSpaces) {
            if (!occupied) {
                return true;
            }
        }
        return false;
    }

    private void parkCar() {
        for (int i = 0; i < parkingSpaces.size(); i++) {
            if (!parkingSpaces.get(i)) {
                parkingSpaces.set(i, true);
                break;
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);


        Runnable car = () -> {
            try {
                boolean parked = parkingLot.tryPark(1000); 
                if (parked) {
                    System.out.println(Thread.currentThread().getName() + " припаркован.");
                    Thread.sleep(2000);
                    parkingLot.leave(0);
                    System.out.println(Thread.currentThread().getName() + " уехал.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " уехал на другую стоянку.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread car1 = new Thread(car, "Автомобиль 1");
        Thread car2 = new Thread(car, "Автомобиль 2");
        Thread car3 = new Thread(car, "Автомобиль 3");
        Thread car4 = new Thread(car, "Автомобиль 4");

        car1.start();
        car2.start();
        car3.start();
        car4.start();
    }
}
