package training.model.entity.utils;

import training.model.Model;

/**
 * Class wrapper for sorting order
 * @author kara.vladimir2@gmail.com.
 */
public class SortObj {
    private Model.Fields field;
    private Orders order;

    public SortObj(Model.Fields field, Orders order) {
        this.field = field;
        this.order = order;
    }

    public Model.Fields getField() {
        return field;
    }

    public Orders getOrder() {
        return order;
    }

    public enum Orders {
        DESC, ASC
    }

}
