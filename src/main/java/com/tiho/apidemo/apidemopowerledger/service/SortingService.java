package com.tiho.apidemo.apidemopowerledger.service;

import com.tiho.apidemo.apidemopowerledger.sort.SortAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * A generic service for applying Sort actions
 */
@Service
public class SortingService {

    /**
     * Sorts a list of Comparable items using the supplied comparator and algorithm and returns it
     * @param list the List of items to sort
     * @param c the Comparator to use
     * @param algorithm the SortAlgorithm to use
     * @param <T> the Comparable Items involved
     * @return the sorted list of items
     */
    public static final <T extends Comparable<T>> List<T> sortWithAlgorithm(List<T> list, Comparator c, SortAlgorithm algorithm) {
        return algorithm.sort(list, c);
    }

}
