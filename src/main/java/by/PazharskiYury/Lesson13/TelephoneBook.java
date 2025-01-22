package by.PazharskiYury.Lesson13;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TelephoneBook {

    private final HashMap<String, HashSet<String>> data = new HashMap<>();

    public boolean add(@NotNull String name, @NotNull String phoneNumber) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (!phoneNumberIsCorrect(phoneNumber)) {
            throw new IllegalArgumentException("Unexpected phone format.");
        }

        if (data.containsKey(name)) {
            return data.get(name).add(phoneNumber);
        }
        else {
            data.put(name, new HashSet<>());
            data.get(name).add(phoneNumber);
            return true;
        }
    }

    public Set<String> get(@NotNull String name) {
        HashSet<String> result = data.get(name);
        return result == null ? null : new HashSet<>(result);
    }

    private boolean phoneNumberIsCorrect(String phoneNumber) {
        return  phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
    }

}