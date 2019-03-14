package com.tiho.apidemo.apidemopowerledger.sort;

import java.util.*;

/**
 * The BubbleSort algorithm
 */
public class BubbleSort implements SortAlgorithm {

    /**
     * The Bubble Sort
     *
     * Bubble items from the front of the list further back in the list
     * Each pass secures the position of the largest value in the list
     * Successive passes become smaller by one each time
     *
     * BigO notation: complexity is O(n*n)
     *
     * @param list the list (possibly unordered) to sort
     * @param c the comparator to sort by
     * @param <T>the Comparable items to sort
     * @return the sorted list, or an empty list if supplied list is null or empty
     */
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list, Comparator c) {
        List<T> listCopy = new ArrayList<T>();
        if(list != null) {
            listCopy.addAll(list);

            int len = listCopy.size();
            for(int j = len-1; j > 0; j--) {
                for(int k = 0; k < j; k++) {
                    if(c.compare(listCopy.get(k+1), listCopy.get(k)) < 0) {
                        Collections.swap(listCopy, k, k+1);
                    }
                }
            }
        }
        return listCopy;
    }
}
