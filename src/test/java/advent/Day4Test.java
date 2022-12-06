package advent;

import static advent.util.TestUtil.openFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {

    private static final String INPUT_FILE = "input.txt";

    static final List<List<Integer>> SAMPLE_INPUT = List.of(
            List.of(2, 4, 6 ,8),
            List.of(2, 3, 4 ,5),
            List.of(5, 7, 7 ,9),
            List.of(2, 8, 3 ,7),
            List.of(6, 6, 4 ,6),
            List.of(2, 6, 4 ,8));

    private static final int SAMPLE_RESULT_TASK_1 = 2;

    private static final int SAMPLE_RESULT_TASK_2 = 4;

    @Test
    public void sampleTestTask1() {
        Day4Task task = Day4Task.builder(SAMPLE_INPUT)
                .solve(Day4Task.Solution.FIND_COMPLETELY_COVERED_INTERVALS_COUNT)
                .build();

        Assertions.assertEquals(SAMPLE_RESULT_TASK_1, task.getResult());
    }

    @Test
    public void sampleTestTask2() {
        Day4Task task = Day4Task.builder(SAMPLE_INPUT)
                .solve(Day4Task.Solution.FIND_OVERLAPPING_INTERVALS_COUNT)
                .build();

        Assertions.assertEquals(SAMPLE_RESULT_TASK_2, task.getResult());
    }

    @Test
    public void testTask1() {
        Day4Task task = Day4Task
                .builder(readInput())
                .solve(Day4Task.Solution.FIND_COMPLETELY_COVERED_INTERVALS_COUNT)
                .build();

        System.out.printf("Result for task 1 is: %s", task.getResult());
    }

    @Test
    public void testTask2() {
        Day4Task task = Day4Task
                .builder(readInput())
                .solve(Day4Task.Solution.FIND_OVERLAPPING_INTERVALS_COUNT)
                .build();

        System.out.printf("Result for task 2 is: %s", task.getResult());
    }

    private List<List<Integer>> readInput() {
        Scanner scanner = openFile(this.getClass(), INPUT_FILE);

        List<List<Integer>> intervalPairs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            intervalPairs.add(Arrays.stream(inputLine.split("([,\\-])")).map(Integer::parseInt).toList());
        }

        return intervalPairs;
    }
}
