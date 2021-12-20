package UI;

import java.util.*;

class Student{
    private String name;
    private String major;
    private int studentNumber;
    private double grade;
    public Student(String name, String major,int studentNumber,double grade){
        this.name = name;
        this.major = major;
        this.studentNumber = studentNumber;
        this.grade = grade;

    }
    void PrintAll(){
        System.out.println("이름:"+name);
        System.out.println("학과:"+major);
        System.out.println("학번:"+studentNumber);
        System.out.println("학점평균:"+grade);
    }
    boolean FindName(String a){
        if(a.equals(name)) {
            System.out.println(name + ", " + major + ", " + studentNumber + ", " + grade);
            return true;
        }
        else
            return false;
    }
}
public class P436_5_1 {
    public static void main(String[] args) {
        Student [] student = new Student[4];
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> board= new ArrayList<>();
        System.out.println("학생이름, 학과,학번,학점평균을 입력하세요");
        for(int i=0;i<4;i++){
            System.out.print(">>");
            String text = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(text, ",");
            String name = st.nextToken().trim();
            String major = st.nextToken().trim();
            int studentNumber = Integer.parseInt(st.nextToken().trim());
            double grade = Double.parseDouble(st.nextToken().trim());
            student[i]=new Student(name,major,studentNumber,grade);
            board.add(student[i]);
        }
        for(int i=0;i<board.size();i++){
            System.out.println("--------------------");
            student[i].PrintAll();
        }
        System.out.println("--------------------");
        while(true){
            System.out.print("학생 이름 >>");
            String findName = scanner.next();
            if(findName.equals("그만"))
                break;
            boolean sameName = false;
            for(int i=0;i< board.size();i++){
                Student s = board.get(i);
                sameName = (sameName||s.FindName(findName));
            }
            if(!sameName)
                System.out.println("그런 이름이 없습니다");

        }
   }
}