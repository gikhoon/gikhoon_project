package Chapter8;

import java.io.*;
import java.util.Scanner;

public class P486_6 {
    public static void main(String[] args){
        FileReader fs1, fs2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 있을 경우, 파일은 프로젝트 폴더에 있어야 합니다");
        System.out.print("첫번째 파일 이름을 입력하세요>>");
        String s1 = scanner.nextLine();
        System.out.print("두번째 파일 이름을 입력하세요>>");
        String s2 = scanner.nextLine();
        String s1file = "C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1"+"\\"+s1;
        String s2file = "C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1"+"\\"+s2;
        try {
            FileWriter newFile = new FileWriter("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1\\appended.txt");
            fs1 = new FileReader(s1file);
            writeToFile(fs1,newFile);
            fs1.close();
            fs2 = new FileReader(s2file);
            writeToFile(fs2,newFile);
            fs2.close();
            newFile.close();
        } catch (FileNotFoundException e){
            System.out.println("파일을 찾을 수 없습니다");
        } catch (IOException e){
            System.out.println("오류 발생");
        }
    }
    public static void writeToFile(FileReader in, FileWriter out) throws IOException{
        char[] buf = new char[50];
        int c;
        while(true){
            c = in.read(buf,0,buf.length);
            if(c==-1) break;
            out.write(buf,0,c);
        }
    }
}
