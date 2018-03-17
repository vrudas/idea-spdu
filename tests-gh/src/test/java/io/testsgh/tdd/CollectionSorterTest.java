package io.testsgh.tdd;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.testng.Assert.assertEquals;

public class CollectionSorterTest {

    private ListSorter listSorter;

    @BeforeMethod
    public void setUp() {
        listSorter = new ListSorter();
    }

    @DataProvider(name = "testSortParameters")
    public static Object[][] testSortParameters() {
        return new Object[][]{
            {emptyList(), emptyList()},
            {
                Arrays.asList(0, 9, 8, 7, 6, 5, 4, 3, 2, 1),
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            }
        };
    }

    @Test(dataProvider = "testSortParameters")
    public void testSort(List<Integer> listToSort, List<Integer> sortedList) {
        List<Integer> actualList = listSorter.sort(listToSort);

        assertEquals(actualList, sortedList);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testSortFail() {
        listSorter.sort(null);
    }
}
