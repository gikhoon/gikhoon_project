package Baekjoon;

public class Test {
    public static void main(String[] args) {
        Person i = new Person(1,2);
        Person j = new Person(10,20);
        Person tmp;
        tmp=i;
        i=j;
        j=tmp;
        System.out.println(i.getCost());
    }
}
