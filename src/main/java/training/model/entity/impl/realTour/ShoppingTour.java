package training.model.entity.impl.realTour;

import training.model.entity.AbstractTour;
import training.model.entity.TypeOfCatering;
import training.model.entity.TypeOfTransfer;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class ShoppingTour extends AbstractTour {
    private String[] shops;

    public ShoppingTour(String name, BigDecimal price, int duration,
                        TypeOfTransfer transfer, TypeOfCatering catering, String[] shops) {
        super(name, price, duration, transfer, catering);
        this.shops = shops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShoppingTour that = (ShoppingTour) o;
        return Arrays.equals(shops, that.shops);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(shops);
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingTour{" +super.toString()+
                ", shops=" + Arrays.toString(shops) +
                "} ";
    }
}
