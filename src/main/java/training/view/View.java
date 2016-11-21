package training.view;

import training.model.entity.Tour;

import java.util.List;
import java.util.TreeSet;

/**
 * View
 * @author kara.vladimir2@gmail.com.
 */
public class View {
    public void printMsg(String s) {
        System.out.println(s);
    }

    public void printTours(List<Tour> tours) {
        tours.stream().forEach(System.out::println);
    }
}
