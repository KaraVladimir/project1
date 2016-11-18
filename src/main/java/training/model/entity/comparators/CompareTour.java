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
            case NAME:
                return new Comparator<Tour>() {
                    @Override
                    public int compare(Tour o1, Tour o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
            case PRICE_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o2.getPrice().compareTo(o1.getPrice());
                        return retValue(o1, o2, val);
                    }
                };
            case PRICE_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o1.getPrice().compareTo(o2.getPrice());
                        return retValue(o1, o2, val);
                    }
                };
            case DURATION_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val=  o2.getDuration()-o1.getDuration();
                        return retValue(o1, o2, val);
                    }
                };
            case DURATION_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o1.getDuration()-o2.getDuration();
                        return retValue(o1, o2, val);
                    }
                };
            case CATERING_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o2.getCatering().ordinal()-o1.getCatering().ordinal();
                        return retValue(o1, o2, val);
                    }
                };
            case CATERING_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o1.getCatering().ordinal()-o2.getCatering().ordinal();
                        return retValue(o1, o2, val);
                    }
                };
            case TRANSFER_DESC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o2.getTransfer().ordinal()-o1.getTransfer().ordinal();
                        return retValue(o1, o2, val);
                    }
                };
            case TRANSFER_ASC:
                return new Comparator<Tour>() {
                    public int compare(Tour o1, Tour o2) {
                        int val = o1.getTransfer().ordinal()-o2.getTransfer().ordinal();
                        return retValue(o1, o2, val);
                    }
                };
            default:
                throw new IllegalArgumentException();
        }


    }

    private int retValue(Tour o1, Tour o2, int val) {
        if (val != 0) {
            return val;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
