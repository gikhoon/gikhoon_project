package UI;

import java.util.*;

class Nation{
    private String country;
    private String capital;
    Nation(String country,String capital){
        this.country=country;
        this.capital=capital;
    }
    String getCountry(){
        return country;
    }
    String getCapital(){
        return capital;
    }
}
public class P439_11_1 {
    Scanner scanner = new Scanner(System.in);
    Vector<Nation> vector =new Vector<>();
    void run(){
        System.out.println("*** 수도 맞추기 게임을 시작합니다 ***");
        while(true){
            System.out.print("입력:1, 퀴즈:2, 종료:3>>");
            int chooseNum = scanner.nextInt();
            switch(chooseNum){
                case 1:
                    add();
                    break;
                case 2:
                    quiz();
                    break;
                case 3:
                    System.out.println("게임을 종료합니다");
                    return;
                default:
                    System.out.println("잘못입력하셨습니다");
                    break;
            }
        }
    }
    void add(){
        System.out.println("현재 정보 수는 "+vector.size()+"개입니다");
        while(true){
            System.out.print(vector.size()+1+"번째 나라와 수도 입력>>");
            String country = scanner.next();
            if(country.equals("그만")){
                break;
            }
            String capital = scanner.next();
            if(contains(country)){
                System.out.println(country+"는 이미 있습니다");
                continue;
            }
            Nation nation = new Nation(country,capital);
            vector.add(nation);
        }
    }
    void quiz(){
        System.out.println("퀴즈를 시작합니다");
        while(true){
            Random r = new Random();
            int size =vector.size();
            if(size==0){
                System.out.println("정보가 없습니다");
                return;
            }
            int n = r.nextInt(size);//9개 들어있으면 0-8까지 출력
            System.out.print(vector.get(n).getCountry()+"의 수도는? ");
            String chooseCapital = scanner.next();
            if(chooseCapital.equals("그만")) break;
            if(chooseCapital.equals(vector.get(n).getCapital()))
                System.out.println("정답!!");
            else
                System.out.println("아닙니다!!");
        }
    }
    private boolean contains(String country){
        for(int i=0;i<vector.size();i++){
            if(vector.get(i).getCountry().equals(country))
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        P439_11_1 project = new P439_11_1();
        project.run();
    }
}
