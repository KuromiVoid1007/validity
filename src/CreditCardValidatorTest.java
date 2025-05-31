import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {
    @Test
    void validCardNumber_shouldReturnTrue() {

        String cardNumber = "4539 1488 0343 6467";
        assertTrue(CreditCardValidator.isValidator(cardNumber));

    }

    @Test
    void invalidCardNumber_shouldReturnFalse() {

        String cardNumber = "1234 5678 9012 3456";
        assertFalse(CreditCardValidator.isValidator(cardNumber));

    }

    @Test
    void emptyCardNumber_shouldReturnFalse() {

        assertFalse(CreditCardValidator.isValidator(""));

    }

    @Test
    void nullCardNumber_shouldThrowException() {

        assertThrows(NullPointerException.class, () -> {

            CreditCardValidator.isValidator(null);

        });

    }

    @ParameterizedTest
    @ValueSource(strings = {

            "1234 5678 9012 3456",
            "1234567890123456",
            "QWER QWER QWER QWER",
            "4539 1488 0343 646"

    })
    void givenVariousInvalidFormats_whenValidate_thenFalse(String cardNumber) {

        boolean isValid = CreditCardValidator.isValidator(cardNumber);

        assertFalse(isValid, "Невалидный формат : " + cardNumber);

    }
}