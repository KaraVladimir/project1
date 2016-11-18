package training.model;

import training.model.entity.Tour;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Model {
    private Set<Tour> tours = new TreeSet<>();

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public boolean addTour(Tour tour) {
        return tours.add(tour);
    }

    public boolean removeTour(Tour tour) {
        return tours.remove(tour);
    }
}
