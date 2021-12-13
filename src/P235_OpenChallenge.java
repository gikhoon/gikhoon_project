import java.util.Scanner;
class Player{
    String name;
}
public class P235_OpenChallenge {
    static int countPeople;
    static Player [] gamePlayer;
    static String currentWord = "아버지";

    static Boolean getWordFromUser(){
        Scanner scanner2 = new Scanner(System.in);
        String nextWord = scanner2.next();
        int lastIndex = currentWord.length()-1;
        char lastChar = currentWord.charAt(lastIndex);
        char firstChar = nextWord.charAt(0);
        if(firstChar==lastChar) {
            currentWord=nextWord;
            return true;
        }
        else {
            return false;
        }
    }

    static void run(){
        int currentPerson=0;
        System.out.println("시작하는 단어는 아버지입니다");
        while(true){
            if(currentPerson+1>countPeople)
                currentPerson=0;
            System.out.print(gamePlayer[currentPerson].name+ ">>");
            boolean checkSuccess = getWordFromUser();
            if(checkSuccess==false) {
                System.out.println(gamePlayer[currentPerson].name + "이(가) 졌습니다");
                break;
            }
            currentPerson++;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까?>>");
        countPeople = scanner.nextInt();
        gamePlayer = new Player[countPeople];
        for(int i=0;i<countPeople;i++){
            gamePlayer[i]=new Player();
        }
        for(int i=0;i<countPeople;i++){
            System.out.print("참가자의 이름을 입력하세요>>");
            gamePlayer[i].name =scanner.next();
        }
        P235_OpenChallenge.run();
        scanner.close();
    }
}