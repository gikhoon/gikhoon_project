public class New_Q {
    public static void main(String[] args){
        String s1 = "abcd";
        String s4 = "abcd";
        char data[]={'a','b','c','d'};
        String s2 = new String(data);
        String s3 = new String("abcd");
        s2 = s2.concat("JAVA");
        System.out.println(s2);
    }
}