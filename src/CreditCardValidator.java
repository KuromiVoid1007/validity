/**
 * Валидатор номеров карт, реализующий алгоритм Луна .
 * <p>
 * Класс предоставляет статический метод для проверки валидности номера кредитной карты.
 * Поддерживает основные платежные системы.
 * </p>
 *
 * <p>Пример использования:
 * <pre>{@code
 * boolean isValid = CreditCardValidator.isValidator("4111 1111 1111 1111");
 * }</pre>
 * </p>
 *
 */
public class CreditCardValidator {

    /**
     * Проверяет валидность номера карты.
     * <p>
     * Выполняет три проверки:
     * <ol>
     *   <li>Очистка номера от нецифровых символов</li>
     *   <li>Проверка длины номера (13-19 цифр)</li>
     *   <li>Валидация через алгоритм Луна</li>
     * </ol>
     * </p>
     *
     * @param cardNumber номер карты (может содержать пробелы)
     * @return {@code true} если номер валиден, {@code false} в противном случае
     * @throws NullPointerException если передан null
     *
     * @example
     * <pre>{@code
     * // Возвращает true для валидного номера
     * isValid = isValidator("4012-8888-8888-1881");
     *
     * // Возвращает false для невалидного номера
     * isValid = isValidator("1234 5678 9012 3456");
     * }</pre>
     */
    public static boolean isValidator(String cardNumber) {

        String clear = sanitizeCardNumber(cardNumber);
        if (!isValidLength(clear)) return false;
        return checkLuhnAlgorithm(clear);

    }

    /**
     * Очищает номер карты от всех нецифровых символов.
     *
     * @param cardNumber исходный номер карты
     * @return строку, содержащую только цифры
     * @throws NullPointerException если передан null
     */
    private static String sanitizeCardNumber(String cardNumber) {

        return cardNumber.replaceAll("\\D", "");

    }

    /**
     * Проверяет соответствие длины номера карты (13-19 цифр).
     *
     * @param cardNumber номер карты
     * @return {@code true} если длина корректна, {@code false} в противном случае
     */
    private static boolean isValidLength(String cardNumber) {

        return cardNumber.length() >= 13 && cardNumber.length() <= 19;

    }

    /**
     * Реализует алгоритм Луна для проверки номера карты.
     *
     * @param cardNumber номер карты (только цифры)
     * @return {@code true} если номер проходит проверку алгоритмом Луна
     *
     */
    private static boolean checkLuhnAlgorithm(String cardNumber) {

        int sum = 0;
        boolean shouldDouble = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = processDigit(cardNumber.charAt(i), shouldDouble);
            sum += digit;
            shouldDouble = !shouldDouble;
        }

        return sum % 10 == 0;
    }

    /**
     * Обрабатывает отдельную цифру номера согласно алгоритму Луна.
     *
     * @param ch цифра в виде символа
     * @param shouldDouble нужно ли удваивать цифру
     * @return обработанное значение цифры
     */
    private static int processDigit(char ch, boolean shouldDouble) {

        int digit = Character.getNumericValue(ch);
        if (!shouldDouble) return digit;
        digit *= 2;
        return digit > 9 ? (digit / 10 + digit % 10) : digit;

    }
}