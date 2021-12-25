package Chapter8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P485_4 {
    public static void main(String[] args) {
        try {
            Scanner fscanner = new Scanner(new FileReader("C:\\windows\\system.ini"));
            int lineNum =1;
            while(fscanner.hasNext()){
                System.out.printf("%-4d:",lineNum);
                String line = fscanner.nextLine();
                System.out.println(line);
                lineNum++;
            }
        }
        catch (IOException e){
            System.out.println("잘못 입력");
        }
    }

}