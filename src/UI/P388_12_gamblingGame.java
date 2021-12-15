package UI;
import java.util.Scanner;
class Player{
    private String name;
    Player(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
public class P388_12_gamblingGame {
    void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("겜블링 게임에 참여할 선수 숫자>>");
        int playerCount = scanner.nextInt();
        Player [] gamePlayer = new Player[playerCount];
        for(int i=0;i<playerCount;i++){
            System.out.print((i+1)+"번째 선수 이름>>");
            String name = scanner.next();
            gamePlayer[i] = new Player(name);
        }
        int currentPlayer = 0;
        while(true){
            Scanner scanner1 = new Scanner(System.in);
            if(currentPlayer==playerCount)
                currentPlayer=0;
            System.out.print("["+gamePlayer[currentPlayer].getName()+"]:<Enter>");
            scanner1.nextLine();
            boolean sameYN = RandomGame();
            if(sameYN){
                System.out.println(gamePlayer[currentPlayer].getName()+"님이 이겼습니다");
                scanner1.close();
                break;
            }
            else{
                System.out.println("아쉽군요");
            }
            currentPlayer++;
        }
        scanner.close();
    }
    boolean RandomGame(){
        int [] arr = new int[3];
        System.out.print("\t");
        for(int i=0;i<3;i++){
            arr[i]=(int)(Math.random()*3+1);
            System.out.print(arr[i]+"   ");
        }
        return arr[0] == arr[1] && arr[1] == arr[2];
    }
    public static void main(String[] args) {
        P388_12_gamblingGame game = new P388_12_gamblingGame();
        game.run();
    }
}
