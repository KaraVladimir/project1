package training.model.entity.impl.realTour;

import training.model.entity.AbstractTour;
import training.model.entity.Tour;
import training.model.entity.TypeOfCatering;
import training.model.entity.TypeOfTransfer;

import java.math.BigDecimal;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class CruiseTour extends AbstractTour {
    private String ship;

    public CruiseTour(String name, BigDecimal price, int duration,
                      TypeOfTransfer transfer, TypeOfCatering catering, String ship) {
        super(name, price,  duration, transfer, catering);
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CruiseTour that = (CruiseTour) o;

        return ship.equals(that.ship);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ship.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CruiseTour{" +super.toString()+
                ", ship='" + ship + '\'' +
                "} ";
    }
}
