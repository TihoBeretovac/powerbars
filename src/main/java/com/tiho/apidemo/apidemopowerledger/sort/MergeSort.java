package com.tiho.apidemo.apidemopowerledger.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The Merge Sort algorithm
 */
public class MergeSort implements SortAlgorithm {

    /**
     * The Merge Sort
     *
     * Successively splits list in two until list sizes are 1 or 2
     * Then goes about merging these back together, keeping-order as they
     * are merge back together
     *
     * BigO notation: complexity is O(n*log(n))
     *
     * @param list the list (possibly unordered) to sort
     * @param c the comparator to sort by
     * @param <T>the Comparable items to sort
     * @return the sorted list, or an empty list if supplied list is null or empty
     */
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list, Comparator c) {
        if(list == null || list.isEmpty()) {
            return new ArrayList();
        }

        // If the list has only one element, return the list and terminate. (Base case)
        int listSize = list.size();
        if(listSize == 1)
            return list;

        // Split the list into two halves that are as equal in length as possible. (Divide)
        int mid = listSize / 2;
        List<T> leftList = list.subList(0, mid);
        List<T> rightList = list.subList(mid, listSize);

        // Using recursion, sort both lists using mergesort. (Conquer)
        List<T> sortedLeftList = this.sort(leftList, c);
        List<T> sortedRightList = this.sort(rightList, c);

        // Merge the two sorted lists and return the result. (Combine)
        return this.imperativeMergeTwoArrays(sortedLeftList, sortedRightList, c);
    }

    /**
     * Merges two arrays together, arranging them in order (as per the Comparator provided)
     *
     * @param leftList one array to merge
     * @param rightList a second array to merge
     * @param c the comparator to use when arranging the merged items
     * @param <T> the Comparable items to merge
     * @return the merged and ordered array
     */
    private static final <T extends Comparable<T>> List<T> imperativeMergeTwoArrays(List<T> leftList, List<T> rightList, Comparator c) {
        List<T> newList = new ArrayList<T>();
        // walk through the two lists; extracting the lowest value as you go
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftList.size() || rightIndex < rightList.size()) {
            if (leftIndex >= leftList.size()) {
                newList.add(rightList.get(rightIndex));
                rightIndex++;
                continue;
            }

            if(rightIndex >= rightList.size()) {
                newList.add(leftList.get(leftIndex));
                leftIndex++;
                continue;
            }

            T leftItem = leftIndex < leftList.size() ? leftList.get(leftIndex) : null;
            T rightItem = rightIndex < rightList.size() ? rightList.get(rightIndex) : null;
            if(c.compare(leftItem, rightItem) < 0) {
                newList.add(leftItem);
                leftIndex++;
            } else {
                newList.add(rightItem);
                rightIndex++;
            }
        }

        return newList;
    }
}
