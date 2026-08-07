class Student{
    int roll;
    String name;
    float marks = 50f;

    Student(int r,String n){
        roll = r;
        name = n;
    }
}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(23,"ashish");
        Student s2 = new Student(1,"ayushi");
        System.out.println(s1.roll);
        System.out.println(s1.name);
        System.out.println(s1.marks);
        System.out.println(s2.roll);
        System.out.println(s2.name);
        System.out.println(s2.marks);
    }
}
