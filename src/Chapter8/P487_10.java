package Chapter8;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class P487_10 {
    int setHashmap(HashMap h){
        String name, phoneNum;
        int count=0;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\8-1 phoneNum.txt");
            Scanner fileScanner = new Scanner(fileReader);
            while(fileScanner.hasNext()){
                name = fileScanner.next();
                phoneNum = fileScanner.next();
                h.put(name,phoneNum);
                count++;
            }
            fileReader.close();
            return count;
        }
        catch (IOException e){
            System.out.println("오류");
        }
        return count;
    }
    void findPhoneNum(HashMap h){
        Scanner scanner = new Scanner(System.in);
        String name;
        while(true){
            System.out.print("이름>> ");
            name = scanner.next();
            if(name.equals("그만")) break;
            if(h.containsKey(name)){
                System.out.println(h.get(name));
            }
            else
                System.out.println("찾는 이름이 없습니다");
        }
        scanner.close();
    }
    void run(){
        HashMap<String, String> phoneNum = new HashMap<>();
        int countPhoneNumber = setHashmap(phoneNum);
        System.out.println("총 "+countPhoneNumber+"개의 전화번호를 읽었습니다");
        findPhoneNum(phoneNum);
    }
    public static void main(String[] args){
        P487_10 project = new P487_10();
        project.run();
    }
}
