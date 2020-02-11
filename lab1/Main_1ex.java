package first_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1ex {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int start = (int) Math.ceil(in.nextDouble());
        int finish = Math.round(in.nextInt());
        int currentNumber, dividers;

        for (currentNumber = start; currentNumber < finish; currentNumber++) {
            dividers = 0;
            for (int i = 1; i <= currentNumber; i++) {
                if (currentNumber % i == 0)
                    dividers++;
            }
            if (dividers <= 2)
                list.add(currentNumber);
        }
        System.out.println(list.toString());
    }
}




