package training;

import training.controller.Controller;
import training.model.Model;
import training.view.View;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
