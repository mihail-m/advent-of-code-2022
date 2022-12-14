package aoc;

import java.util.List;

import aoc.base.Task;

public class Day04Task extends Task<List<List<Integer>>, Integer> {

    private Day04Task(List<List<Integer>> input) {
        super(input);
        this.result = 0;
    }

    public enum Solution implements SolutionStrategy<Day04Task> {

        FIND_COMPLETELY_COVERED_INTERVALS_COUNT {
            @Override
            public void solve(Day04Task task) {
                task.result = (int) task.input.stream()
                        .filter(Solution::intervalCompletelyCovered)
                        .count();
            }
        },

        FIND_OVERLAPPING_INTERVALS_COUNT {
            @Override
            public void solve(Day04Task task) {
                task.result = (int) task.input.stream()
                        .filter(Solution::intervalOverlap)
                        .count();
            }
        };

        private static boolean intervalCompletelyCovered(List<Integer> intervals) {
            assert intervals.size() == 4;

            return (intervals.get(0) >= intervals.get(2) && intervals.get(1) <= intervals.get(3))
                    || intervals.get(0) <= intervals.get(2) && intervals.get(1) >= intervals.get(3);
        }

        private static boolean intervalOverlap(List<Integer> intervals) {
            assert intervals.size() == 4;

           return (intervals.get(0) <= intervals.get(2) && intervals.get(2) <= intervals.get(1))
                   || (intervals.get(0) <= intervals.get(3) && intervals.get(3) <= intervals.get(1))
                   || (intervals.get(2) <= intervals.get(0) && intervals.get(0) <= intervals.get(3))
                   || (intervals.get(2) <= intervals.get(1) && intervals.get(1) <= intervals.get(3));
        }
    }

    public static Builder<Day04Task> builder(List<List<Integer>> input) {
        return new Builder<>(() -> new Day04Task(input));
    }
}
