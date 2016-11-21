package training.model.entity.utils;

import training.model.Model;

/**
 * Class-wrappers for filtering condition
 *
 * @author kara.vladimir2@gmail.com.
 */
public class FilterObj {
    private Model.Fields fields;
    private Expression expression;
    private Object value;

    public FilterObj(Model.Fields fields, Expression expression, Object value) {
        this.fields = fields;
        this.expression = expression;
        this.value = value;
    }

    public Model.Fields getFields() {
        return fields;
    }

    public Expression getExpression() {
        return expression;
    }

    public Object getValue() {
        return value;
    }

    public enum Expression {
        LESS, EQUAL, MORE
    }
}
