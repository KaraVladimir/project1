package training.model.entity;

import java.math.BigDecimal;

/**
 * This interface is a top of hierarchy of tours
 *
 * @author kara.vladimir2@gmail.com.
 */
public interface Tour {
    /**
     * Get tour's name
     * @return name
     */
    String getName();

    /**
     * Get tour's price
     * @return price
     */
    BigDecimal getPrice();

    /**
     * Get duration of tour
     * @return duration
     */
    int getDuration();

    /**
     * Get catering's type of tour.
     * @return catering
     */
    AbstractTour.TypeOfCatering getCatering();

    /**
     * Get transfer's type
     * @return transfer
     */
    AbstractTour.TypeOfTransfer getTransfer();

}
