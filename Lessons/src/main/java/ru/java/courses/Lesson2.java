package ru.java.courses;

class Lesson2 {

    /**
     * Нужно реализовать формулу y = √(13x + 13/x)
     * Подсказка: квадратный корень вычисляется функцией Math.sqrt()
     *
     * @param x на текущем этапе входное значение будет больше нуля
     *
     * @return возвращаем только целую часть от полученного результата,
     * хвост отбрасываем без округления
     */
    static int formula(int x) {

        return (int) Math.sqrt(13 * x + 13 / x);
    }

    /**
     * Нужно привести строку с полным именем к инициалам.
     * Например, "Иванов Петр Александрович" → "И.П.А."
     * Подсказка:
     * разделение строки на части: .split(" ");
     * получение символа на определенной позиции: .charAt();
     * приведение к верхнему регистру: .toUpperCase();
     *
     * @param fullName на текущем этапе имена будут состоять из имени, фамили и отчества, разделяться пробелами.
     *                 Регистр букв во входном параметре может быть любым.
     *
     * @return возвращаем инициалы в верхнем регистре разделенные точкой, как в примере выше
     */
    static String initials(String fullName) {
        String[] splittedName = fullName.split(" ");
        String initials = "";

        initials += splittedName[0].charAt(0) + ".";
        initials += splittedName[1].charAt(0) + ".";
        initials += splittedName[2].charAt(0) + ".";

        return initials.toUpperCase();
    }

}