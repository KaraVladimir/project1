package training.controller;

import training.InitTour;
import training.model.Model;
import training.model.entity.Tour;
import training.model.entity.TypeOfTransfer;
import training.model.entity.comparators.CompareTour;
import training.model.entity.comparators.FieldAndOrder;
import training.model.entity.impl.fakeTour.FakeTourForSelections;
import training.view.View;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        init();
        view.printTree((TreeSet<Tour>) model.getTours());
        view.printMsg("====================================");
        view.printTree(sortTours(new CompareTour(FieldAndOrder.PRICE_ASC).getComparator(),model.getTours()));
        view.printMsg("====================================");
        FakeTourForSelections.Builder builder = FakeTourForSelections.getBuilder();
        builder.setPrice(BigDecimal.valueOf(500));
        FakeTourForSelections forSelections = builder.build();
        view.printTree(selectTours(forSelections,new CompareTour(FieldAndOrder.PRICE_ASC).getComparator(),
                (SortedSet<Tour>) model.getTours()));
        view.printMsg("====================================");
        builder.setPrice(BigDecimal.valueOf(500));
        builder.setDuration(10);
        FakeTourForSelections forSelections1 = builder.build();
        Set<Comparator<Tour>> comparators = new HashSet<>();
        comparators.add(new CompareTour(FieldAndOrder.PRICE_ASC).getComparator());
        comparators.add(new CompareTour(FieldAndOrder.DURATION_ASC).getComparator());
        view.printTree(selectTours(forSelections1,comparators, (SortedSet<Tour>) model.getTours()));
    }

    public TreeSet<Tour> sortTours(Comparator<Tour> comparator, Collection<Tour> tourCollection) {
        TreeSet<Tour> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(tourCollection);
        return treeSet;
    }

    public TreeSet<Tour> selectTours(Tour tour, Set<Comparator<Tour>> comparatorSet, SortedSet<Tour> tourCollection) {
        for (Comparator<Tour> tourComparator : comparatorSet) {
            tourCollection = selectTours(tour, tourComparator, tourCollection);
        }
        return (TreeSet<Tour>) tourCollection;
    }

    public TreeSet<Tour> selectTours(Tour tour,Comparator<Tour>comparator,SortedSet<Tour> tourCollection) {
        tourCollection.add(tour);
        SortedSet<Tour> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(tourCollection);
        treeSet = treeSet.tailSet(tour);
        treeSet.remove(tour);
        return (TreeSet<Tour>) treeSet;
    }


    private void init() {
        for (InitTour initTour : InitTour.values()) {
            model.addTour(initTour.getTour());
        }
    }

}
