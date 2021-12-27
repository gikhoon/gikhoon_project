package Chapter8;

import java.io.*;
import java.util.Scanner;

public class P486_5 {
    static boolean compare(FileInputStream f1,FileInputStream f2) throws IOException{
        byte buf1[] = new byte[1024];
        byte buf2[] = new byte[1024];
        int i1=0,i2;
        while(true){
            i1=f1.read(buf1,0,buf1.length);
            i2=f2.read(buf2,0,buf2.length);

            if(i1!=i2)
                return false;
            if(i1==-1) break;
        }
        return true;
    }
    public static void main(String[] args){
        FileInputStream fs1, fs2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 있을 경우, 파일은 프로젝트 폴더에 있어야 합니다");
        System.out.print("첫번째 파일 이름을 입력하세요>>");
        String s1 = scanner.nextLine();
        System.out.print("두번째 파일 이름을 입력하세요>>");
        String s2 = scanner.nextLine();
        System.out.println(s1+"와 "+s2+"를 비교합니다");
        String s1file = "C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1"+"\\"+s1;
        String s2file = "C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1"+"\\"+s2;
        try{
            fs1 = new FileInputStream(s1file);
            fs2 = new FileInputStream(s2file);
            if(!compare(fs1,fs2)){
                System.out.println("파일이 다릅니다");
            }
            else
                System.out.println("파일이 같습ㄴ다.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
