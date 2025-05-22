class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }
}

class Classroom {
    private Student[] students;
    private int count;

    public Classroom() {
        students = new Student[10];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < 10) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Maximum Students Reached!");
        }
    }

    public void updateAttendance(int studentId, int days) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(days);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student ID " + studentId + " is not found.");
        }
    }

    public void displayAllStudents() {
        System.out.println("Student ID\tName\t\tDays Attended");
        System.out.println("----------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].getStudentId() + "\t\t" + students[i].getName() + "\t\t" + students[i].getDaysAttended());
        }
    }
}

public class AttendanceSystem {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
      
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));
        
        classroom.updateAttendance(102, 16);
        classroom.updateAttendance(104, 15);
        
        classroom.displayAllStudents();
    }
}