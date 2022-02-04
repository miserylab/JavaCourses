package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;

public class Lesson11to12_SetMap {

    public static class User {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {
        Comparator<User> comparator = new Comparator<>() {
            @Override
            public int compare(User o1, User o2) {
                int temp = o1.getName().compareTo(o2.getName());
                return temp != 0 ? temp : Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        TreeSet<User> users = new TreeSet<>(comparator);
        users.addAll(source);

        return users.last();
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {
        Map<String, User> contacts = new HashMap<>();
        for (User user : source) {
            contacts.put(user.getPhone(), user);
        }
        return contacts.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {

        List<String> bookList = new ArrayList<>(source);
        Collections.sort(bookList);

        int shelves = 5; //всего полок
        int shelfSize = bookList.size() / shelves; //средний размер полки
        int maxShelfSize = shelfSize + bookList.size() & shelves; //максимальный размер полки
        int count = 0; //счетчик записей в источнике

        Map<Integer, List<String>> books = new HashMap<>();

        for (int i = 1; i <=shelves; i++) {
            //на последнюю полку может попасть на пару книжек больше
            if (i == shelves) {
                shelfSize = maxShelfSize;
            }

            List<String> shelf = new ArrayList<>(shelfSize);

            for (int j = 0; j < shelfSize; j++) {
                shelf.add(bookList.get(count));
                count++;
            }

            books.put(i, shelf);
        }

        return books;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        Map<String, Integer> books = new HashMap<>();
        for (Entry<Integer, String> entry : source.entrySet()) {
            books.put(entry.getValue(), entry.getKey());
        }
        return books;
    }
}
