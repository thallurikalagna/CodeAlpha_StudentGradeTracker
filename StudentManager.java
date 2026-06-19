import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public Student searchStudent(String rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }

        return null;
    }
    public void viewAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n================================================================================");
        System.out.printf("%-15s %-20s %-10s %-10s %-10s%n",
            "ROLL NO", "NAME", "AVERAGE", "GRADE", "STATUS");
        System.out.println("================================================================================");

        for (Student student : students) {

            String status =
                student.isPass() ? "PASS" : "FAIL";

            System.out.printf(
                "%-15s %-20s %-10.2f %-10s %-10s%n",
                student.getRollNumber(),
                student.getName(),
                student.calculateAverage(),
                student.calculateGrade(),
                status
            );
        }

        System.out.println("================================================================================");
    }
    public boolean updateStudentMarks(String rollNumber,
                                  int javaMarks,
                                  int dsMarks,
                                  int osMarks,
                                  int dbmsMarks,
                                  int seMarks) {

        Student student = searchStudent(rollNumber);

        if (student != null) {

            student.setJavaMarks(javaMarks);
            student.setDsMarks(dsMarks);
            student.setOsMarks(osMarks);
            student.setDbmsMarks(dbmsMarks);
            student.setSeMarks(seMarks);

            return true;
        }

        return false;
    }
    public boolean deleteStudent(String rollNumber) {

        Student student = searchStudent(rollNumber);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
    public Student getTopper() {

        if (students.isEmpty()) {
            return null;
        }

        Student topper = students.get(0);

        for (Student student : students) {

            if (student.calculateAverage() >
                topper.calculateAverage()) {

                topper = student;
            }
        }

        return topper;
    }
    public double getClassAverage() {

        if (students.isEmpty()) {
            return 0;
        }

        double totalAverage = 0;

        for (Student student : students) {
            totalAverage += student.calculateAverage();
        }

        return totalAverage / students.size();
    }
    public int getPassStudentCount() {

        int count = 0;

        for (Student student : students) {

            if (student.isPass()) {
                count++;
            }
        }

        return count;
    }
    public int getFailStudentCount() {

        int count = 0;

        for (Student student : students) {

            if (!student.isPass()) {
                count++;
            }
        }

        return count;
    }
    public int getTotalStudents() {
        return students.size();
    }
    public void displayPassStudents() {

        for (Student student : students) {

            if (student.isPass()) {

                System.out.println(
                    student.getRollNumber()
                    + " - "
                    + student.getName()
                );
            }
        }
    }
    public void displayFailStudents() {

        for (Student student : students) {

            if (!student.isPass()) {

                System.out.println(
                    student.getRollNumber()
                    + " - "
                    + student.getName()
                );
            }
        }
    }
    public ArrayList<Student> getAllStudents() {
        return students;
    }
    
}
