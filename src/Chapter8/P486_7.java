package Chapter8;

import java.io.*;


public class P486_7 {
    public static void main(String[] args) {
        BufferedInputStream fi;
        BufferedOutputStream fo;
        File inf = new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
        File outf = new File("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1\\img1.jpg");
        System.out.println("파일을 복사합니다");
        try {
            fi = new BufferedInputStream(new FileInputStream(inf));
            fo = new BufferedOutputStream(new FileOutputStream(outf));
            long tenPercent = inf.length()/10;
            long process = 0;
            byte [] buf = new byte[1024];
            int numRead = 0;
            while(true){
                numRead = fi.read(buf,0,buf.length);
                if(numRead == -1) {
                    if (process >0)
                        System.out.print("*");
                    break;
                }
                fo.write(buf,0,numRead);
                process += numRead;
                if(process>tenPercent){
                    System.out.print("*");
                    process = 0;
                }
            }
            fo.close();
            fi.close();
        }catch (IOException e){
            System.out.println("파일 출력 오류");
        }
    }
}
