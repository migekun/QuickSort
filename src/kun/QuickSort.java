package kun;

import java.util.List;

import static util.GetNumbers.getNumbers;;

/**
 * @author migekun
 *
 */
public class QuickSort {
	
	public QuickSort() { }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers = getNumbers();
		int total = quickSort(numbers);
		System.out.println("Ordered list: " + numbers.toString());
		System.out.println(total);
	}

	/**
	 * 
	 * @param numbers
	 * @return the number of conditions += numbers.size - 1
	 */
	public static int quickSort(List<Integer> numbers)
	{
		if (numbers.size() <= 1) return 0;
		
		int leftIndex = 0;
		int rightIndex = numbers.size();

	 	int pivotIndex = partition(numbers, 0, numbers.size());
		        
		int count1 = quickSort(numbers.subList(0, pivotIndex - 1));
		int count2 = quickSort(numbers.subList(pivotIndex, numbers.size()));
		
		return count1 + count2 + (rightIndex - leftIndex - 1);
	}

	/**
	 * 
	 * @param numbers to order
	 * @param leftIndex to start the order
	 * @param rightIndex to finish the order
	 * @return pivot index
	 */
	private static int partition(List<Integer> numbers, int leftIndex, int rightIndex) {
		int pivotIndex = getPrivotIndex(numbers, leftIndex, Method.LAST);
		int index = leftIndex + 1;
		
		//it's needed to swap the content of the pivot order, also the pivot index to the array's left position 
		swap(numbers, leftIndex, pivotIndex);
		pivotIndex = leftIndex;

		for (int j = leftIndex + 1 ; j < rightIndex; j++) {
			if (numbers.get(j) < numbers.get(pivotIndex)) {
				//if the number is less than the pivot, it is swapped 
				swap(numbers, j, index);
				index ++;
			}
		}
		
		swap(numbers, leftIndex, index - 1);
		//numbers:[< pivot | pivot | > pivot]; <pivot and >pivot shouldn't be ordered, recursive call will order
		return index;
	}

	private static int getPrivotIndex(List<Integer> numbers, int leftIndex, Method method) {
		int firstIndex = leftIndex;
		int lastIndex = numbers.size() - 1;
		int middleIndex = numbers.size() / 2;
	    int pivotIndex = 0;
		switch (method) {
		case FIRST:
			pivotIndex = firstIndex; //162085
			break;
		case LAST:
			pivotIndex = lastIndex; //164123
			break;
		case MIDDLE:
			 pivotIndex = getMiddle(numbers, firstIndex, lastIndex, middleIndex); //131226
			break;
		default:
			break;
		}
		return pivotIndex;
	}

	/**
	 * 
	 * Stackoverflow: http://stackoverflow.com/questions/1582356/fastest-way-of-finding-the-middle-value-of-a-triple#14676309
	 * @param firstIndex
	 * @param lastIndex
	 * @param middleIndex
	 * @return
	 */
	private static int getMiddle(List<Integer> numbers, int firstIndex, int lastIndex, int middleIndex) {
		int maxNumber = Math.max(Math.max(numbers.get(firstIndex), numbers.get(lastIndex)), numbers.get(middleIndex));
		int minNumber = Math.min(Math.min(numbers.get(firstIndex), numbers.get(lastIndex)), numbers.get(middleIndex));
		int middleNumber = numbers.get(firstIndex) ^ numbers.get(lastIndex) ^ numbers.get(middleIndex) ^ maxNumber ^ minNumber;
		return numbers.indexOf(middleNumber);
	}

	private static void swap(List<Integer> numbers, int index1, int index2) {
		int index1Value = numbers.get(index1);
		int index2Value = numbers.get(index2);
		numbers.set(index1, index2Value);
		numbers.set(index2, index1Value);	
	}
	
	private enum Method {
		FIRST, LAST, MIDDLE
	}
}
