package com.tiho.apidemo.apidemopowerledger.service;

import com.tiho.apidemo.apidemopowerledger.model.PowerBar;

import java.util.List;

/**
 * The PowerBar service
 * Defines general operations to be performed on PowerBars
 */
public interface PowerBarService {

    /**
     * Sort the power bars using the default java sort implementation
     * @param unsortedPowerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    List<PowerBar> javaSort(List<PowerBar> unsortedPowerBars);

    /**
     * Sort the power bars using the default java streaming sort implementation
     * @param unsortedPowerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    List<PowerBar> streamSort(List<PowerBar> unsortedPowerBars);

    /**
     * Sort the power bars using the bubble sort implementation
     * @param unsortedPowerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    List<PowerBar> bubbleSort(List<PowerBar> unsortedPowerBars);

    /**
     * Sort the power bars using the merge sort implementation
     * @param unsortedPowerBars the PowerBars to sort
     * @return the sorted PowerBars
     */
    List<PowerBar> mergeSort(List<PowerBar> unsortedPowerBars);
}
