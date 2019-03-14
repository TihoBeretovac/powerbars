package com.tiho.apidemo.apidemopowerledger.dao;

import com.tiho.apidemo.apidemopowerledger.model.PowerBar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The HTTP response to a sorted collection of PowerBars
 */
@AllArgsConstructor
public class PowerBarSortResponse {

    /**
     * the sorted list of PowerBars
     */
    @Getter @Setter
    private List<PowerBar> powerBars;

    /**
     * the time taken to perform the sort (in millis)
     */
    @Getter @Setter
    private long timeTaken;

}
