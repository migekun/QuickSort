package kun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author migekun
 *
 */
public class QuickSort {

	public QuickSort()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers = getNumbers();
		quickSort(numbers);
		System.out.println("-----------" + numbers.toString());
	}

	public static void quickSort(List<Integer> numbers)
	{
		if (numbers.size() <= 1) return;
		int leftIndex = 0;
		int rightIndex = numbers.size();

	 	int pivotIndex = partition(numbers, leftIndex, rightIndex);
		        
		quickSort(numbers.subList(leftIndex, pivotIndex));
		quickSort(numbers.subList(pivotIndex, numbers.size()));
		
	}

	private static int partition(List<Integer> numbers, int leftIndex, int rightIndex) {
		int pivot = numbers.get(leftIndex);
		int index = leftIndex + 1;

		for (int j = leftIndex + 1 ; j < rightIndex; j++) {
			if (numbers.get(j) < pivot) {
//				System.out.println("compare " + numbers.get(j));
				swap(numbers, j, index);
				index ++;
			}
		}
		swap(numbers, leftIndex, index - 1);
		return index;
	}

	private static void swap(List<Integer> numbers, int index1, int index2) {
//		System.out.println("sswap " + numbers.toString() + " index 1: " + index1 + " index 2: " + index2 );
		int index1Value = numbers.get(index1);
		int index2Value = numbers.get(index2);
		numbers.set(index1, index2Value);
		numbers.set(index2, index1Value);
		
	}

	/**
	 * 
	 * @param numbers
	 * @return
	 */
	private static Integer getPivotIndex(List<Integer> numbers) {
		return numbers.get(0);
	}
	
	/**
	 * 
	 * @return the list of numbers contained in the file
	 */
	private static List<Integer> getNumbers() {
		BufferedReader br = null;
		List<Integer> numbers = new LinkedList<Integer>();
		try {
			br = new BufferedReader(new FileReader("QuickSort.txt"));

			String line = br.readLine();

			while (line != null) {
				if (line != null) {
					numbers.add(Integer.parseInt(line));
				}
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
		return numbers;
	}
}
