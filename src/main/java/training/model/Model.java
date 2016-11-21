package training.model;

import training.model.entity.Tour;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import training.model.entity.utils.FilterObj;
import training.model.entity.utils.SortObj;
import training.model.entity.utils.SortObj.*;

/**
 * Represents tour agency
 *
 * @author kara.vladimir2@gmail.com.
 */
public class Model {
    /**
     * List of all tours in agency
     */
    private List<Tour> tours = new ArrayList<>();

    public List<Tour> getTours() {
        return tours;
    }

    public boolean addTour(Tour tour) {
        return tours.add(tour);
    }

    public boolean removeTour(Tour tour) {
        return tours.remove(tour);
    }

    public List<Tour> selectTours(List<FilterObj> orders) {
        return getTours().stream().filter(getEndPredicate(orders)).
                collect(Collectors.toCollection(ArrayList::new));
    }

    private Predicate<Tour> getEndPredicate(List<FilterObj> orders) {
        Predicate<Tour> predicate = null;
        for (FilterObj fltr : orders) {
            if (Objects.isNull(predicate)) {
                predicate = getPredicate(fltr.getFields(),fltr.getExpression(),fltr.getValue());
            } else {
                predicate = predicate.and(getPredicate(fltr.getFields(), fltr.getExpression(), fltr.getValue()));
            }
        }
        return predicate;
    }

    private Predicate<Tour> getPredicate(Fields fields, FilterObj.Expression expression, Object value) {
        switch (fields) {
            case PRICE:
                return tour -> {
                    if (expression == FilterObj.Expression.EQUAL) {
                        return tour.getPrice().equals(value);
                    } else if (expression == FilterObj.Expression.LESS) {
                        return (tour.getPrice().compareTo((BigDecimal) value) < 0);
                    } else {
                        return (tour.getPrice().compareTo((BigDecimal) value) > 0);
                    }
                };
            case DURATION:
                return tour -> {
                    if (expression == FilterObj.Expression.EQUAL) {
                        return Integer.valueOf(tour.getDuration()).equals(value);
                    } else if (expression == FilterObj.Expression.LESS) {
                        return (Integer.valueOf(tour.getDuration()).
                                compareTo((Integer) value) < 0);
                    } else {
                        return (Integer.valueOf(tour.getDuration()).
                                compareTo((Integer) value) > 0);
                    }
                };
            case TRANSFER:
                return tour -> {
                    if (expression == FilterObj.Expression.EQUAL) {
                        return tour.getTransfer()==value;
                    } else  {
                        throw new IllegalArgumentException();
                    }
                };
            case CATERING:
                return tour -> {
                    if (expression == FilterObj.Expression.EQUAL) {
                        return tour.getCatering()==value;
                    } else  {
                        throw new IllegalArgumentException();
                    }
                };
            default:
                return null;
        }
    }

    /**
     * This method return filtered List of tours
     * @param orders
     * @return list
     */
    public List<Tour> filterTours(List<SortObj> orders) {
        List<Tour> newTours = new ArrayList<>(getTours());
        newTours.sort(getComparator(orders));
        return newTours;
    }

    private Comparator<Tour> getComparator(List<SortObj> orders) {
        Comparator<Tour> tourComparator = null;
        for (SortObj order : orders) {
            if (Objects.isNull(tourComparator)) {
                tourComparator = getComparator(order.getField(), order.getOrder());
            } else {
                tourComparator = tourComparator.thenComparing
                        (getComparator(order.getField(), order.getOrder()));
            }
        }
        return tourComparator;
    }

    private Comparator<Tour> getComparator(Fields field, Orders order) {
        Comparator<Tour> tourComparator = null;
        if (field == Fields.PRICE) {
            tourComparator = Comparator.comparing(Tour::getPrice);
        }
        if (field == Fields.DURATION) {
            tourComparator = Comparator.comparing(Tour::getDuration);
        }
        if (field == Fields.CATERING) {
            tourComparator = Comparator.comparing(Tour::getCatering);
        }
        if (field == Fields.TRANSFER) {
            tourComparator = Comparator.comparing(Tour::getTransfer);
        }
        if (order == Orders.DESC) tourComparator = tourComparator.reversed();

        return tourComparator;
    }


    public enum Fields {
        PRICE, DURATION, TRANSFER, CATERING
    }
}
