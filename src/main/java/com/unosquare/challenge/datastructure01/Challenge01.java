package com.unosquare.challenge.datastructure01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***
 * Create a list data structure that works following the next set of rules:
 * - push method: any new element is inserted at the back, the list consists of unique elements if an element already exists the operation is ignored
 * - pop method: returns the element located at the top of the list and removes the element from the list
 * - get method: returns the element located at the index N, in which N is an integer value provided as parameter
 * - max size: the list will support max 5 elements, in case of an overflow the first element that was read the least amount of times will be removed.
 * Example:
 *   push(1), push(2), push(3), push(4), push(5), push(2), get(2), get(3), get(3), get(2), get(1), push(7), pop()
 * Expected result:
 * 1, 2, 3, 7
 *
 ***/

public class Challenge01 {

    private final List<Item> items = new ArrayList<>();

    private final Integer MAX_SIZE = 5;

    public List<Item> getItems() {
        return items;
    }

    public void push(Integer value) {
        boolean valueExists = items.stream().anyMatch(item -> item.getNumber().equals(value));
        if (valueExists) {
            return;
        }

        if (items.size() >= MAX_SIZE) {
            Item lessAccessedItem = items.stream()
                    .min(Comparator.comparing(Item::getTimesAccessed))
                    .orElseThrow(() -> new RuntimeException("Unable to find lowest accessed number"));

            int indexOfItem = items.indexOf(lessAccessedItem);

            items.remove(indexOfItem);
            items.add(indexOfItem, new Item(value));
        } else {
            items.add(new Item(value));
        }
    }

    public Integer pop() {
        int lastItemIndex = items.size() - 1;
        Item lastItem = items.get(lastItemIndex);
        items.remove(lastItemIndex);

        return lastItem.getNumber();
    }

    public Integer get(Integer index) {
        Item item = items.get(index);
        item.setTimesAccessed(item.getTimesAccessed() + 1);
        items.set(index, item);

        return item.getNumber();
    }
}
