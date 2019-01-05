package app;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Fibonacci {


    public List<Long> Fibonacci(int n) {

        List<Long> elementList = new ArrayList<>();

        if (n == 0) {
            elementList.add(0L);
        } else if (n == 1) {
            elementList.add(0L);
            elementList.add(1L);
        } else {
            elementList.add(0L);
            elementList.add(1L);
            for (int i = 2; i <= n; i++) {
                elementList.add((elementList.get(i - 2)) + (elementList.get(i - 1)));
            }
        }

        return elementList;
    }
}
