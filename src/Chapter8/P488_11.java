package Chapter8;

import java.io.*;
import java.util.*;

public class P488_11 {
    void findWord(Vector<String> v){
        Scanner scanner = new Scanner(System.in);
        boolean sameYN;
        while(true){
            System.out.print("단어>> ");
            String name = scanner.nextLine();
            if(name.equals("그만")){
                System.out.println("종료합니다...");
                break;
            }
            sameYN = false;
            for(int i=0;i<v.size();i++){
                String word = v.get(i);
                if(word.indexOf(name)==0) {
                    System.out.println(word);
                    sameYN = true;
                }
            }
            if(!sameYN)
                System.out.println("발견할 수 없음");
        }
    }
    void putVector(Vector<String> v){
        try {
            File file = new File("C:\\Users\\ghikh\\IdeaProjects\\gikhoon\\exampleFiles\\exFIle1\\words.txt");
            FileReader wordsFile = new FileReader(file);
            Scanner fileScanner = new Scanner(wordsFile);
            while(fileScanner.hasNext()){
                v.add(fileScanner.next());
            }
            System.out.println(file.getParentFile().getName()+" 폴더 밑의 "+file.getName()+"파일을 읽었습니다");
            fileScanner.close();
        }catch (IOException e){
            System.out.println("파일이 없습니다");
        }
    }
    void run() {
        Vector<String> wordVector = new Vector<>();
        putVector(wordVector);
        findWord(wordVector);
    }
    public static void main(String[] args) {
        P488_11 project = new P488_11();
        project.run();
    }
}
