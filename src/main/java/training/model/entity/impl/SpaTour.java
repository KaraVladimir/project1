package training.model.entity.impl;

import training.model.entity.AbstractTour;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * This class represents is a kind of tour - spa tour
 * @author kara.vladimir2@gmail.com.
 */
public class SpaTour extends AbstractTour {
    private String[] procedures;

    public SpaTour(String name, BigDecimal price, int duration,
                   TypeOfTransfer transfer, TypeOfCatering catering, String[] procedures) {
        super(name, price, duration, transfer, catering);
        this.procedures = procedures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpaTour spaTour = (SpaTour) o;
        return Arrays.equals(procedures, spaTour.procedures);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(procedures);
        return result;
    }

    @Override
    public String toString() {
        return "SpaTour{" +super.toString()+
                ", procedures=" + Arrays.toString(procedures) +
                "} ";
    }
}
