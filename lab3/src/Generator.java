import java.util.concurrent.BlockingDeque;

public class Generator extends Thread {
    public BlockingDeque<Student> students;
    private int iterations;
    public Generator(BlockingDeque<Student> students, int iterations) {
        this.students = students;
        this.iterations = iterations;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < iterations; ++i) {

                //System.out.println("Generator is working");
                generateStudent();
                //currentThread().sleep(1000);
            }
            students.put(new Student("finish", 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private void generateStudent() {
        int labsCount_ = (int) (Math.random() * 3);
        int subject_ = (int) (Math.random() * 3);
        int labsCount;
        String subject;
        switch (labsCount_) {
            case 0:
                labsCount = 10;
                break;
            case 1:
                labsCount = 20;
                break;
            case 2:
                labsCount = 100;
                break;
            default:
                labsCount = 10;
        }

        switch (subject_) {
            case 0:
                subject = "Math";
                break;
            case 1:
                subject = "OOP";
                break;
            case 2:
                subject = "Physics";
                break;
            default:
                subject = "HigherMath";
        }
        try {
            students.put(new Student(subject, labsCount));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
