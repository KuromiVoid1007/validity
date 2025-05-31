/**
 * Демонстрационный класс для проверки работы валидатора кредитных карт.
 * <p>
 * Содержит точку входа в программу и демонстрирует базовый пример использования
 * класса {@link CreditCardValidator}.
 * </p>
 *
 * <p>Пример запуска:
 * <pre>{@code
 * public static void main(String[] args) {
 *     String card = "1234 5678 9012 3456";
 *     if (CreditCardValidator.isValidator(card)) {
 *         System.out.println("Карта валидная");
 *     } else {
 *         System.out.println("Карта не валидная");
 *     }
 * }
 * }</pre>
 * </p>
 */
public class Main {

    /**
     * Точка входа в программу.
     * <p>
     * Демонстрирует проверку номера кредитной карты с помощью {@link CreditCardValidator}.
     * Выводит результат проверки в консоль.
     * </p>
     *
     * @param args аргументы командной строки (не используются)
     *
     * @example Пример вывода для валидной карты:
     * <pre>{@code
     * Карта валидная
     * }</pre>
     *
     * @example Пример вывода для невалидной карты:
     * <pre>{@code
     * Карта не валидная
     * }</pre>
     *
     * @see CreditCardValidator
     */
    public static void main(String[] args) {
        String card ="1234 8549 4302 3256";

        if (CreditCardValidator.isValidator(card)){

            System.out.println("Карта валидная");

        } else {

            System.out.println("Карта не валидная");

        }

    }
}