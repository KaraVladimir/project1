package training.model.entity.comparators;

import training.model.entity.Tour;

import java.util.Comparator;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class CompareTour {
    private FieldAndOrder order;

    public CompareTour(FieldAndOrder order) {
        this.order = order;
    }

    public Comparator<Tour> getComparator() {
        switch (order) {
            case PRICE_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o2.getPrice().compareTo(o1.getPrice());
                    }
                };
            case PRICE_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                };
            case DURATION_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o2.getDuration()-o1.getDuration();
                    }
                };
            case DURATION_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o1.getDuration()-o2.getDuration();
                    }
                };
            case CATERING_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o2.getCatering().ordinal()-o1.getCatering().ordinal();
                    }
                };
            case CATERING_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o1.getCatering().ordinal()-o2.getCatering().ordinal();
                    }
                };
            case TRANSFER_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o2.getTransfer().ordinal()-o1.getTransfer().ordinal();
                    }
                };
            case TRANSFER_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        return o1.getTransfer().ordinal()-o2.getTransfer().ordinal();
                    }
                };
            default:
                throw new IllegalArgumentException();
        }


    }
}
