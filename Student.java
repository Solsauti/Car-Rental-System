class Student extends Person {
    String studentId;
    String course;

    Student(String name, int yearOfBirth, int currentYear, String studentId, String course) {
        super(name, yearOfBirth, currentYear);
        this.studentId = studentId;
        this.course = course;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Age: " + computeAge());
    }
}
