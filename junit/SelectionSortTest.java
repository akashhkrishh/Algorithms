import org.example.SelectionSort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testSortEmptyArray() {
        int[] input = {};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{}, input);
    }

    @Test
    public void testSortSingleElementArray() {
        int[] input = {5};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{5}, input);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
    }

    @Test
    public void testSortUnorderedArray() {
        int[] input = {3, 1, 4, 1, 5, 9, 2};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 9}, input);
    }

    @Test
    public void testSortArrayWithDuplicates() {
        int[] input = {2, 3, 1, 3, 2, 1};
        SelectionSort.sort(input);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3}, input);
    }
}
