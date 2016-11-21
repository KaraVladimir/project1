package training.controller;

import training.InitTour;
import training.model.Model;
import training.model.entity.AbstractTour;
import training.model.entity.utils.FilterObj;
import training.model.entity.utils.SortObj;
import training.view.View;
import training.model.entity.utils.SortObj.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Controller
 * @author kara.vladimir2@gmail.com.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * main logic in this method
     */
    public void processUser() {
        for (InitTour initTour : InitTour.values()) {
            model.addTour(initTour.getTour());
        }
        List<SortObj> list = new ArrayList<>();
        list.add(new SortObj(Model.Fields.TRANSFER, Orders.ASC));
        list.add(new SortObj(Model.Fields.DURATION, Orders.DESC));
        view.printTours(model.filterTours(list));
        System.out.println("=====================================");
        List<FilterObj> filterObjs = new ArrayList<>();
        filterObjs.add(new FilterObj(Model.Fields.PRICE, FilterObj.Expression.MORE, BigDecimal.valueOf(500)));
        filterObjs.add(new FilterObj(Model.Fields.TRANSFER, FilterObj.Expression.EQUAL,
                AbstractTour.TypeOfTransfer.TRAIN));
        view.printTours(model.selectTours(filterObjs));
    }

    public Model getModel() {
        return model;
    }
}
