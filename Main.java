public class Main {

    public static void main(String[] args) {

        StudentManager studentManager =
                new StudentManager();

        // Demo Students

        studentManager.addStudent(
                new Student(
                        "24SS1A6601",
                        "123",
                        "Kalagna",
                        92, 88, 90, 95, 89
                )
        );

        studentManager.addStudent(
                new Student(
                        "24SS1A6602",
                        "123",
                        "Ade Vaishnavi",
                        85, 82, 80, 84, 86
                )
        );

        studentManager.addStudent(
                new Student(
                        "24SS1A6603",
                        "123",
                        "Ameker Vaishnavi",
                        97, 95, 98, 96, 99
                )
        );

        studentManager.addStudent(
                new Student(
                        "24SS1A6604",
                        "123",
                        "Shreemukhi",
                        76, 74, 78, 72, 75
                )
        );

        studentManager.addStudent(
                new Student(
                        "24SS1A6605",
                        "123",
                        "Prathiksha",
                        65, 58, 35, 70, 62
                )
        );

        TeacherPortal teacherPortal =
                new TeacherPortal(studentManager);

        StudentPortal studentPortal =
                new StudentPortal(studentManager);

        java.util.Scanner scanner =
                new java.util.Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("         STUDENT GRADE TRACKER SYSTEM");
            System.out.println("=================================================");
            System.out.println("1. Faculty Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.println("=================================================");

            System.out.print("Enter Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    if (teacherPortal.login()) {
                        teacherPortal.showMenu();
                    }

                    break;

                case 2:

                    studentPortal.login();

                    break;

                case 3:

                    System.out.println("\nThank You For Using Student Grade Tracker!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        scanner.close();
    }
}