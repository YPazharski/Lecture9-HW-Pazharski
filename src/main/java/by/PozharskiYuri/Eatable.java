package by.PozharskiYuri;

public interface Eatable {

    /**
     * @param foodDecrement max quantity of food to be decreased
     * @return quantity of food decreased
     */
    int decreaseFood(int foodDecrement);

    int getFood();
}
