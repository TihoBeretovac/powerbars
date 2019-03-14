package com.tiho.apidemo.apidemopowerledger.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Represents a purchasable confectionery item with associated energy (calories) information.
 * Taken from: https://www.eatthis.com/best-protein-bars/
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PowerBar implements Comparable<PowerBar> {

    /**
     * unique id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @NotNull
    @Getter @Setter
    private Long id;

    /**
     * the name/description
     */
    @NotNull
    @Getter @Setter
    private String name;

    /**
     * the energy (in calories) attained in consuming the bar
     */
    @NotNull
    @Getter @Setter
    private Float energy;

//    public PowerBar() {
//        super();
//    }
//
//    public PowerBar(Long id, String name, Float energy) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.energy = energy;
//    }

    /**
     * Arbitrary comparison of eah power bar (chosen to be by energy amount)
     * @param x the PowerBar being compared to
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     * @return
     */
    @Override
    public int compareTo(PowerBar x) {
        return energy < x.energy ? -1
                : energy > x.energy ? 1
                : 0;
    }
}
