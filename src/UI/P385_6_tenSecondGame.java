package UI;
import java.util.Calendar;
import java.util.Scanner;
class StoreCalender{
    String name;
    int startMinute;
    int startSecond;
    int endMinute;
    int endSecond;
    StoreCalender(String name){
        this.name = name;
    }
    void SetStartTime(){
        Calendar calendar = Calendar.getInstance();
        startMinute = calendar.get(Calendar.MINUTE);
        startSecond = calendar.get(Calendar.SECOND);
    }
    void SetEndTime(){
        Calendar calendar = Calendar.getInstance();
        endMinute = calendar.get(Calendar.MINUTE);
        endSecond = calendar.get(Calendar.SECOND);
    }
    void ShowStartTime(){
        System.out.println("\t현재 초 시간 = " + startSecond);
    }
    void ShowEndTime(){
        System.out.println("\t현재 초 시간 = " + endSecond);
    }
    void tenSecondGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(name+" 시작 <Enter>키 >>");
        scanner.nextLine();
        SetStartTime();
        ShowStartTime();
        System.out.print("10초 예상 후 <Enter>키 >>");
        scanner.nextLine();
        SetEndTime();
        ShowEndTime();
    }
    int giveSecond(){
        return ((endMinute-startMinute)*60+endSecond-startSecond);
    }
}
public class P385_6_tenSecondGame {
    void run(){
        Scanner scan = new Scanner(System.in);
        System.out.print("사용자1를 입력해주세요 >>");
        String player1name = scan.nextLine();
        StoreCalender player1 = new StoreCalender(player1name);
        System.out.print("사용자2를 입력해주세요 >>");
        String player2name = scan.nextLine();
        StoreCalender player2 = new StoreCalender(player2name);
        System.out.println("10초에 가까운 사람이 이기는 게임입니다");
        player1.tenSecondGame();
        player2.tenSecondGame();
        int player1Second = player1.giveSecond();
        int player2Second =player2.giveSecond();
        System.out.print(player1name+"의 결과 "+player1Second+", "+player2name+"의 결과 "+player2Second+", ");
        if(Math.abs(player1Second-10)<Math.abs(player2Second-10))
            System.out.println("승자는 "+player1name);
        else if(Math.abs(player1Second-10)>Math.abs(player2Second-10))
            System.out.println("승자는 "+player2name);
        else
            System.out.println("둘이 비겼습니다");

    }
    public static void main(String[] args) {
        P385_6_tenSecondGame Program = new P385_6_tenSecondGame();
        Program.run();
    }
}
