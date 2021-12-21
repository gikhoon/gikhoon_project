package UI;

import java.util.*;
class Instruction{
    private String line;
    private String operator;
    private String [] oper = new String[2];
    HashMap<String, Integer> variable = new HashMap<>();
    Instruction(String line){
        this.line = line;
        StringTokenizer st = new StringTokenizer(line," ");
        operator = st.nextToken();
        oper[0] = st.nextToken();
        oper[1] = st.nextToken();
    }
    String getOper(int i){
        return oper[i];
    }
    String getOperator(){
        return operator;
    }


}
public class New_Q {
    Scanner scanner = new Scanner(System.in);
    Vector<Instruction> program = new Vector<>();
    boolean moveAgain = true;

    void executeProgram(){
        for(int i=0;i< program.size();i++){
            String lineOperator = program.get(i).getOperator();
            switch(lineOperator){
                case "mov":
                    mov(program.get(i));
                    break;
                case "add":
                case "sub":
                case "jn0":
                case "prt":
                default:
                    error(program.get(i));
            }
        }
    }
    void makeProgram(){
        while(true){
            System.out.print(">> ");
            String line = scanner.nextLine();
            if(line.equals("exit")) {
                moveAgain = false;
                return;
            }
            if(line.toUpperCase().equals("GO")) break;
            program.add(new Instruction(line));
        }
    }
    void mov(Instruction i){
        try{
            int putNum = Integer.parseInt(i.getOper(1));
            i.variable.put(i.getOper(0),putNum);
        }
        catch (ClassCastException e){
            error(i);
        }

    }
    void add(Instruction i){

    }
    void sub(Instruction i){

    }
    void jn0(Instruction i){

    }
    void prt(Instruction i){

    }
    void error(Instruction i){
        System.out.println(i.getOperator()+i.getOper(0)+i.getOper(1)+"는 없는 명령어입니다. 다음 명령으로 넘어갑니다");
    }
    void run(){
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO(go)를 입력하시면 작동됩니다 exit을 입력하시면 종료됩니다");
        while(true){
            makeProgram(); //프로그램 입력
            if(!moveAgain) return;
            executeProgram(); //프로그램 실행
        }
    }
    public static void main(String[] args) {
        New_Q project = new New_Q();
        project.run();
    }
}
