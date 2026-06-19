public class Student {

    private String rollNumber;
    private String password;
    private String name;

    private int javaMarks;
    private int dsMarks;
    private int osMarks;
    private int dbmsMarks;
    private int seMarks;

    public Student(String rollNumber, String password, String name,
                   int javaMarks, int dsMarks, int osMarks,
                   int dbmsMarks, int seMarks) {

        this.rollNumber = rollNumber;
        this.password = password;
        this.name = name;

        this.javaMarks = javaMarks;
        this.dsMarks = dsMarks;
        this.osMarks = osMarks;
        this.dbmsMarks = dbmsMarks;
        this.seMarks = seMarks;
    }
    public int calculateTotal() {
        return javaMarks + dsMarks + osMarks + dbmsMarks + seMarks;
    }
    public double calculateAverage() {
        return calculateTotal() / 5.0;
    }
    
    public String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 42) {
            return "E";
        } else {
            return "F";
        }
    }
    public boolean isPass() {

        return javaMarks >= 42 &&
            dsMarks >= 42 &&
            osMarks >= 42 &&
            dbmsMarks >= 42 &&
            seMarks >= 42;
    }
    public String getHighestSubject() {

        int highest = javaMarks;
        String subject = "Java";

        if (dsMarks > highest) {
            highest = dsMarks;
            subject = "Data Structures";
        }

        if (osMarks > highest) {
            highest = osMarks;
            subject = "Operating Systems";
        }

        if (dbmsMarks > highest) {
            highest = dbmsMarks;
            subject = "DBMS";
        }

        if (seMarks > highest) {
            highest = seMarks;
            subject = "Software Engineering";
        }

        return subject + " (" + highest + ")";
    }
    public String getLowestSubject() {

        int lowest = javaMarks;
        String subject = "Java";

        if (dsMarks < lowest) {
            lowest = dsMarks;
            subject = "Data Structures";
        }

        if (osMarks < lowest) {
            lowest = osMarks;
            subject = "Operating Systems";
        }

        if (dbmsMarks < lowest) {
            lowest = dbmsMarks;
            subject = "DBMS";
        }

        if (seMarks < lowest) {
            lowest = seMarks;
            subject = "Software Engineering";
        }

        return subject + " (" + lowest + ")";
    }
   
    public String getRollNumber() {
        return rollNumber;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public int getJavaMarks() {
        return javaMarks;
    }

    public int getDsMarks() {
        return dsMarks;
    }

    public int getOsMarks() {
        return osMarks;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }

    public int getSeMarks() {
        return seMarks;
    }
    public void setJavaMarks(int javaMarks) {
        this.javaMarks = javaMarks;
    }

    public void setDsMarks(int dsMarks) {
        this.dsMarks = dsMarks;
    }

    public void setOsMarks(int osMarks) {
        this.osMarks = osMarks;
    }

    public void setDbmsMarks(int dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public void setSeMarks(int seMarks) {
        this.seMarks = seMarks;
    }
    public String getSubjectStatus(int marks) {

        if (marks >= 42) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}