import java.util.Scanner;
class Seat{
    String line;
    boolean spaceFull;
    private String name;
    void setSpaceEmpty(){
        this.name = "---";
        this.spaceFull = false;
    }
    void setName(String name){
        this.spaceFull = true;
        this.name = name;
    }
    void setCancel(){
        this.spaceFull = false;
        this.name = "---";
    }
    String printName(){
        return this.name;
    }
}
public class BookingSystem {
    static Scanner scanner =new Scanner(System.in);
    static Seat[][] seat = new Seat[3][10];
    BookingSystem(){
        for(int i=0;i<seat.length;i++) {
            for (int j = 0; j < seat[i].length; j++){
                seat[i][j] = new Seat();
                if(i==0) seat[i][j].line="S";
                if(i==1) seat[i][j].line="A";
                if(i==2) seat[i][j].line="B";
                seat[i][j].setSpaceEmpty();
            }
        }
    }
    void Book(){
        System.out.print("좌석 구분 S(1), A(2), B(3)>>");
        int chooseLine = scanner.nextInt();
        Check(chooseLine-1);
        System.out.print("이름>>");
        String bookName = scanner.next();
        System.out.print("번호>>");
        int chooseNum = scanner.nextInt(); //seat[chooseLine][chooseNum]
        if(!seat[chooseLine - 1][chooseNum - 1].spaceFull)
            seat[chooseLine-1][chooseNum-1].setName(bookName);
        else
            System.out.println("이미 등록된 자리입니다");
    }
    void Check(int a){
        System.out.print(seat[a][0].line+">> ");
        for(int j=0;j<seat[a].length;j++){
            System.out.print(seat[a][j].printName()+ " ");
        }
        System.out.println();
    }
    void CheckAll(){
        for(int i=0;i<seat.length;i++)
            Check(i);
    }
    void Cancel(){
        System.out.print("좌석 구분 S(1), A(2), B(3)>>");
        int chooseLine = scanner.nextInt();
        Check(chooseLine-1);
        System.out.print("이름>>");
        String cancelName = scanner.next();
        for(int j=0;j<seat[chooseLine-1].length;j++){
            if(cancelName.equals(seat[chooseLine-1][j].printName())){
                seat[chooseLine-1][j].setCancel();
                break;
            }
        }
    }
    void Run(){
        while(true){
            System.out.print("예약:1, 조회:2, 최소:3, 끝내기:4>>");
            int chooseNumber = scanner.nextInt(); //chooseNumber = 첫 화면에서 고르는 숫자
            if(chooseNumber==4) {break;}
            else if(chooseNumber==3) Cancel();
            else if(chooseNumber==2) {
                CheckAll();
                System.out.println("<<<조회를 완료했습니다>>>");
            }
            else if(chooseNumber==1) Book();
            else
                System.out.println("잘못 입력했습니다");
        }
    }
    public static void main(String[] args){
        System.out.println("명품콘서트홀 예약 시스템입니다");
        BookingSystem concert = new BookingSystem();
        concert.Run();
        scanner.close();
    }
}