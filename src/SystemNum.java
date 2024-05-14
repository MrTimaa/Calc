import java.util.Scanner;

public abstract class SystemNum {
    private String result;

    public String getResult() {
        return result;
    }

    public String inputOper() {
        String operator;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математический оператор: ");
        while (true) {
            operator = scanner.nextLine();
            if (operator.matches("[+\\-*/]")) {
                break;
            } else {
                System.out.println("Неверный ввод. Введите один из следующих операторов: +, -, *, /");
            }
        }
        return operator;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public abstract void calculationValues();
}
