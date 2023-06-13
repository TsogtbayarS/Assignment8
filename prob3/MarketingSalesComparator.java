package prob3;

import java.util.Comparator;

public class MarketingSalesComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Marketing m1 = (Marketing) o1;
        Marketing m2 = (Marketing) o2;
        if (m1.getSalesAmount() > m2.getSalesAmount()) {
            return 1;
        } else if (m1.getSalesAmount() < m2.getSalesAmount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
