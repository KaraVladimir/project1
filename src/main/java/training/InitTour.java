package training;

import training.model.entity.AbstractTour.TypeOfCatering;
import training.model.entity.AbstractTour.TypeOfTransfer;
import training.model.entity.Tour;
import training.model.entity.impl.*;

import java.math.BigDecimal;

/**
 * @author kara.vladimir2@gmail.com.
 */
public enum InitTour {
    BT1(new BeachTour("Hawaii", BigDecimal.valueOf(2400), 14, TypeOfTransfer.PLANE, TypeOfCatering.HB, 4)),
    BT2(new BeachTour("Turkey", BigDecimal.valueOf(600), 20, TypeOfTransfer.PLANE, TypeOfCatering.AI, 4)),
    CT(new CruiseTour("Mediterranean", BigDecimal.valueOf(1200), 20, TypeOfTransfer.TRAIN,
            TypeOfCatering.AI, "Tit")),
    ET(new ExcursionTour("EuroBus",BigDecimal.valueOf(200),5,TypeOfTransfer.BUS,TypeOfCatering.RO,
            new String[]{"Coliseum","Venice"})),
    SH_T(new ShoppingTour("Poland",BigDecimal.valueOf(300),5,TypeOfTransfer.BUS,TypeOfCatering.BB,
            new String[]{"shop1","shop2"})),
    ST(new SpaTour("Morshin",BigDecimal.valueOf(600),8,TypeOfTransfer.TRAIN,TypeOfCatering.FB,
            new String[]{"proc1","proc2"}));

    private Tour tour;

    InitTour(Tour tour) {
        this.tour = tour;
    }

    public Tour getTour() {
        return tour;
    }
}
