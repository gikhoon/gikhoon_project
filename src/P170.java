import java.util.Scanner;
import java.util.Random;
public class P170 {
    public static void main(String[] args){
        String str[] = {"가위", "바위", "보"};
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다");
        while(true){
            String choose;
            String comChoose;
            Scanner scanner = new Scanner(System.in);
            System.out.print("가위 바위 보>>");
            choose = scanner.next();
            if(choose.equals("그만"))
                break;
            else if(!((choose.equals("가위"))||(choose.equals("바위"))||(choose.equals("보")))){
                System.out.println("다시 입력하세요");
                continue;
            }
            else{
                Random r = new Random();
                int k = r.nextInt(3);
                comChoose = str[k];
            }
            if(choose.equals(comChoose))
                System.out.println("사용자 : " + choose + ", 컴퓨터 : "+ comChoose +", 비겼습니다");
            else if(((choose.equals("가위"))&&(comChoose.equals("보")))||((choose.equals("바위"))&&(comChoose.equals("가위")))||((choose.equals("보"))&&(comChoose.equals("바위"))))
                System.out.println("사용자 : " + choose + ", 컴퓨터 : "+ comChoose +", 사용자가 이겼습니다");
            else
                System.out.println("사용자 : " + choose + ", 컴퓨터 : "+ comChoose +", 컴퓨터가 이겼습니다");
        }
        System.out.println("게임을 종료합니다");
    }
}