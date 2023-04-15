import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeeHive {
    private static final int NUM_BEES = 6; // количество пчел
    private static final int BATCH_SIZE = 10; // размер порции меда
    private static final int CONSUMPTION_RATE = 2; // скорость потребления меда в порциях в единицу времени
    private static final int MAX_DELAY = 500; // максимальная задержка пчелы в миллисекундах

    public static void main(String[] args) throws InterruptedException {
        List<Bee> bees = new ArrayList<>();
        for (int i = 0; i < NUM_BEES; i++) {
            bees.add(new Bee(i));
        }

        HoneyPot honeyPot = new HoneyPot();
        honeyPot.start();

        while (true) {
            int totalHoney = honeyPot.getTotalHoney();
            System.out.println("Total honey in the pot: " + totalHoney);
            for (Bee bee : bees) {
                bee.setHoneyPot(honeyPot);
                bee.start();
            }

            Thread.sleep(3000); // пчелы добывают мед каждые 2 секунды

            int consumed = CONSUMPTION_RATE * BATCH_SIZE;
            if (totalHoney >= consumed) {
                honeyPot.removeFromPot(consumed);
                System.out.println("Winnie the Pooh consumed " + consumed + " units of honey.");
            } else {
                System.out.println("Winnie the Pooh starved to death!");
                break;
            }
        }

        for (Bee bee : bees) {
            bee.interrupt();
        }
        honeyPot.interrupt();
    }

    static class Bee extends Thread {
        private final int id;
        private HoneyPot honeyPot;

        public Bee(int id) {
            this.id = id;
        }

        public void setHoneyPot(HoneyPot honeyPot) {
            this.honeyPot = honeyPot;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                sleep(random.nextInt(MAX_DELAY)); // имитация задержки в пути
                System.out.println("Bee " + id + " brought " + BATCH_SIZE + " units of honey.");
                honeyPot.addToPot(BATCH_SIZE);
            } catch (InterruptedException e) {
                System.out.println("Bee " + id + " interrupted.");
            }
        }
    }

    static class HoneyPot extends Thread {
        private int totalHoney;

        public int getTotalHoney() {
            return totalHoney;
        }

        public synchronized void addToPot(int honey) throws InterruptedException {
            while (totalHoney + honey > 100) {
                wait(); // ждем, если горшок с медом заполнен
            }
            totalHoney += honey;
            notifyAll(); // будим ожидающих потоков
        }

        public synchronized void removeFromPot(int honey) throws InterruptedException {
            while (totalHoney < honey) {
                wait(); // ждем, если горшок пуст
            }
            totalHoney -= honey;
            notifyAll(); // будим ожидающих потоков
        }

        @Override
        public void run() {
            try {
                while (true) {
                    sleep(1000); // проверяем уровень меда каждую секунду
                }
            } catch (InterruptedException e) {
                System.out.println("HoneyPot interrupted.");
            }
        }
    }
}