import java.util.Scanner;

public class TeacherPortal {

    private StudentManager studentManager;
    private Scanner scanner;

    public TeacherPortal(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.scanner = new Scanner(System.in);
    }

    public boolean login() {

        System.out.println("\n=================================================");
        System.out.println("                FACULTY LOGIN");
        System.out.println("=================================================");

        System.out.print("Username : ");
        String username = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        if (username.equals("faculty") &&
            password.equals("faculty@123")) {

            System.out.println("\nLogin Successful!");
            return true;
        }

        System.out.println("\nInvalid Credentials!");
        return false;
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("                FACULTY PORTAL");
            System.out.println("=================================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. View Topper");
            System.out.println("7. View Class Statistics");
            System.out.println("8. View Pass Students");
            System.out.println("9. View Fail Students");
            System.out.println("10. Logout");
            System.out.println("=================================================");

            System.out.print("Enter Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    studentManager.viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudentMarks();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    viewTopper();
                    break;

                case 7:
                    viewStatistics();
                    break;

                case 8:
                    studentManager.displayPassStudents();
                    break;

                case 9:
                    studentManager.displayFailStudents();
                    break;

                case 10:
                    System.out.println("Logged Out Successfully.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 10);
    }

    private void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        System.out.print("Roll Number : ");
        String rollNumber = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        System.out.print("Name : ");
        String name = scanner.nextLine();

        System.out.print("Java Marks : ");
        int javaMarks = scanner.nextInt();

        System.out.print("DS Marks : ");
        int dsMarks = scanner.nextInt();

        System.out.print("OS Marks : ");
        int osMarks = scanner.nextInt();

        System.out.print("DBMS Marks : ");
        int dbmsMarks = scanner.nextInt();

        System.out.print("SE Marks : ");
        int seMarks = scanner.nextInt();

        scanner.nextLine();

        Student student = new Student(
                rollNumber,
                password,
                name,
                javaMarks,
                dsMarks,
                osMarks,
                dbmsMarks,
                seMarks
        );

        studentManager.addStudent(student);

        System.out.println("Student Added Successfully!");
    }

    private void searchStudent() {

        System.out.print("Enter Roll Number : ");
        String rollNumber = scanner.nextLine();

        Student student =
                studentManager.searchStudent(rollNumber);

        if (student == null) {

            System.out.println("Student Not Found!");
            return;
        }

        System.out.println("\n========== STUDENT DETAILS ==========");
        System.out.println("Name : " + student.getName());
        System.out.println("Roll Number : " + student.getRollNumber());

        System.out.println("Java : " + student.getJavaMarks());
        System.out.println("DS : " + student.getDsMarks());
        System.out.println("OS : " + student.getOsMarks());
        System.out.println("DBMS : " + student.getDbmsMarks());
        System.out.println("SE : " + student.getSeMarks());

        System.out.println("Average : " + student.calculateAverage());
        System.out.println("Grade : " + student.calculateGrade());
    }

    private void updateStudentMarks() {

        System.out.print("Enter Roll Number : ");
        String rollNumber = scanner.nextLine();

        System.out.print("New Java Marks : ");
        int javaMarks = scanner.nextInt();

        System.out.print("New DS Marks : ");
        int dsMarks = scanner.nextInt();

        System.out.print("New OS Marks : ");
        int osMarks = scanner.nextInt();

        System.out.print("New DBMS Marks : ");
        int dbmsMarks = scanner.nextInt();

        System.out.print("New SE Marks : ");
        int seMarks = scanner.nextInt();

        scanner.nextLine();

        boolean updated =
                studentManager.updateStudentMarks(
                        rollNumber,
                        javaMarks,
                        dsMarks,
                        osMarks,
                        dbmsMarks,
                        seMarks
                );

        if (updated) {
            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    private void deleteStudent() {

        System.out.print("Enter Roll Number : ");
        String rollNumber = scanner.nextLine();

        boolean deleted =
                studentManager.deleteStudent(rollNumber);

        if (deleted) {
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    private void viewTopper() {

        Student topper = studentManager.getTopper();

        if (topper == null) {

            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n========== TOPPER ==========");
        System.out.println("Name : " + topper.getName());
        System.out.println("Roll Number : " + topper.getRollNumber());
        System.out.println("Average : " + topper.calculateAverage());
        System.out.println("Grade : " + topper.calculateGrade());
    }
    
    private void viewStatistics() {

        int totalStudents =
            studentManager.getTotalStudents();

        int passStudents =
            studentManager.getPassStudentCount();

        int failStudents =
            studentManager.getFailStudentCount();

        double passPercentage = 0;
        double failPercentage = 0;

        if (totalStudents > 0) {

            passPercentage =
                (passStudents * 100.0) / totalStudents;

            failPercentage =
                (failStudents * 100.0) / totalStudents;
        }

        System.out.println("\n=================================================");
        System.out.println("               CLASS STATISTICS");
        System.out.println("=================================================");

        System.out.println("Total Students : "
            + totalStudents);

        System.out.println("Pass Students  : "
            + passStudents);

        System.out.println("Fail Students  : "
            + failStudents);

        System.out.printf("Pass Percentage: %.2f%%\n",
            passPercentage);

        System.out.printf("Fail Percentage: %.2f%%\n",
            failPercentage);

        System.out.printf("Class Average  : %.2f\n",
            studentManager.getClassAverage());

        System.out.println("=================================================");
    }
}