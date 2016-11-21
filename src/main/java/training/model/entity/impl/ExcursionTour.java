package training.model.entity.impl;

import training.model.entity.AbstractTour;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * This class represents is a kind of tour - tour with excursions
 * @author kara.vladimir2@gmail.com.
 */
public class ExcursionTour extends AbstractTour{
    private String[] excursions;

    public ExcursionTour(String name, BigDecimal price, int duration,
                         TypeOfTransfer transfer, TypeOfCatering catering, String[] excursions) {
        super(name, price, duration, transfer, catering);
        this.excursions = excursions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExcursionTour that = (ExcursionTour) o;
        return Arrays.equals(excursions, that.excursions);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(excursions);
        return result;
    }

    @Override
    public String toString() {
        return "ExcursionTour{" +super.toString()+
                ", excursions=" + Arrays.toString(excursions) +
                "} ";
    }
}
