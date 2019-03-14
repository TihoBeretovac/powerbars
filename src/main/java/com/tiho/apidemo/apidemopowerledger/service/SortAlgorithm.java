package com.tiho.apidemo.apidemopowerledger.service;

import java.util.Comparator;
import java.util.List;

/**
 * Generic interface for sort algorithms
 */
public interface SortAlgorithm {

    /**
     * Sort the given list using the supplied comparator
     *
     * @param list the list (possibly unordered) to sort
     * @param c the comparator to sort by
     * @param <T> the Comparable items to sort
     * @return the sorted list
     */
    <T extends Comparable<T>> List<T> sort(List<T> list, Comparator c);

}
