package aoc;

import java.util.List;
import java.util.Map;

import aoc.base.Task;

public class Day02Task extends Task<List<String>, Integer> {

    private Day02Task(List<String> input) {
        super(input);
        this.result = 0;
    }

    public enum Solution implements SolutionStrategy<Day02Task> {

        FIND_GUESSED_STRATEGY_SCORE {
            @Override
            public void solve(Day02Task task) {
                Map<String, Integer> matchPoints = Map.of(
                        "A X", 4,
                        "A Y", 8,
                        "A Z", 3,
                        "B X", 1,
                        "B Y", 5,
                        "B Z", 9,
                        "C X", 7,
                        "C Y", 2,
                        "C Z", 6
                );

                task.result = task.input.stream()
                        .mapToInt(matchPoints::get)
                        .sum();
            }
        },

        FIND_ACTUAL_STRATEGY_SCORE {
            @Override
            public void solve(Day02Task task) {
                Map<String, Integer> matchPoints = Map.of(
                        "A X", 3,
                        "A Y", 4,
                        "A Z", 8,
                        "B X", 1,
                        "B Y", 5,
                        "B Z", 9,
                        "C X", 2,
                        "C Y", 6,
                        "C Z", 7
                );

                task.result = task.input.stream()
                        .mapToInt(matchPoints::get)
                        .sum();
            }
        }
    }

    public static Builder<Day02Task> builder(List<String> input) {
        return new Builder<>(() -> new Day02Task(input));
    }
}
