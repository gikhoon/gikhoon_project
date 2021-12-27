package Chapter8;

import java.io.*;

public class P487_8 {
    public static void main(String[] args){
        File file = new File("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1");
        File [] fileList = file.listFiles();
        int largestFileIndex = 0;
        for(int i=1;i<fileList.length;i++){
            if(fileList[largestFileIndex].length()<=fileList[i].length()) {
                largestFileIndex = i;
            }
        }
        System.out.println("가장 큰 파일은 "+fileList[largestFileIndex].getPath()+" "+fileList[largestFileIndex].length()+"바이트");
    }
}
