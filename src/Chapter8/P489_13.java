package Chapter8;

import java.io.File;
import java.util.Scanner;

public class P489_13 {
    void PrintDirectory(File f){
        try {
            File[] subFiles = f.listFiles();
            for (int i = 0; i < subFiles.length; i++) {
                File subF = subFiles[i];
                if (subF.isFile()) System.out.print("file      ");
                else if (subF.isDirectory()) System.out.print("dir       ");
                else System.out.print("null      ");
                System.out.printf("%-15d%s\n", subF.length(), subF.getName());
            }
        }catch (NullPointerException e){
            System.out.println("해당 파일에는 파일이 업습니다");
        }
    }
    void printDirectoryName(File f){
        System.out.println("*****************************************************************************");
        System.out.println("\t["+f.getPath()+"]");
    }
    void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 파일 탐색기입니다 *****");
        File directory= new File("C:\\");
        String goToFile;
        while(true) {
            printDirectoryName(directory);
            PrintDirectory(directory);
            System.out.print(">>");
            goToFile = scanner.nextLine();
            if(goToFile.equals("그만")) break;
            if(goToFile.equals("..")){
                if(directory.getParent()==null)
                    System.out.println("최상위 디렉토리입니다");
                else
                    directory = new File(directory.getParent());
            }
            else {
                if(new File(directory,goToFile).isDirectory())
                    directory = new File(directory,goToFile);
                else
                    System.out.println("그런 디렉토리가 없습니다");
            }
        }
    }
    public static void main(String[] args){
        P489_13 project = new P489_13();
        project.run();
    }
}
