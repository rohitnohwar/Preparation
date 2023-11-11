package rohit.nohwar.lld.behavioralpatterns.strategypattern;

import rohit.nohwar.lld.behavioralpatterns.strategypattern.algorithms.Algorithm;

import java.util.List;

public class IntegerList {
    private List<Integer> list;
    private Algorithm algorithm;
    public IntegerList(List<Integer> list, Algorithm algorithm) {
        this.algorithm = algorithm;
        this.list = list;
    }

    public void filter() {
        list = algorithm.filter(list);
    }

    public List<Integer> getList() {
        return this.list;
    }
}
