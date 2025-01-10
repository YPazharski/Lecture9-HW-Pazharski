package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Payment {

    private final Payable paymentMean;
    private final List<Item> payedItems = new ArrayList<>();

    public Payable getPaymentMean() {
        return paymentMean;
    }

    /**
     * @return payedItems List that can not be modified.
     */
    public List<Item> getPayedItems() {
        return Collections.unmodifiableList(payedItems);
    }

    public Payment(Payable paymentMean) {
        this.paymentMean = paymentMean;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMean=" + paymentMean +
                ", payedItems=" + payedItems +
                '}';
    }

    public class Item {

        private final double price;
        private String description;

        @NotNull
        public String getDescription() {
            return description;
        }

        public void setDescription(@NotNull String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public Item(@NotNull String description, double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price can not be negative!");
            }

            this.description = description;
            this.price = price;
        }

        public boolean pay() {
            if (paymentMean.decreaseBalance(price)) {
                payedItems.add(this);
                return true;
            }

            return false;
        }

        @Override
        public @NotNull String toString() {
            return "Item{" +
                    "price=" + price +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

}
