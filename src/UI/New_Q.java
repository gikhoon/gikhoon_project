import java.util.StringTokenizer;

public class New_Q {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer("a=3,b=5,c=6", ",=");
        int sum=0;
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            try{
                sum+=Integer.parseInt(next);
                System.out.println(next);
            }catch(NumberFormatException e){
                System.out.println(next);
            }
        }
        System.out.println(sum);
        System.out.println("hello");
    }
}