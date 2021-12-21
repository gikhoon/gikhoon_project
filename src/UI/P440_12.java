package UI;

import java.util.*;

public class P440_12 {
    Scanner scanner = new Scanner(System.in);
    HashMap<String,String> hashMap = new HashMap<>();
    void run(){
        System.out.println("*** 영어 단어 테스트 프로그램 \"명품영어\"입니다. ****");
        while(true){
            System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3 >> ");
            int chooseMenu = scanner.nextInt();
            switch (chooseMenu){
                case 1:
                    test();
                    break;
                case 2:
                    addWord();
                    break;
                case 3:
                    System.out.println("\"명품영어\"를 종료합니다");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요");
            }
        }
    }
    void addWord(){
        System.out.println("영어 단어에 그만을 입력하세면 입력을 종료합니다");
        while(true){
            System.out.print("영어 한글 입력 >> ");
            String eng = scanner.next();
            if(eng.equals("그만")) break;
            String kor = scanner.next();
            if(contains(eng)){
                System.out.println(eng+"는 이미 있습니다");
            }
            else{
                hashMap.put(eng,kor);
            }
        }
    }
    void test(){
        System.out.println("현재 "+hashMap.size()+"개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다");
        if(hashMap.size()==0){
            System.out.println("단어가 없습니다 단어를 입력하세요");
            return;
        }
        boolean contains;
        while(true){
            Random r = new Random();
            int [] choiceIndex = new int[4]; //choice[0]은 정답인 보기
            choiceIndex[0]=r.nextInt(hashMap.size());
            for(int i=1;i<4;){
                contains = false;
                int randomNum = r.nextInt(hashMap.size());
                for(int j=0;j<i;j++){
                    if(randomNum==choiceIndex[j]){
                        contains = true;
                    }
                }
                if(contains)
                    continue;
                choiceIndex[i]=randomNum;
                i++;
            } //정답인 단어와 오답인 단어 index 찾기
            String[] array = hashMap.keySet().toArray(new String[hashMap.size()]);
            System.out.println(array[choiceIndex[0]]+"?");
            String [] example = new String[4];
            int correctChoice = r.nextInt(4);
            String answerKor = hashMap.get(array[choiceIndex[0]]);
            example[correctChoice] = answerKor;
            int j=1;
            for(int i=0;i<4;i++) {
                if(example[i] == null){
                    example[i]=array[choiceIndex[j]];
                    j++;
                }
            }
            for(int i=0;i<4;i++){
                System.out.print("("+(i+1)+")"+example[i]+" ");
            }
            try {
                int chooseNum = scanner.nextInt();
                if (chooseNum == -1) break;

                if (chooseNum == correctChoice + 1) System.out.println("Excellent!!");
                else if(chooseNum>=1&&chooseNum<=4) System.out.println("NO!");
                else System.out.println("보기에 없는 숫자입니다");
            }
            catch(InputMismatchException e) {
                scanner.next();
                System.out.println("숫자를 입력하세요");
            }

        }
    }
    boolean contains(String eng){
        Set<String> key = hashMap.keySet();
        Iterator<String> it = key.iterator();
        while(it.hasNext()){
            if(eng.equals(it.next())) return true;
        }
        return false;
    }
    public static void main(String[] args){
        P440_12 project = new P440_12();
        project.run();
    }
}
