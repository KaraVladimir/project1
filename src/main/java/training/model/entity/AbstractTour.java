package training.model.entity;

import java.math.BigDecimal;

/**
 * This class implements common functionality of all tours
 * @author kara.vladimir2@gmail.com.
 */
public abstract class AbstractTour implements Tour {
    private String name;
    private BigDecimal price;
    private int duration;
    private TypeOfTransfer transfer;
    private TypeOfCatering catering;


    public AbstractTour(String name, BigDecimal price, int duration,
                        TypeOfTransfer transfer, TypeOfCatering catering) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.transfer = transfer;
        this.catering = catering;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public TypeOfCatering getCatering() {
        return catering;
    }

    public TypeOfTransfer getTransfer() {
        return transfer;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTour that = (AbstractTour) o;

        if (duration != that.duration) return false;
        if (!name.equals(that.name)) return false;
        return price != null ? price.equals(that.price) : that.price == null && transfer == that.transfer && catering == that.catering;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (transfer != null ? transfer.hashCode() : 0);
        result = 31 * result + (catering != null ? catering.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", transfer=" + transfer +
                ", catering=" + catering;
    }


    /**
     * Available catering's type
     * @author kara.vladimir2@gmail.com.
     */
    public enum TypeOfCatering {
        RO, BB, FB, HB, AI
    }

    /**
     * @author kara.vladimir2@gmail.com.
     */
    public enum TypeOfTransfer {
        BUS,TRAIN,PLANE
    }
}


