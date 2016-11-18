package training.view;

import training.model.entity.Tour;

import java.util.TreeSet;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class View {
    public void printMsg(String s) {
        System.out.println(s);
    }

    public void printTree(TreeSet<Tour> tours) {
        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }
    }
}
