package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import kun.QuickSort;

import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void test_null() {
		QuickSort.quickSort(null);
	}

	@Test
	public void test() {
		List<Integer> numbers = new LinkedList<Integer>(Arrays.asList(4, 5, 6, 1, 2, 3));
		
		QuickSort.quickSort(numbers);
		
		int value = 1;
		assertThat(numbers.get(0), is(value ++));
		assertThat(numbers.get(1), is(value ++));
		assertThat(numbers.get(2), is(value ++));
		assertThat(numbers.get(3), is(value ++));
		assertThat(numbers.get(4), is(value ++));
		assertThat(numbers.get(5), is(value ++));
	}
	
}
