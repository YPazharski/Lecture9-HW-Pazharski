package by.PozharskiYuri;

/**
 * Implemented in classes describing objects that can be eaten.
 */
public interface Eatable {

    /**
     * @param foodDecrement NON-NEGATIVE. max quantity of food to be decreased.
     * @return quantity of food decreased
     */
    int decreaseFood(int foodDecrement);

    /**
     * @param foodIncrement NON-NEGATIVE.
     */
    void increaseFood(int foodIncrement);

    int getFood();
}
