package ru.java.courses;

public class Lesson5_Strings {

    /**
     * Дан массив строк, необходимо удалить из него все дубли,
     * оставшиеся строки объединить в одну в порядке следования в массиве.
     *
     * <p>
     * Подсказка: массив может быть пустой
     *
     * @param strings массив строк
     *
     * @return полученную строку.
     */
    public static String task1(String[] strings) {

        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            if (!sb.toString().contains(s)) {
                sb.append("%/%").append(s);
            }
        }

        return sb.toString().replaceAll("%/%", "");
    }

    /**
     * Дан массив пар названий книг и авторов, необходимо привести каждую пару в строку вида:
     * “Название книги” И.И.Автора
     * <p>
     * Подсказка: Кавычек может не быть, а вместо инициалов полное имя
     *
     * @param pairs массив из пар строк
     *
     * @return  массив из полученных строк отсортированный по названию книг по алфавиту.
     */
    public static String[] task2(String[][] pairs) {

        String[] sortedArr = new String[pairs.length];
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (String[] pair : pairs) {
            //название проверим только на наличие кавычек
            pair[0] = pair[0].replace('\"', '\u0000').trim();
            pair[0] = sb.append("\"").append(pair[0]).append("\"").toString();

            sb.setLength(0);

            //в имени автора убедимся, что заглавные буквы где надо,
            //а также расставим точки и пробелы в нужных количествах
            pair[1] = pair[1].toLowerCase();
            pair[1] = pair[1].replace('.', ' ');

            while (pair[1].contains("  ")) {
                pair[1] = pair[1].replaceAll("  ", " ");
            }

            String[] tempSplit = pair[1].split(" ");
            for (int i = 0; i < tempSplit.length; i++) {
                sb.append(tempSplit[i]);
                sb.setCharAt(0, Character.toUpperCase(tempSplit[i].charAt(0)));
                tempSplit[i] = sb.toString();
                sb.setLength(0);
            }

            sb.setLength(0);
            //собираем всё в единую строку
            pair[1] = sb.append(tempSplit[0].charAt(0)).append(". ").append(tempSplit[1].charAt(0)).append(". ").append(tempSplit[2]).toString();

            sb.setLength(0);
            //собираем целые строки в новый массив
            sortedArr[counter] = sb.append(pair[0]).append(" ").append(pair[1]).toString();

            counter++;
            sb.setLength(0);
        }

        return sortedArr;
    }

    /**
     * Дана строка, необходимо найти два символа и вернуть подстроку между ними.
     * <p>
     * Подсказка: одного или обоих символов может нет быть
     *
     * @param str исходная строка
     * @param symb1 первый символ
     * @param symb2 второй символ
     *
     * @return подстроку между найденными символами
     */
    public static String task3(String str, char symb1, char symb2) {

        //получаем позицию символов
        int symOnePos = str.indexOf(symb1);
        int symTwoPos = str.indexOf(symb2);

        //меняем местами так, чтобы первый всегда был меньше второго
        if (symOnePos > symTwoPos) {
            int tempPos = symOnePos;
            symOnePos = symTwoPos;
            symTwoPos = tempPos;
        }

        //если хоть один символ отсутствует, возвращаем пустую строку,
        //иначе строку с позиции следующей за первой и до той, что перед второй
        return symOnePos < 0 ? "" : str.substring(symOnePos+1, symTwoPos);
    }
}