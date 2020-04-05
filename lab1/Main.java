import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = inputValue();
        System.out.println(mainAlgoritm(list.get(0), list.get(1)).toString());
    }


    private static List<Integer> inputValue() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        int start = 0, fin = 0;
        do {
            try {
                start = (int) scanner.nextDouble();
                fin = (int) scanner.nextDouble();

                if (start < 0 || fin < 0)
                    throw new IllegalArgumentException("value of 'start' or 'fin' is negative: x=" + start + ", y=" + fin);

                continueLoop = false;

            } catch (InputMismatchException e) {
                System.out.print("Exeption :" + e);
                System.out.println(" only numerical parameters");
                scanner.nextLine();
            }

        } while (continueLoop);

        list.add(start);
        list.add(fin);

        return list;
    }

    private static List<Integer> mainAlgoritm(int begin, int end) {
        List<Integer> listpremiers = new ArrayList<>();
        int currentNum;
        int dividers;

        for (currentNum = begin; currentNum < end; currentNum++) {
            dividers = 0;
            for (int i = 1; i <= currentNum; i++) {
                if (currentNum % i == 0)
                    dividers++;
            }

            if ((dividers <= 2) && (currentNum > 1)) {
                listpremiers.add(currentNum);
            }
        }
        return listpremiers;
    }

}
