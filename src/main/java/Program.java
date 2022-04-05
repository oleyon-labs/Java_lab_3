import listSpeedTester.ListSpeedTester;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Введите количество тестов");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        //тестеры различных списков
        ListSpeedTester[] listSpeedTesters = new ListSpeedTester[2];
        listSpeedTesters[0] = new ListSpeedTester(ArrayList.class);
        listSpeedTesters[1] = new ListSpeedTester(LinkedList.class);

        //названия тестов
        String[] methodNames = new String[]{
                "Добаление в конец",
                "Добаление в середину",
                "Поиск в конце",
                "Поиск в середине",
                "Удаление с конца",
                "Удаление с середины"
        };

        //методы тестирования
        Consumer<List>[] methods = new Consumer[methodNames.length];
        methods[0] = list -> list.add(1);
        methods[1] = list -> list.add(list.size() / 2, 1);
        methods[2] = list -> list.get(list.size() - 1);
        methods[3] = list -> list.get(list.size() / 2);
        methods[4] = list -> list.remove(list.size() - 1);
        methods[5] = list -> list.remove(list.size() / 2);

        //начальные условия для списков
        Consumer<List>[] initialStates = new Consumer[3];
        initialStates[0] = list -> list.clear();
        initialStates[1] = list -> {for(int i=0; i<count;i++) list.add(1);};
        initialStates[2] = list -> {for(int i=0; i<count;i++) list.add(1);};

        //итоговая таблица
        String[][] table = new String[methodNames.length + 1][];
        table[0] = new String[]{
                "Метод",
                "Число тестов",
                "ArrayList,нс",
                "LinkedList,нс"};
        //проводим тесты
        for(int i=0; i<methodNames.length; i++)
        {
            String[] row = new String[4];
            row[0] = methodNames[i];
            row[1]= String.valueOf(count);
            row[2]= String.format("%.2f", listSpeedTesters[0].testSpeed(count, initialStates[i/2], methods[i]));
            row[3]= String.format("%.2f", listSpeedTesters[1].testSpeed(count, initialStates[i/2], methods[i]));
            table[i+1] = row;
        }
        //печатаем таблицу
        for (final Object[] row : table) {
            System.out.format("%30s%15s%15s%15s%n", row);
        }
    }
}
