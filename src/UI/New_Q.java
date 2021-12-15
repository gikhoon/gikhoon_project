package UI;

import java.util.Scanner;

public class New_Q {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요");
        String string = scanner.nextLine();
        StringBuffer str = new StringBuffer(string);
        while(true){
            System.out.print("명령: ");
            String command = scanner.nextLine();
            if(command.equals("그만")) {
                System.out.println("종료합니다");
                break;
            }
            String [] commandSplit = command.split("!");
            if(commandSplit.length!=2){
                System.out.println("잘못된 명령입니다");
            }
            else {
                int index = str.indexOf(commandSplit[0]);
                if (index == -1) {
                    System.out.println("찾을 수 없습니다");
                    continue;
                }
                str.replace(index,index+commandSplit[0].length(),commandSplit[1]);
                System.out.println(str);
            }
        }
    }
}
