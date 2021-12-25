package Chapter8;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

class PhoneNumber{
    private String name;
    private String phoneNumber;
    PhoneNumber(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber=phoneNumber;
    }
    String printPhone(){
        return name+"\t"+phoneNumber;
    }
}
public class P484_1and2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("전화번호 입력 프로그램입니다");
        Vector<PhoneNumber> people = new Vector<>();
        while(true){
           System.out.print("이름 전화번호 >> ");
           String name = scanner.next();
           if(name.equals("그만")) break;
           String phoneNum = scanner.next();
           PhoneNumber i = new PhoneNumber(name, phoneNum);
           people.add(i);
        }
        try {
            FileWriter fo = new FileWriter("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\8-1 phoneNum.txt",true);
            for (int i = 0; i < people.size(); i++) {
                PhoneNumber p = people.get(i);
                fo.write(p.printPhone());
                fo.write("\r\n");
            }
            fo.close();
        }
        catch (IOException e){
            System.out.println("파일 생성 오류");
        }
        System.out.println("파일 업데이트 완료");
        try {
            FileReader fi = new FileReader("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\8-1 phoneNum.txt");
            int c;
            while((c=fi.read())!=-1){
                System.out.print((char) c);
            }
        }
        catch (IOException e){
            System.out.println("파일 출력 오류");
        }
    }
}