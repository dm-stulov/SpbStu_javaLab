import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        BlockingDeque<Student> students = new LinkedBlockingDeque(10);
        Generator generator = new Generator(students, 20);
        Robot math = new Robot(students, "Math");
        Robot phys = new Robot(students, "Physics");
        Robot oop = new Robot(students, "OOP");

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(generator);
        service.execute(math);
        service.execute(phys);
        service.execute(oop);

        service.shutdown();
    }
}