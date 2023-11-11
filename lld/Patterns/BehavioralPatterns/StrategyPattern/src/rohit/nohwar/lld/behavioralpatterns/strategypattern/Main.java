package rohit.nohwar.lld.behavioralpatterns.strategypattern;

import rohit.nohwar.lld.behavioralpatterns.strategypattern.algorithms.RemoveEven;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerList(new ArrayList<>(
                Arrays.asList(1, 4, 5, 6, 7 ,8, 7 ,2, 66, 344, 54)),
                new RemoveEven()
        );

        integerList.filter();
    }
}