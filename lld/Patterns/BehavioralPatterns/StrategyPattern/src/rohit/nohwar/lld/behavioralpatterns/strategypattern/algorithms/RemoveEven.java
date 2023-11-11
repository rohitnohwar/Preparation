package rohit.nohwar.lld.behavioralpatterns.strategypattern.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RemoveEven implements Algorithm {
    public List<Integer> filter(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i: list) {
            if (i % 2 == 1) {
                res.add(i);
            }
        }

        return res;
    }
}
