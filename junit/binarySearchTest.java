import org.junit.Test;
import static org.junit.Assert.*;

public class binarySearchTest {

    @Test
    public void testBinarySearchElementExists() {
        int[] array = {1, 42, 422, 2122};
        int result = BinarySearch.binarySearch(array, 42, 0, array.length - 1);
        assertEquals(1, result);
    }

    @Test
    public void testBinarySearchElementExistsAtStart() {
        int[] array = {1, 42, 422, 2122};
        int result = Main.BinarySearch(array, 1, 0, array.length - 1);
        assertEquals(0, result);
    }

    @Test
    public void testBinarySearchElementExistsAtEnd() {
        int[] array = {1, 42, 422, 2122};
        int result = Main.BinarySearch(array, 2122, 0, array.length - 1);
        assertEquals(3, result);
    }

    @Test
    public void testBinarySearchElementDoesNotExist() {
        int[] array = {1, 42, 422, 2122};
        int result = Main.BinarySearch(array, 100, 0, array.length - 1);
        assertEquals(-1, result);
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] array = {};
        int result = Main.BinarySearch(array, 42, 0, array.length - 1);
        assertEquals(-1, result);
    }

    @Test
    public void testBinarySearchSingleElementArrayElementExists() {
        int[] array = {42};
        int result = Main.BinarySearch(array, 42, 0, array.length - 1);
        assertEquals(0, result);
    }

    @Test
    public void testBinarySearchSingleElementArrayElementDoesNotExist() {
        int[] array = {42};
        int result = Main.BinarySearch(array, 100, 0, array.length - 1);
        assertEquals(-1, result);
    }

    @Test
    public void testBinarySearchMultipleOccurrences() {
        int[] array = {1, 42, 42, 42, 422, 2122};
        int result = Main.BinarySearch(array, 42, 0, array.length - 1);
        assertTrue(result >= 1 && result <= 3);
    }

    @Test
    public void testBinarySearchNegativeNumbers() {
        int[] array = {-10, -5, 0, 5, 10};
        int result = Main.BinarySearch(array, -5, 0, array.length - 1);
        assertEquals(1, result);
    }
}
