package com.tiho.apidemo.apidemopowerledger.service;

import com.tiho.apidemo.apidemopowerledger.model.PowerBar;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PowerBarServiceImpl implements PowerBarService {

    @Autowired
    public SortingService sortingService;

    /**
     * Sort the power bars using the default java sort implementation
     * @param powerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    public List<PowerBar> javaSort(List<PowerBar> powerBars) {
        Collections.sort(powerBars);
        return powerBars;
    }

    /**
     * Sort the power bars using the default java streaming sort implementation
     * @param powerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    public List<PowerBar> streamSort(List<PowerBar> powerBars) {
        return powerBars.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Sort the power bars using the bubble sort implementation
     * @param powerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    public List<PowerBar> bubbleSort(List<PowerBar> powerBars) {
        BubbleSort bubbleSort = new BubbleSort();
        return sortingService.sortWithAlgorithm(powerBars, Comparator.naturalOrder(), bubbleSort);
    }

    /**
     * Sort the power bars using the merge sort implementation
     * @param powerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    public List<PowerBar> mergeSort(List<PowerBar> powerBars) {
        MergeSort mergeSort = new MergeSort();
        return sortingService.sortWithAlgorithm(powerBars, Comparator.naturalOrder(), mergeSort);
    }
}
