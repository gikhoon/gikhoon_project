package UI;

import java.util.*;
class Instruction{
    private final String operator;
    private final String [] oper = new String[2];
    Instruction(String line){
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
    public String toString(){
        return "["+operator+" "+oper[0]+" "+oper[1]+"]";
    }


}
public class P441_13 {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> variable = new HashMap<>();
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
                    add(program.get(i));
                    break;
                case "sub":
                    sub(program.get(i));
                    break;
                case "jn0":
                    if(jn0(program.get(i))) break;
                    else{
                        int num = goTo(program.get(i));
                        i=num-1;
                        break;
                    }
                case "prt":
                    prt(program.get(i));
                    return;
                default:
                    error(program.get(i));
            }
        }
    }
    void makeProgram(){
        while(true){
            System.out.print(">> ");
            String line = scanner.nextLine();
            try {
                if (line.equals("exit")) {
                    moveAgain = false;
                    return;
                } else if (line.equalsIgnoreCase("GO")) break;
                else program.add(new Instruction(line));
            }
            catch(NoSuchElementException e){
                System.out.println(line+"은 없는 명령어입니다");
            }
        }
    }
    void mov(Instruction i){
        try{
            int putNum = Integer.parseInt(i.getOper(1));
            variable.put(i.getOper(0),putNum);
        }
        catch (NumberFormatException e){
            error(i);
        }

    }
    void add(Instruction i){
        String addNum = i.getOper(0);
        if(Character.isDigit(addNum.charAt(0)))
            error(i);
        if(variable.containsKey(addNum)){
            if(Character.isDigit(i.getOper(1).charAt(0)))
                variable.put(addNum,variable.get(addNum)+Integer.parseInt(i.getOper(1)));
            else
                variable.put(addNum,variable.get(addNum)+variable.get(i.getOper(1)));
        }
        else{
            System.out.println(i.getOper(0)+"은 없는 명령어입니다. 다음 명령으로 넘어갑니다");
        }
    }
    void sub(Instruction i){
        String subNum = i.getOper(0);
        if(Character.isDigit(subNum.charAt(0)))
            error(i);
        if(variable.containsKey(subNum)){
            if(Character.isDigit(i.getOper(1).charAt(0)))
                variable.put(subNum,variable.get(subNum)-Integer.parseInt(i.getOper(1)));
            else
                variable.put(subNum,variable.get(subNum)-variable.get(i.getOper(1)));
        }
        else{
            System.out.println(i.getOper(0)+"은 없는 명령어입니다. 다음 명령으로 넘어갑니다");
        }
    }
    boolean jn0(Instruction i){
        String zeroVar = i.getOper(0);
        if(variable.containsKey(zeroVar)) {
            return variable.get(zeroVar) == 0;
        }
        System.out.println(zeroVar+"은 존재하지 않습니다. 다음 명령으로 넘어갑니다");
        return true;
    }
    int goTo(Instruction i) {
        return Integer.parseInt(i.getOper(1));
    }
    void prt(Instruction i){
        System.out.println(i.toString());
        String op0 = i.getOper(0);
        Iterator<String> it = variable.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            int value = variable.get(key);
            String s = key.toUpperCase();
            System.out.print(s+":"+value+"  ");
        }
        System.out.println();
        System.out.println("출력할 결과는 "+variable.get(op0)+". 프로그램 실행 끝");
    }
    void error(Instruction i){
        System.out.println(i.getOperator()+" "+i.getOper(0)+" "+i.getOper(1)+"는 없는 명령어입니다. 다음 명령으로 넘어갑니다");
    }
    void clearAll(){
        program.clear();
        variable.clear();
    }
    void run(){
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO(go)를 입력하시면 작동됩니다 exit을 입력하시면 종료됩니다");
        while(true){
            makeProgram(); //프로그램 입력
            if(!moveAgain) return;
            executeProgram(); //프로그램 실행
            clearAll(); //프로그램 실행 후 모든 내용 삭제
        }
    }
    public static void main(String[] args) {
        P441_13 project = new P441_13();
        project.run();
    }
}