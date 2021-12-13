import java.util.Scanner;
public class P159_Random_game {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int correctNum = (int) (Math.random() * 99 + 1); //1-99의 정수 랜덤값
            int firstNum = 1;
            int lastNum = 99;
            int selectNum;
            int i;
            System.out.println(correctNum);
            System.out.println("수가 결정됐습니다. 맞추어 보세요");
            for (i = 1; ; i++) {
                System.out.println(firstNum + "-" + lastNum);
                System.out.print(i + ">>");
                selectNum = scanner.nextInt();
                if (selectNum < correctNum) {
                    System.out.println("더 높게");
                    firstNum = selectNum;
                    continue;
                } else if (selectNum > correctNum) {
                    System.out.println("더 낮게");
                    lastNum = selectNum;
                    continue;
                } else
                    break;
            }
            System.out.print("맞췄습니다.\n다시하시겠습니까?(y/n)");
            String again = scanner.next();
            if (again.equals("y"))
                continue;
            else if (again.equals("n"))
                break;
        }
    }
}