package training;

import com.sun.deploy.ref.AppModel;
import com.sun.glass.ui.CommonDialogs;
import training.controller.Controller;
import training.model.Model;
import training.view.View;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();

    }

}
