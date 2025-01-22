package by.PazharskiYury.Lesson13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.datafaker.*;

public class Lesson13Main {

    public static void main(String[] args) {
        String[] strings = get20NonUniqueStrings();
        System.out.println(Arrays.toString(strings));
        Map<String, Integer> map = getHashMapWithWithCountedEntries(strings);

        System.out.println();
        for (Map.Entry<String, Integer> kv : map.entrySet()) {
            System.out.printf("\"%s\" string has %d %s in the array.", kv.getKey(), kv.getValue(),
                    kv.getValue() == 1 ? "entry" : "entries");
            System.out.println();
        }
    }

    public static String[] get20NonUniqueStrings() {
        Faker faker = new Faker();
        String[] source = new String[15];
        for (int i = 0; i < source.length; i++) {
            source[i] = faker.warhammerFantasy().heros();
        }

        String[] result = new String[20];
        for (int i = 0; i < result.length; i++) {
            result[i] = source[faker.number().numberBetween(0, source.length)];
        }

        return result;
    }

    public static <T> HashMap<T, Integer> getHashMapWithWithCountedEntries(T[] array) {
        HashMap<T, Integer> result = new HashMap<>();
        for (T element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }

        return result;
    }

}