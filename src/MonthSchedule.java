import java.util.Scanner;

class Day{
    private String work;
    public void set(String work) {this.work=work;}
    public void show(){
        if(work == null) System.out.println("없습니다");
        else System.out.println(work+"입니다");
    }
}
public class MonthSchedule {
    static Scanner scanner = new Scanner(System.in);
    int dayNum;
    Day [] day;
    MonthSchedule(int x){
        this.dayNum=x;
        day= new Day[dayNum];
        for(int i=0;i<day.length;i++){
            day[i]=new Day();
        }
    }
    void run(){
        System.out.println("이번달 스케쥴 관리 프로그램.");
        while(true){
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            int selectNum = scanner.nextInt();
            if(selectNum==3) break;
            else if(selectNum==2){ view();}
            else if(selectNum==1){ input();}
            else{
                System.out.println("잘못 입력했습니다. 다시 입력하세요");
            }
        }
    }
    void view(){
        while(true) {
            System.out.print("날짜(1-"+dayNum+")? >> ");
            int viewDay = scanner.nextInt();
            if ((1 <= viewDay) && (viewDay <= dayNum)) {
                System.out.print(viewDay+"의 할 일은 "); day[viewDay].show();
                break;
            }
            else {
                System.out.println("다시 입력하세요");
            }
        }
    }
    void input(){
        while(true){
            System.out.print("날짜(1-"+dayNum+")? >> ");
            int inputDay = scanner.nextInt();
            if ((1 <= inputDay) && (inputDay <= dayNum)) {
                System.out.print("할일(빈칸없이입력)? >>");
                String todayWork = scanner.next();
                day[inputDay].set(todayWork);
                break;
            }
            else {
                System.out.println("다시 입력하세요");
            }
        }
    }

    public static void main(String[] args){
        System.out.print("이번달의 날짜를 입력해주세요>> ");
        int thisMonthDayNum= scanner.nextInt();
        MonthSchedule month = new MonthSchedule(thisMonthDayNum);
        month.run();
        scanner.close();
    }
}