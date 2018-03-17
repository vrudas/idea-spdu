package io.testsgh.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class ListSorter {

    public List<Integer> sort(List<Integer> unsortedList) {
//        List<Integer> wrappedCollection = new ArrayList<>(unsortedList);
//        Collections.sort(wrappedCollection);
//        return wrappedCollection;
        return unsortedList.stream().sorted().collect(Collectors.toList());
    }

}
