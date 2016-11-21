import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import training.InitTour;
import training.controller.Controller;
import training.model.Model;
import training.model.entity.AbstractTour;
import training.model.entity.Tour;
import training.model.entity.utils.FilterObj;
import training.model.entity.utils.SortObj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class TestModelMethods {
    private static Model model = new Model();
    @BeforeClass
    public static void init() {
        model = new Model();
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
        List<SortObj> list = new ArrayList<>();
        list.add(new SortObj(Model.Fields.TRANSFER, SortObj.Orders.ASC));
        list.add(new SortObj(Model.Fields.DURATION, SortObj.Orders.DESC));
        List<Tour> tours = model.filterTours(list);
        Assert.assertEquals("First element",tours.get(0).getName(),"EuroBus");
        Assert.assertEquals("Last element",tours.get(5).getName(),"Hawaii");
    }

    @Test
    public void testFilter() {
        List<FilterObj> filterObjs = new ArrayList<>();
        filterObjs.add(new FilterObj(Model.Fields.PRICE, FilterObj.Expression.MORE, BigDecimal.valueOf(500)));
        filterObjs.add(new FilterObj(Model.Fields.TRANSFER, FilterObj.Expression.EQUAL,
                AbstractTour.TypeOfTransfer.TRAIN));
        List<Tour> tours = model.selectTours(filterObjs);
        Assert.assertEquals("Size of list",tours.size(),2);
        Assert.assertEquals("First element",tours.get(0).getName(),"Mediterranean");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFilterException() {
        List<FilterObj> filterObjs = new ArrayList<>();
        filterObjs.add(new FilterObj(Model.Fields.CATERING, FilterObj.Expression.MORE, AbstractTour.TypeOfCatering.AI));
        model.selectTours(filterObjs);
    }
}
