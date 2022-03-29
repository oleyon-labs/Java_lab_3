import listSpeedTester.ListSpeedTester;


import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        long start1 = System.nanoTime();
// выполнение какой-то логики
        Thread.sleep(1000);
        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени, нс: " + elapsed1);
        long elaspsed=0;


        for (int i = 0; i < 1000; i++) {
            Instant start2 = Instant.now();
            Thread.sleep(1);
            Instant finish2 = Instant.now();

            elaspsed+=Duration.between(start2,finish2).toNanos();
        }
        System.out.println("Прошло времени, нс: " + elaspsed);

        Instant start = Instant.now();
// выполнение какой-то логики
        Thread.sleep(1000);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println("Прошло времени, мс: " + elapsed);

        List<Double> listClass = new ArrayList();
        listClass.add(0, 1.5);
        System.out.println(listClass.get(0));
        listClass.add(1, 1.6);
        System.out.println(listClass.get(0));
        //long l = ListSpeedTester.testGetSpeed(100, listClass.getClass());
        long l = ListSpeedTester.testSetSpeed(100, ArrayList.class);

        System.out.println("Прошло времени, нс: " + l);
    }
}
