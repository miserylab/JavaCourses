package ru.java.courses;

import java.util.*;

public class Lesson10_CollectionsLists {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Сортируем список по возрастанию
     * 4. Преобразуем числа в строки
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {

        List<String> sourseToString = new ArrayList<>(source.size());
        Collections.sort(source);

        for (Integer i : source) {
            if (!sourseToString.contains(i.toString())) {
                sourseToString.add(i.toString());
            }
        }

        return sourseToString;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {

        int startPos = 3;
        int endPos = 7;


        List<Integer> arrayToList = new ArrayList<>(array.length); //список из массива
        List<Integer> threeToSeven = new ArrayList<>(array.length); //список выходных данных
        arrayToList.addAll(Arrays.asList(array));
        Integer temp;
        for (int i = startPos; i < arrayToList.size() && i <= endPos; i++) {
            temp = arrayToList.get(i);
            arrayToList.set(i, temp % 2 == 0 ? ++temp : temp);
            threeToSeven.add(arrayToList.get(i));
        }

        return threeToSeven;

    }
}
