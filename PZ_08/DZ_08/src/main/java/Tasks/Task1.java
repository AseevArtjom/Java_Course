package Tasks;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Task1
{
    public static class Car{
        protected String name;
        protected int maxSpeed;

        public Car(String name,int maxSpeed){
            this.name = name;
            this.maxSpeed = maxSpeed;
        }

    }

    public static class RaceCarRunnable extends Car implements Runnable{
        private int passed = 0;
        private final int distance;
        private boolean isFinish = false;
        private long finishTime;
        private CountDownLatch latch;

        public RaceCarRunnable(String name,int maxSpeed,int distance,CountDownLatch latch){
            super(name,maxSpeed);
            this.distance = distance;
            this.latch = latch;
        }

        public long getFinishTime() {
            return finishTime;
        }

        private int getRandomSpeed() {
            return (int) (maxSpeed / 2 + Math.random() * (maxSpeed / 2));
        }

        public void Print(){
            System.out.println(this.name + " => " + getRandomSpeed() + ";" + passed + "/" + distance);
        }

        @Override
        public void run() {
            while (!isFinish) {
                try {
                    Thread.sleep(1000);
                    int speed = getRandomSpeed();
                    passed += speed;
                    System.out.println(name + "=> speed: " + speed + "; progress: " + passed + "/" + distance);
                    if (passed >= distance) {
                        isFinish = true;
                        finishTime = System.currentTimeMillis() - Task1.startRaceTime.get();
                        System.out.println(name + " finished!");
                        latch.countDown();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void startRace(List<Thread> carThreads) {
        new Thread(() -> {
            try {
                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    Thread.sleep(500);
                }
                System.out.println("GO!!!");
                startRaceTime.set(System.currentTimeMillis());
                for (Thread carThread : carThreads) {
                    carThread.start();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static String convertToTime(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
        return formatter.format(time);
    }

    public static final AtomicLong startRaceTime = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        int raceDistance = 1000;
        CountDownLatch latch = new CountDownLatch(3);

        List<RaceCarRunnable> cars = new ArrayList<>();
        cars.add(new RaceCarRunnable("Car1", 200, raceDistance, latch));
        cars.add(new RaceCarRunnable("Car2", 180, raceDistance, latch));
        cars.add(new RaceCarRunnable("Car3", 220, raceDistance, latch));

        List<Thread> carThreads = new ArrayList<>();
        for (RaceCarRunnable car : cars) {
            carThreads.add(new Thread(car));
        }

        startRace(carThreads);

        latch.await();

        RaceCarRunnable winner = cars.get(0);
        for (RaceCarRunnable car : cars) {
            System.out.println(car.name + " finished in " + convertToTime(car.getFinishTime()));
            if (car.getFinishTime() < winner.getFinishTime()) {
                winner = car;
            }
        }
        System.out.println("Winner is "+ winner.name + " with time " + convertToTime(winner.getFinishTime()));
        }
}

