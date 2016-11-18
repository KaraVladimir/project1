import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.InitTour;
import training.controller.Controller;
import training.model.entity.Tour;
import training.model.entity.comparators.CompareTour;
import training.model.entity.comparators.FieldAndOrder;
import training.model.entity.impl.fakeTour.FakeTourForSelections;
import training.model.Model;
import training.view.View;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author kara.vladimir2@gmail.com.
 */

public class ControllerTest {
    private Model model;
    private Controller controller;

    @Before
    public void init() {
        controller = new Controller(new Model(), new View());
        model = controller.getModel();
        for (InitTour initTour : InitTour.values()) {
            model.addTour(initTour.getTour());
        }
    }

    @Test
    public void testInit() {
        Assert.assertEquals(model.getTours().size(),6);
    }

    @Test
    public void testSort() {
        TreeSet<Tour> tours = controller.sortTours(new CompareTour(FieldAndOrder.PRICE_DESC).getComparator(),
                model.getTours());
        Assert.assertTrue(tours.last().getPrice().equals(BigDecimal.valueOf(200)));
    }

    @Test
    public void testSelection() {
        FakeTourForSelections fakeTour = FakeTourForSelections.getBuilder().setPrice(BigDecimal.valueOf(1000)).setDuration(15).build();
        Set<Comparator<Tour>> comparators = new HashSet<>();
        comparators.add(new CompareTour(FieldAndOrder.PRICE_ASC).getComparator());
        comparators.add(new CompareTour(FieldAndOrder.DURATION_ASC).getComparator());
        TreeSet<Tour> tours = controller.selectTours(fakeTour, comparators, (SortedSet<Tour>) model.getTours());
        Assert.assertTrue((tours.size()==1)&&("Mediterranean".equals(tours.last().getName())));
    }

}
