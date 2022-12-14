package aoc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aoc.base.Task;

public class Day03Task extends Task<List<String>, Integer> {

    private Day03Task(List<String> input) {
        super(input);
        this.result = 0;
    }

    public enum Solution implements SolutionStrategy<Day03Task> {

        FIND_DUPLICATE_ITEMS_SUM {
            @Override
            public void solve(Day03Task task) {
                task.result = task.input.stream()
                        .mapToInt(rucksack -> findMatchingItemValue(List.of(
                                rucksack.substring(0, rucksack.length() / 2),
                                rucksack.substring(rucksack.length() / 2))))
                        .sum();
            }
        },
        FIND_BADGES_SUM {
            @Override
            public void solve(Day03Task task) {
                for (int index = 0; index < task.input.size(); index += 3) {
                    task.result += findMatchingItemValue(List.of(
                            task.input.get(index),
                            task.input.get(index + 1),
                            task.input.get(index + 2)
                    ));
                }
            }
        };

        private static int findMatchingItemValue(List<String> itemGroups) {
            List<Set<Character>> itemSets = new ArrayList<>();
            itemGroups.forEach(itemGroup -> {
                Set<Character> items = new HashSet<>();
                for (int index = 0; index < itemGroup.length(); index++) {
                    items.add(itemGroup.charAt(index));
                }
                itemSets.add(items);
            });

            Set<Character> matchingItem = new HashSet<>(itemSets.get(0));
            itemSets.forEach(matchingItem::retainAll);
            assert matchingItem.size() == 1;

            char item = matchingItem.stream().findFirst().get();

            if (item >= 'a') {
                return item - 'a' + 1;
            } else {
                return item - 'A' + 27;
            }
        }
    }

    public static Builder<Day03Task> builder(List<String> input) {
        return new Builder<>(() -> new Day03Task(input));
    }
}
