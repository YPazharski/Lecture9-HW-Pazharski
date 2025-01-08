package by.PozharskiYuri;

public class FoodPlate implements Eatable {

    private int food;

    public FoodPlate(int food) {
        if (food < 0) {
            throw new IllegalArgumentException("FoodPlate quantity can't be negative.");
        }

        this.food = food;
    }

    @Override
    public int decreaseFood(int foodDecrement) {
        if (foodDecrement >= food) {
            foodDecrement = food;
            food = 0;
        } else {
            food -= foodDecrement;
        }

        return foodDecrement;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    @Override
    public int getFood() {
        return food;
    }

}
