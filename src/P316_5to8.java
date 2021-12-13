class Point{
    private int x,y;
    public Point(int x,int y){this.x=x; this.y=y;}
    public int getX() {return x;}
    public int getY() {return y;}
    protected void move(int x,int y) {this.x=x; this.y=y;}
    public String toString(){
        return getX()+","+getY();
    }
}
class ColorPoint extends Point{
    private String color;
    ColorPoint(){
        super(0,0);
        color="BLACK";
    }
    ColorPoint(int x,int y){
        super(x,y);
        color="BLACK";
    }
    ColorPoint(int x,int y,String color){
        super(x,y);
        this.color=color;
    }
    void setColor(String color){
        this.color=color;
    }
    void setXY(int x,int y){
        super.move(x,y);
    }
    public String toString(){
        return color+"색의 ("+super.toString()+ ")의 점";
    }
}
class Point3D extends Point{
    private int z;
    Point3D(int x,int y,int z){
        super(x,y);
        this.z=z;
    }
    protected void move(int x,int y,int z){
        super.move(x,y);
        this.z=z;
    }
    public String toString(){
        return "("+super.toString()+","+z+")의 점";
    }
    public void moveUp(){
        z++;
    }
    public void moveDown(){
        z--;
    }
}
class PositivePoint extends Point{
    PositivePoint(){
        super(0,0);
    }
    PositivePoint(int x,int y){
        super(x,y);
        if(x<=0||y<=0)
            super.move(0,0);

    }
    protected void move(int x,int y){
        if(x>0&&y>0)
            super.move(x,y);
    }
    public String toString() {
        return "(" + super.toString() + ")의 점";
    }
}
public class P316_5to8 {
    public static void main(String[] args){
        PositivePoint p = new PositivePoint();
        p.move(10,10);
        System.out.println(p.toString()+"입니다");

        p.move(-5,5);
        System.out.println(p.toString()+"입니다");

        PositivePoint p2 = new PositivePoint(-10,0);
        System.out.println(p2.toString()+"입니다");
    }
}