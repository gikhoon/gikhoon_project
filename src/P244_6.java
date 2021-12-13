import java.util.Scanner;
class Circle1{
    private double x,y;
    private int radius;
    public Circle1(double x,double y,int radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    public void show(){
        System.out.println(String.format("(%.1f,%.1f)%d",x,y,radius));
    }
    public int getR(){
        return radius;
    }
}
public class P244_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Circle1 [] c  = new Circle1[3];
        for(int i=0;i<c.length;i++){
            System.out.print("x,y,radius");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int radius = scanner.nextInt();
            c[i] = new Circle1(x,y,radius);
        }
        int [] tmp = new int[3];
        int j=0;
        for(int i=1;i<c.length;i++){
            if (c[tmp[j]].getR()<c[i].getR()) {
                j = 0;
                tmp[j] = i;
            }
            else if (c[tmp[j]].getR()==c[i].getR()){
                j++;
                tmp[j]=i;
            }
        }
        for(int i=0;i<=j;i++)
        c[tmp[j]].show();
    }
}