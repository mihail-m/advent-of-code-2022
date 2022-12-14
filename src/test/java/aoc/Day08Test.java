package aoc;

import static aoc.util.TestUtil.INPUT_FILE;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.util.BaseTest;

public class Day08Test extends BaseTest<Day08Task, Integer> {
    private static final Integer[][] SAMPLE_INPUT = new Integer[][]{
            new Integer[]{3, 0, 3, 7, 3},
            new Integer[]{2, 5, 5, 1, 2},
            new Integer[]{6, 5, 3, 3, 2},
            new Integer[]{3, 3, 5, 4, 9},
            new Integer[]{3, 5 ,3, 9, 0}};

    private static final int SAMPLE_RESULT_TASK_1 = 21;

    private static final int SAMPLE_RESULT_TASK_2 = 8;

    @Test
    public void sampleTestTask1() {
        sampleTestTask1(Day08Task.builder(SAMPLE_INPUT)
                .solve(Day08Task.Solution.FIND_VISIBLE_TREES)
                .build(), SAMPLE_RESULT_TASK_1);
    }

    @Test
    public void sampleTestTask2() {
        sampleTestTask2(Day08Task.builder(SAMPLE_INPUT)
                .solve(Day08Task.Solution.FIND_MAX_VIEWING_SCORE)
                .build(), SAMPLE_RESULT_TASK_2);
    }

    @Test
    public void testTask1() {
        testTask1(Day08Task.builder(parseInput())
                .solve(Day08Task.Solution.FIND_VISIBLE_TREES)
                .build());
    }

    @Test
    public void testTask2() {
        testTask2(Day08Task.builder(parseInput())
                .solve(Day08Task.Solution.FIND_MAX_VIEWING_SCORE)
                .build());
    }

    private Integer[][] parseInput() {
        List<String> input = readInput(INPUT_FILE);

        Integer[][] map = new Integer[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.get(i).charAt(j)));
            }
        }

        return map;
    }
}
