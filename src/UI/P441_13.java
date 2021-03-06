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
                System.out.println(line+"??? ?????? ??????????????????");
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
            System.out.println(i.getOper(0)+"??? ?????? ??????????????????. ?????? ???????????? ???????????????");
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
            System.out.println(i.getOper(0)+"??? ?????? ??????????????????. ?????? ???????????? ???????????????");
        }
    }
    boolean jn0(Instruction i){
        String zeroVar = i.getOper(0);
        if(variable.containsKey(zeroVar)) {
            return variable.get(zeroVar) == 0;
        }
        System.out.println(zeroVar+"??? ???????????? ????????????. ?????? ???????????? ???????????????");
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
        System.out.println("????????? ????????? "+variable.get(op0)+". ???????????? ?????? ???");
    }
    void error(Instruction i){
        System.out.println(i.getOperator()+" "+i.getOper(0)+" "+i.getOper(1)+"??? ?????? ??????????????????. ?????? ???????????? ???????????????");
    }
    void clearAll(){
        program.clear();
        variable.clear();
    }
    void run(){
        System.out.println("???????????? ???????????????. ??????????????? ??????????????????. GO(go)??? ??????????????? ??????????????? exit??? ??????????????? ???????????????");
        while(true){
            makeProgram(); //???????????? ??????
            if(!moveAgain) return;
            executeProgram(); //???????????? ??????
            clearAll(); //???????????? ?????? ??? ?????? ?????? ??????
        }
    }
    public static void main(String[] args) {
        P441_13 project = new P441_13();
        project.run();
    }
}