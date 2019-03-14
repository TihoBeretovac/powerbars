package com.tiho.apidemo.apidemopowerledger;

import com.tiho.apidemo.apidemopowerledger.model.PowerBar;
import com.tiho.apidemo.apidemopowerledger.sort.BubbleSort;
import com.tiho.apidemo.apidemopowerledger.sort.MergeSort;
import com.tiho.apidemo.apidemopowerledger.service.SortingService;
import lombok.Getter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingServiceTest {


    @Getter
    private BubbleSort bubbleSort = new BubbleSort();

    @Getter
    private MergeSort mergeSort = new MergeSort();

    private List<Double> orderedSetOne = new ArrayList(
            Arrays.asList(1.1, 1.2, 2.3));

    private List<Double> unorderedSetOne = new ArrayList(
            Arrays.asList(1.2, 2.3, 1.1));

    //bubble sort
    @Test
    public void bubbleSortNullElementsShouldReturnEmptySet() {
        assert(SortingService.sortWithAlgorithm(null, null, this.bubbleSort).isEmpty());
    }

    @Test
    public void bubbleSortNoElementsShouldReturnEmptySet() {
        List<PowerBar> bars = new ArrayList<PowerBar>();
        assert(SortingService.sortWithAlgorithm(bars, Comparator.naturalOrder(), this.bubbleSort).isEmpty());
    }

    @Test
    public void bubbleSortOrderedSetOneShouldRemainOrdered() {
        List sorted = SortingService.sortWithAlgorithm(orderedSetOne, Comparator.naturalOrder(), this.bubbleSort);
        assert(sorted.equals(orderedSetOne));
    }

    @Test
    public void bubbleSortTestSetOneShouldReturnOrderedSet() {
        List sorted = SortingService.sortWithAlgorithm(unorderedSetOne, Comparator.naturalOrder(), this.bubbleSort);
        assert(sorted).equals(orderedSetOne);
        assert(listIsInAscendingOrder(orderedSetOne));
        assert(!listIsInAscendingOrder(unorderedSetOne));
    }

    //merge sort
    @Test
    public void mergeSortNullElementsShouldReturnEmptySet() {
        assert(SortingService.sortWithAlgorithm(null, null, this.mergeSort).isEmpty());
    }

    @Test
    public void mergeSortNoElementsShouldReturnEmptySet() {
        List<PowerBar> bars = new ArrayList<PowerBar>();
        assert(SortingService.sortWithAlgorithm(bars, Comparator.naturalOrder(), this.mergeSort).isEmpty());
    }

    @Test
    public void mergeSortOrderedSetOneShouldRemainOrdered() {
        List sorted = SortingService.sortWithAlgorithm(orderedSetOne, Comparator.naturalOrder(), this.mergeSort);
        assert(sorted.equals(orderedSetOne));
    }

    @Test
    public void mergeSortTestSetOneShouldReturnOrderedSet() {
        List sorted = SortingService.sortWithAlgorithm(unorderedSetOne, Comparator.naturalOrder(), this.mergeSort);
        assert(sorted).equals(orderedSetOne);
        assert(listIsInAscendingOrder(orderedSetOne));
        assert(!listIsInAscendingOrder(unorderedSetOne));
    }

    private boolean listIsInAscendingOrder(List<? extends Comparable> list) {
        for (int i=0; i < list.size()-1; i++) {
            if(list.get(i).compareTo(list.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
