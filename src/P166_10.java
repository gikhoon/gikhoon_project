import java.util.Arrays;
import java.util.Random;
public class P166_10 {
    public static void main(String[] args){
        int zero_Num [] = new int[6];
        int zeroPlace [][] = new int [4][4];
        for(int i=0;i<zeroPlace.length;i++) {
            Arrays.fill(zeroPlace[i], 100);
        }
        for (int i=0;i<zero_Num.length;) {
            Random r = new Random();
            zero_Num[i] = r.nextInt(16);
            boolean sameName = false;
            for (int j = 0; j < i; j++) {
                if (zero_Num[i] == zero_Num[j])
                    sameName = true;
            }
            if (sameName != true)
                i++;
        }
        for (int i=0;i<zero_Num.length;i++){
            int row= zero_Num[i]/4; //행
            int column = zero_Num[i]%4; //열
            zeroPlace[row][column]=0;
        }
        for (int i=0;i< zeroPlace.length;i++){
            for(int j=0;j<zeroPlace[i].length;j++){
                if(zeroPlace[i][j]!=0){
                    Random r =new Random();
                    int Num = r.nextInt(10)+1;
                    zeroPlace[i][j]=Num;
                }
            }
        }
        for(int i=0;i< zeroPlace.length;i++) {
            for (int j = 0; j < zeroPlace[i].length; j++) {
                System.out.print(String.format("%-5d",zeroPlace[i][j]));
            }
            System.out.print("\n");
        }
    }
}
