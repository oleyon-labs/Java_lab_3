package listSpeedTester;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public class ListSpeedTester {


    public ListSpeedTester(int count, Class<? extends List> listToTest){

    }

    public static long testSetSpeed(int count, Class<? extends List> listToTest) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InterruptedException {

        List list = listToTest.getDeclaredConstructor().newInstance();

        Instant start = Instant.now();

        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        Instant finish = Instant.now();


        return Duration.between(start, finish).toNanos();
        //System.out.println("Прошло времени, мс: " + elapsed);




    }

    public long testGetSpeed(int count, Class<? extends List> listToTest){
        return 0;
    }
}
