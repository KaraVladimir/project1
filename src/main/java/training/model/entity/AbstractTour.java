package training.model.entity;

import java.math.BigDecimal;

/**
 * @author kara.vladimir2@gmail.com.
 */
public abstract class AbstractTour implements Tour {
    protected String name;
    protected BigDecimal price;
    protected int duration;
    protected TypeOfTransfer transfer;
    protected TypeOfCatering catering;

    protected AbstractTour() {
    }

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
    public int compareTo(Tour o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTour that = (AbstractTour) o;

        if (duration != that.duration) return false;
        if (!name.equals(that.name)) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (transfer != that.transfer) return false;
        return catering == that.catering;

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
}

