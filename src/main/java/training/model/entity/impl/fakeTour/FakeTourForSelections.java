package training.model.entity.impl.fakeTour;

import training.model.entity.AbstractTour;
import training.model.entity.TypeOfCatering;
import training.model.entity.TypeOfTransfer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class FakeTourForSelections extends AbstractTour {
    private FakeTourForSelections() {
        super();
    }

    private FakeTourForSelections(String name, BigDecimal price, int duration,
                                  TypeOfTransfer transfer, TypeOfCatering catering) {
        super(name, price, duration, transfer, catering);
    }

    public static Builder getBuilder() {
        return new FakeTourForSelections().new Builder();
    }

    public class Builder {

        public Builder setPrice(BigDecimal price) {
            FakeTourForSelections.this.price = price;
            return this;
        }

        public Builder setDuration(int i) {
            FakeTourForSelections.this.duration = i;
            return this;
        }

        public Builder setTransfer(TypeOfTransfer transfer) {
            FakeTourForSelections.this.transfer = transfer;
            return this;
        }

        public Builder setCatering(TypeOfCatering catering) {
            FakeTourForSelections.this.catering = catering;
            return this;
        }

        public FakeTourForSelections build() {
            FakeTourForSelections.this.name = "fake";
            return FakeTourForSelections.this;
        }
    }
}
