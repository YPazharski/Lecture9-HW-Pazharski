package by.PozharskiYuri;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Nothing happens in main method of " + Main.class.getName() + " class");
        Animal animal = new Animal();
        Dog dog = new Dog("Dog");
        Cat cat = new Cat("Cat");
        System.out.println(animal);
        System.out.println(dog);
        System.out.println(cat);
    }

}