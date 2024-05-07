import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public int selectSystem(String numStr, Map<Integer, String> dict) {
        int num = 2;
        if (dict.containsValue(numStr.toLowerCase()) || dict.containsValue(numStr.toUpperCase())) {
            for (Map.Entry<Integer, String> value : dict.entrySet()) {
                if (numStr.equalsIgnoreCase(value.getValue())) {
                    num = value.getKey();
                }
            }
        }
        else {
            System.out.println("Нет такой системы счисления");
        }
        return num;
    }
    public void printMenu() {
        HashMap<Integer, String> dict = new HashMap<>();
        dict.put(1, "HEX");
        dict.put(2, "DEC");
        dict.put(3, "OCT");
        dict.put(4, "BIN");

        System.out.println("Выберите систему счисления\n" + "1." + dict.get(1) + "\n2." + dict.get(2) + "\n3." + dict.get(3)
                + "\n4." + dict.get(4));
        Scanner scan = new Scanner(System.in);
        int num = 4;
        if (scan.hasNextInt()) {
            num = scan.nextInt();
            if (!dict.containsKey(num)) {
                num = 2;
                System.out.println("Нет такой системы счисления");
            }
        } else if (scan.hasNextLine()) {
            String numStr = scan.nextLine();
            num = selectSystem(numStr, dict);
        }

        System.out.println("Выбрана " + dict.get(num) + " система счисления");

        while (true) {
            String res = "";
            switch (num) {
                case 1:
                    Hex hex = new Hex();
                    res = hex.getResult();
                    break;
                case 2:
                    Dec dec = new Dec();
                    res = dec.getResult();
                    break;
                case 3:
                    Oct oct = new Oct();
                    res = oct.getResult();
                    break;
                case 4:
                    Bin bin = new Bin();
                    res = bin.getResult();
                    break;
                default: break;
            }
            System.out.println(res);
            System.out.println("Продолжить?");
            Scanner s = new Scanner(System.in);
            String key = s.nextLine();
            if (key.equalsIgnoreCase("no")) {
                System.out.println("Завершение работы");
                break;
            }
            if (key.equalsIgnoreCase("back")) {
                printMenu();
                break;
            }
            else {
                System.out.println("Введено неверное значение, выход в меню");
                printMenu();
                break;
            }
        }
    }
}
