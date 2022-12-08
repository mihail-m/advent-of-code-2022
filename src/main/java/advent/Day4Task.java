package advent;

import advent.base.Task;

import java.util.List;

public class Day4Task extends Task<List<List<Integer>>, Integer> {

    private Day4Task(List<List<Integer>> input) {
        super(input);
        this.result = 0;
    }

    public enum Solution implements SolutionStrategy<Day4Task> {

        FIND_COMPLETELY_COVERED_INTERVALS_COUNT {
            @Override
            public void solve(Day4Task solution) {
                solution.result = (int) solution.input.stream()
                        .filter(Solution::intervalCompletelyCovered)
                        .count();
            }
        },

        FIND_OVERLAPPING_INTERVALS_COUNT {
            @Override
            public void solve(Day4Task solution) {
                solution.result = (int) solution.input.stream()
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

    public static Builder<Day4Task> builder(List<List<Integer>> input) {
        return new Builder<>(() -> new Day4Task(input));
    }
}
