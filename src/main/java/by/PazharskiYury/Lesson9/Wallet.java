package by.PazharskiYury.Lesson9;

import org.jetbrains.annotations.NotNull;

public class Wallet implements Payable {

    private final String name;
    private double currentBalance;

    public Wallet(@NotNull String name, double currentBalance) {
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public Wallet(@NotNull String name) {
        this.name = name;
    }

    @Override
    @NotNull
    public String getName() {
        return name;
    }

    @Override
    public double getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public void increaseBalance(double increment) {
        if (increment < 0) {
            throw new IllegalArgumentException("Increment can't be negative!");
        }

        currentBalance += increment;
    }

    @Override
    public boolean decreaseBalance(double decrement) {
        if (decrement < 0) {
            throw new IllegalArgumentException("Decrement can't be negative!");
        } else if (decrement > currentBalance) {
            return false;
        }

        currentBalance -= decrement;
        return true;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "name='" + name + '\'' +
                ", currentBalance=" + String.format("%.2f", currentBalance) +
                '}';
    }

}
