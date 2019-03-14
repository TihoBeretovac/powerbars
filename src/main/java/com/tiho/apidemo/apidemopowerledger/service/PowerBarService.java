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
     * @return the sorted PowerBars
     */
    List<PowerBar> javaSort();

    /**
     * Sort the power bars using the default java streaming sort implementation
     * @return the sorted PowerBars
     */
    List<PowerBar> streamSort();

    /**
     * Sort the power bars using the bubble sort implementation
     * @return the sorted PowerBars
     */
    List<PowerBar> bubbleSort();

    /**
     * Sort the power bars using the merge sort implementation
     * @return the sorted PowerBars
     */
    List<PowerBar> mergeSort();
}
