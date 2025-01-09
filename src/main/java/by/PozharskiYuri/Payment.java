package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    private final Payable paymentMean;
    private final List<Item> payedItems = new ArrayList<>();

    public Payment(Payable paymentMean) {
        this.paymentMean = paymentMean;
    }

    private class Item {

        @NotNull
        public String getDescription() {
            return description;
        }

        public void setDescription(@NotNull String description) {
            this.description = description;
        }

        private String description;

        public double getPrice() {
            return price;
        }

        private final double price;

        /**
         * @param description of item
         * @param price price of item
         * @throws IllegalArgumentException price is more than payment mean can decrease
         */
        public Item(@NotNull String description, double price) throws IllegalArgumentException {
            if (paymentMean.decreaseBalance(price)) {
                this.description = description;
                this.price = price;
            }
            else {
                throw new IllegalArgumentException(paymentMean.getName() + " does not nave enough resources to pay " + price + " for [" + description + "]");
            }
        }

    }

}
