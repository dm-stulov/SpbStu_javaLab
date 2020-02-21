import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    int begin = Math.round(in.nextInt()) + 1;
    int end = Math.round(in.nextInt());

    int currentNumber;
    int dividers;
    for (currentNumber = begin; currentNumber < end; currentNumber++) {
      dividers = 0;
      for (int i = 1; i <= currentNumber; i++) {
        if (currentNumber % i == 0)
          dividers++;
      }

      if (( dividers <= 2 ) && ( currentNumber > 1 )) {
        list.add(currentNumber);
      }
    }

    System.out.println(list.toString());
  }
}
