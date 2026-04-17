package part1.part1_3;

public class ObjectDescriber {

    public static String describe(Object obj) {
        // TODO: используйте switch с pattern matching (Java 17+ preview).
        // Подсказка 1: обработайте null отдельным case.
        // Подсказка 2: для Integer укажите "положительное" или "не положительное" .
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return switch (obj) {
            case null -> "null значение";
            case Integer i when i > 0 -> "Целое положительное число: " + i;
            case Integer i -> "Целое не положительное число: " + i;
            case String s when s.isEmpty() -> "Пустая строка";
            case String s -> "Непустая строка: \"" + s + "\"";
            case Double d -> "Дробное число: " + d;
            case int[] arr -> "Массив целых чисел длины " + arr.length;
            case Boolean b when b -> "Логическое значение: true";
            default -> "Другой объект типа: " + obj.getClass().getSimpleName();
        };
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static void main(String[] args) {
        Object[] samples = {null, 42, -5, "", "Привет", 3.14, new int[]{1, 2, 3}, true};
        for (Object sample : samples) {
            System.out.println(describe(sample));
        }
        // Проверь себя: пустая строка и непустая строка должны различаться.
        // Типичные ошибки: забывают обработать default.
    }
}