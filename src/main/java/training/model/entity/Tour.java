package training.model.entity;

import java.math.BigDecimal;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface Tour extends Comparable<Tour>{
    String getName();

    BigDecimal getPrice();

    int getDuration();

    TypeOfCatering getCatering();

    TypeOfTransfer getTransfer();

}
