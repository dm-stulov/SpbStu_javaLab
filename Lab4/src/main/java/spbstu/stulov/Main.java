package spbstu.stulov;

import spbstu.stulov.Interface.ConsoleWorker;
import spbstu.stulov.model.Model;

public class Main {

    public static void main(String[] args) {
        try {
            var consoleWorker = new ConsoleWorker(new Model());
            consoleWorker.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}