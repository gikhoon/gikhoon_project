package Chapter8;

import java.io.*;

public class P487_9 {
    public static void main(String[] args){
        File directory = new File("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\8-9");
        File[] subFile = directory.listFiles();
        System.out.println("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\8-9디렉토리의 .txt 파일을 모두 삭제합니다");
        int deletedTxt = 0;
        for (int i = 0; i < subFile.length; i++) {
            File file = subFile[i];
            String n = file.getName();
            if (n.contains(".txt")) {
                System.out.println(file.getPath() + " 삭제");
                deletedTxt++;
                file.delete();
            }
        }
        System.out.printf("총 %d개의 .txt 파일을 삭제하였습니다", deletedTxt);
    }
}
