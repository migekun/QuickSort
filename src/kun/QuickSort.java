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

	private static int totalComparisions = 0;
	
	public QuickSort()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers = getNumbers();
		int total = quickSort(numbers);
		System.out.println("Ordered list: " + numbers.toString());
		System.out.println(totalComparisions);
		System.out.println(total);
	}

	public static int quickSort(List<Integer> numbers)
	{
		if (numbers.size() <= 1) return 0;
//		 totalComparisions += numbers.size() - 1;
		int leftIndex = 0;
		int rightIndex = numbers.size();

	 	int pivotIndex = partition(numbers, 0, numbers.size());
		        
		int count1 = quickSort(numbers.subList(0, pivotIndex - 1));
		int count2 = quickSort(numbers.subList(pivotIndex, numbers.size()));
		return count1 + count2 + (rightIndex - leftIndex - 1);
	}

	private static int partition(List<Integer> numbers, int leftIndex, int rightIndex) {
		int pivotIndex = getPrivotIndex(numbers, leftIndex);
		int index = leftIndex + 1;
		
		swap(numbers, leftIndex, pivotIndex);

		for (int j = leftIndex + 1 ; j < rightIndex; j++) {
			if (numbers.get(j) < numbers.get(pivotIndex)) {
				swap(numbers, j, index);
				index ++;
			}
		}
		
		swap(numbers, leftIndex, index - 1);
		return index;
	}

	private static int getPrivotIndex(List<Integer> numbers, int leftIndex) {
		int firstIndex = leftIndex;
		int lastIndex = numbers.size() - 1;
		int middleIndex = numbers.size() / 2;
		//int pivotIndex = leftIndex; //162085
//		int pivotIndex = numbers.size() - 1; //159491
		int pivotIndex = Math.
		return pivotIndex;
	}

	private static void swap(List<Integer> numbers, int index1, int index2) {
		int index1Value = numbers.get(index1);
		int index2Value = numbers.get(index2);
		numbers.set(index1, index2Value);
		numbers.set(index2, index1Value);	
	}
	
	/**
	 * 
	 * @return the list of numbers contained in the file
	 */
	private static List<Integer> getNumbers() {
		BufferedReader br = null;
		List<Integer> numbers = new LinkedList<Integer>();
		try {
			br = new BufferedReader(new FileReader("/Users/miguelangelnavasgarcia/Documents/workspace/QuickSort/src/kun/QuickSort.txt"));

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
