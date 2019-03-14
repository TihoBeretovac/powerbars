package com.tiho.apidemo.apidemopowerledger.controller;

import com.tiho.apidemo.apidemopowerledger.dao.PowerBarRepository;
import com.tiho.apidemo.apidemopowerledger.dao.PowerBarSortResponse;
import com.tiho.apidemo.apidemopowerledger.model.PowerBar;
import com.tiho.apidemo.apidemopowerledger.model.SortType;
import com.tiho.apidemo.apidemopowerledger.service.PowerBarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
public class PowerBarController {

    @Autowired
    private PowerBarRepository repository;

    @Autowired
    private PowerBarServiceImpl service;

    /**
     * Sorts PowerBars collection using the sort algorithm requested
     *
     * @param sortType the sort type
     * @return the sorted items and time duration taken to sort in millis
     */
    @GetMapping("/sortedpowerbars/{sortType}")
    PowerBarSortResponse specificSort(@PathVariable SortType sortType) {

        try {
            long startTime = System.currentTimeMillis();

            List<PowerBar> unsortedPowerBars = repository.findAll();
            List<PowerBar> sortedPowerBars;

            switch (sortType) {
                case java:
                    sortedPowerBars = service.javaSort(unsortedPowerBars);
                    break;
                case stream:
                    sortedPowerBars = service.streamSort(unsortedPowerBars);
                    break;
                case bubble:
                    sortedPowerBars = service.bubbleSort(unsortedPowerBars);
                    break;
                case merge:
                    sortedPowerBars = service.mergeSort(unsortedPowerBars);
                    break;
                default:
                    sortedPowerBars = unsortedPowerBars;
                    break;
            }

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            return new PowerBarSortResponse(sortedPowerBars, elapsedTime);
        } catch (MethodArgumentTypeMismatchException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Unrecognized sort type ", ex);
        }
    }

    /**
     * Handles exceptions related to unrecognised enum
     * @param e the exception
     * @return Pretty response for user to indicate their enum input was invalid
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Class<?> type = e.getRequiredType();
        String message;
        if (type.isEnum()) {
            message = "The parameter " + e.getName() + " in unrecognised";
        } else {
            message = "The parameter " + e.getName() + " must be of type " + type.getTypeName();
        }
        return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}