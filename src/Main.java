//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String card ="1234 8549 4302 3256";

        if (CreditCardValidator.isValidator(card)){

            System.out.println("Карта валидная");

        } else {

            System.out.println("Карта не валидная");

        }
    }
}