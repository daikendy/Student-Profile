
public class Student {
    private String name;
    private String studentId;
    private int age;
    private String program;

    public Student(String name, int age, String studentId, String program){
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.program = program;
    }

    public void printProfile(){
        System.out.println("Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Student ID: " + studentId + "\n" +
                "Program: " + program + "\n" +
                "----------------------------------------------------");
    }

}


