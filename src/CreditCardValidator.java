public class CreditCardValidator {

    public static boolean isValidator(String cardNumber){

        String clear = cardNumber.replaceAll("[^0-9]", "");

        if (clear.length() < 13 || clear.length() > 19){

            return false;

        }

        int sum = 0;
        boolean shouldDouble  = false;

        for (int i = clear.length() - 1; i >= 0; i--){

            int digit = Character.getNumericValue(clear.charAt(i));

            if (shouldDouble) {
                digit *= 2;

                if (digit > 9){
                    digit = digit / 10 + digit % 10;
                }

            }

            sum += digit;
            shouldDouble = !shouldDouble;

        }

        return sum % 10 == 0;

    }
}
