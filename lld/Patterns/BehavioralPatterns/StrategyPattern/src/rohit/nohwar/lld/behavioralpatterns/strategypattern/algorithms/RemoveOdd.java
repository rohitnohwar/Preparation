package rohit.nohwar.lld.behavioralpatterns.strategypattern.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RemoveOdd implements Algorithm {
    public List<Integer> filter(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i: list) {
            if (i % 2 == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
