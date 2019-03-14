package com.tiho.apidemo.apidemopowerledger.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("powerBars")
    private List<PowerBar> powerBars;

    /**
     * the time taken to perform the sort (in millis)
     */
    @Getter @Setter
    @JsonProperty("timeTaken")
    private long timeTaken;

}
