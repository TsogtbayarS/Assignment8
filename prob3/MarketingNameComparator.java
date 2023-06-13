package prob3;

import java.util.Comparator;

public class MarketingNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Marketing m1 = (Marketing) o1;
        Marketing m2 = (Marketing) o2;
        return m1.getEmployeeName().compareTo(m2.getEmployeeName());
    }
}
