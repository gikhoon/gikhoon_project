import java.util.Scanner;
interface Stack{
    int length(); // 저장 가능한 갯수
    int capacity(); //저장 인덱스
    String pop(); //스택의 톱(top)에 저장
    boolean push(String val); //저장된 실수 리턴
}
class StringStack implements Stack{
    private int capacityNum; //가능한 갯수
    private int setNum; //저장된 갯수
    private String [] stack ; //저장 단어들
    StringStack(int n){
        capacityNum=n;
        setNum=0;
        stack = new String[n];
    }
    public int length(){
        return setNum;
    }
    public int capacity() {
        return stack.length;
    }
    public String pop(){
        if(setNum-1<0)
            return null;
        setNum--;
        String s=stack[setNum];
        return s;
    }
    public boolean push(String val) {
        if(setNum<capacityNum){
            stack[setNum] = val;
            setNum++;
            return true;
        }
        else
            return false;
    }
}
public class P319_9_Uncomplete {
    void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("총 스택 저장 공간의 크기 입력");
        int capacityNum=scanner.nextInt();
        StringStack stack=new StringStack(capacityNum);
        while(true){
            System.out.print("문자열 입력>>");
            String val = scanner.next();
            if(val.equals("그만"))
                break;
            if(!stack.push(val)){
                System.out.println("스택이 꽉 차서 푸시 불가");
            }
        }
        System.out.print("스택에 저장된 모든 문자열 팜:");
        for (int i=0;i<stack.length();i++) {
            String s = stack.pop();
            System.out.print(s+" ");
        }
    }
    public static void main(String[] args){
        P319_9_Uncomplete stackApp = new P319_9_Uncomplete();
        stackApp.run();
    }
}
