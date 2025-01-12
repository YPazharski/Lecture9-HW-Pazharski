package by.PazharskiYury.Lesson9;

/**
 * Implemented in classes describing objects that can be used as means of payment
 */
public interface Payable {

    String getName();
    double getCurrentBalance();

    /**
     * @param increment is NON-NEGATIVE!
     */
    void increaseBalance(double increment);

    /**
     * @param decrement is NON-NEGATIVE!
     * @return true if operation is successful, otherwise - false.
     */
    boolean decreaseBalance(double decrement);

}
