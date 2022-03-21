package Baekjoon;

import java.util.*;
class Person{
    private int cost;
    private int deliveryCharge;
    public Person(int a, int b){
        this.cost=a;
        this.deliveryCharge=b;
    }
    public int getCost(){return cost;}
    public int getDeliveryCharge(){return deliveryCharge;}
}
public class Q1487 {
    void changeCost(){}
    void run(){
        Scanner scanner = new Scanner(System.in);
        int peopleNum = scanner.nextInt();
        LinkedList<Person> peopleList = new LinkedList<Person>();
        for(int i=0;i<peopleNum;i++){
            int cost =scanner.nextInt();
            int deliveryCharge=scanner.nextInt();
            peopleList.add(new Person(cost,deliveryCharge));
        }
        for(int i=0;;){
            if(i>=peopleList.size()) break;
            if(peopleList.get(0).getCost()<=peopleList.get(0).getDeliveryCharge()){
                peopleList.remove(i);
                continue;
            }
            i++;
        }
        if(peopleList.size()==0) {
            System.out.println(0);
            return;
        }
        int mostProfit =0;
        int effectiveCost = 0;
        for(int i=0;i<peopleList.size();i++){
            int profit = 0;
            int selectedCost = peopleList.get(i).getCost(); //선택한 Cost
            for (Person person : peopleList) {
                int deliveryCharge = person.getDeliveryCharge();
                if(selectedCost>person.getCost()) continue;
                if (deliveryCharge < selectedCost) {
                    profit += selectedCost - deliveryCharge;
                }
            }
            if(mostProfit < profit){
                mostProfit=profit;
                effectiveCost=selectedCost;
            }
            if(profit == mostProfit) if (effectiveCost > selectedCost) {
                effectiveCost = selectedCost;
            }
        }
        System.out.println(effectiveCost);
    }
    public static void main(String[] args) {
        Q1487 q1487 = new Q1487();
        q1487.run();
    }
}
