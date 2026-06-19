import java.util.Scanner;

public class StudentPortal {

    private StudentManager studentManager;
    private Scanner scanner;

    public StudentPortal(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.scanner = new Scanner(System.in);
    }

    public void login() {

        System.out.println("\n=================================================");
        System.out.println("                STUDENT LOGIN");
        System.out.println("=================================================");

        System.out.print("Roll Number : ");
        String rollNumber = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        Student student =
                studentManager.searchStudent(rollNumber);

        if (student == null) {

            System.out.println("Student Not Found!");
            return;
        }

        if (!student.getPassword().equals(password)) {

            System.out.println("Incorrect Password!");
            return;
        }

        displayResult(student);
    }

    private void displayResult(Student student) {

        System.out.println("\n=================================================");
        System.out.println("                STUDENT RESULT");
        System.out.println("=================================================");

        System.out.println("Name        : " + student.getName());
        System.out.println("Roll Number : " + student.getRollNumber());

        System.out.println("\n-------------------------------------------------");
        System.out.println("Subject\t\t\tMarks\tStatus");
        System.out.println("-------------------------------------------------");

        System.out.println("Java\t\t\t"
                + student.getJavaMarks()
                + "\t"
                + student.getSubjectStatus(student.getJavaMarks()));

        System.out.println("Data Structures\t\t"
                + student.getDsMarks()
                + "\t"
                + student.getSubjectStatus(student.getDsMarks()));

        System.out.println("Operating Systems\t"
                + student.getOsMarks()
                + "\t"
                + student.getSubjectStatus(student.getOsMarks()));

        System.out.println("DBMS\t\t\t"
                + student.getDbmsMarks()
                + "\t"
                + student.getSubjectStatus(student.getDbmsMarks()));

        System.out.println("Software Engineering\t"
                + student.getSeMarks()
                + "\t"
                + student.getSubjectStatus(student.getSeMarks()));

        System.out.println("-------------------------------------------------");

        System.out.println("Total Marks       : "
                + student.calculateTotal()
                + " / 500");

        System.out.println("Average Marks     : "
                + student.calculateAverage());

        System.out.println("Grade             : "
                + student.calculateGrade());

        System.out.println("Highest Subject   : "
                + student.getHighestSubject());

        System.out.println("Lowest Subject    : "
                + student.getLowestSubject());

        System.out.println("Overall Result    : "
                + (student.isPass() ? "PASS" : "FAIL"));
        
        System.out.println("=================================================");
    }
}