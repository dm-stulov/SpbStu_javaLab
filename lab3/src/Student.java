public class Student {
    private final String subject;
    private int labsCount;

    public Student (String subject, int labsCount) {
        this.subject = subject;
        this.labsCount = labsCount;
    }

    public String getSubject() {
        return subject;
    }

    public int getLabsCount() {
        return labsCount;
    }

    public void verifyLabs() {
        labsCount -= 5;
    }
}
