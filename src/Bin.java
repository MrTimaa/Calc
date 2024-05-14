import java.util.Scanner;

public class Bin extends SystemNum {

    private int a;
    private int b;
    private String operator;
    public Bin() {
        a = inputNum();
        operator = inputOper();
        b = inputNum();
        calculationValues();
    }
    public int inputNum() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        while (true) {
            String input = scanner.nextLine();

            if (input.matches("[0-1]+")) { // Проверка, что введены только цифры
                try {
                    number = Integer.parseInt(input, 2);
                    break;
                }
                catch (Exception e) {
                    System.out.println("Слишком большое число, введите заново");
                }
            } else {
                System.out.println("Неверный ввод. Вводите только цифры.");
            }
        }
        return number;
    }
    @Override
    public void calculationValues() {
        long result = 0;

        if (operator.equals("/") && b == 0) {
            setResult("Деление на ноль невозможно");
            return;
        }

        switch (operator) {
            case "+":
                result = (long)a + (long)b;
                break;
            case "-":
                result = (long)a - (long)b;
                break;
            case "/":
                result = (long)a / (long)b;
                break;
            case "*":
                result = (long)a * (long)b;
                break;
            default:
                break;
        }
        setResult(Long.toBinaryString(result));
    }
}
