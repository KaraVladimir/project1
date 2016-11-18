package training.model.entity.impl.realTour;

import training.model.entity.AbstractTour;
import training.model.entity.TypeOfCatering;
import training.model.entity.TypeOfTransfer;

import java.math.BigDecimal;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class BeachTour extends AbstractTour {
    private int hotelsStar;

    public BeachTour(String name, BigDecimal price, int duration,
                     TypeOfTransfer transfer, TypeOfCatering catering, int hotelsStar) {
        super(name, price, duration, transfer, catering);
        this.hotelsStar = hotelsStar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BeachTour beachTour = (BeachTour) o;
        return hotelsStar == beachTour.hotelsStar;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hotelsStar;
        return result;
    }

    @Override
    public String toString() {
        return "BeachTour{" + super.toString()+
                ", hotelsStar=" + hotelsStar +
                "}";
    }
}
