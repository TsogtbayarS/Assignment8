package prob3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Marketing> listMoreThan1000(List<Marketing> list){
        // Implement a body
        ArrayList<Marketing> newList = new ArrayList<>();

        for(Marketing m : list){
            if(m.getSalesAmount() > 1000){
                newList.add(m);
            }
        }
        newList.sort(new MarketingNameComparator());
        return newList;
    }
    public static void main(String[] args) {
        ArrayList<Marketing> list = new ArrayList<>();
        list.add(new Marketing("ZZZZZ", "product1", 50000));
        list.add(new Marketing("AAA", "product2", 8000));
        list.add(new Marketing("CCCC", "product3", 999));
        System.out.println(list);

//        list.remove(2);
        list.sort(new MarketingSalesComparator());
        System.out.println(list);

        System.out.println(listMoreThan1000(list));


    }
}
