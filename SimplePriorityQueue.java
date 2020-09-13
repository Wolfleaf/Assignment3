package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A Generic List of items that are sorted using Comparable from largest to smallest
 * 
 * @author Alex Thomsen and Guyan Cool
 * Current Version: 9/13/2020
 *
 * @param <Type>	Any object that implements Comparable and can be sorted
 */
public class SimplePriorityQueue<Type> implements PriorityQueue<Type>, Comparable<Type> {

	private Type[] data; // array where the data is stored

	private int actualLength; // length of the array

	private int dynamicLength; // length of the parts of the array we are actually using

	/**
	 * Constructor for SimplePriorityQueue
	 * Starts with an array of size 16
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue() {
		this.data = (Type[]) new Object[16];
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	/**
	 * Constructor for SimplePriorityQueue that utilizes Comparator
	 * Starts with an array of size 16
	 * 
	 * @param Comp type that can be used in Comparator
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue(Comparator<? super Type> Comp) {
		this.data = (Type[]) new Object[16];
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	/**
	 * Returns the smallest variable in the priority queue
	 */
	@Override
    public Type findMin() throws NoSuchElementException {
        if (dynamicLength == 0) {
            throw new NoSuchElementException();
        } else {
            return this.data[dynamicLength - 1];
        }
    }

	/**
	 * Deletes the smallest variable in the priority queue
	 */
	@Override
	public Type deleteMin() throws NoSuchElementException {

		Type deletedMin = this.findMin();
		this.data[dynamicLength - 1] = null;
		this.dynamicLength -= 1;
		return deletedMin;
	}

	/**
	 * Inserts an item of the Priority Queue type into the priority queue
	 * This class automatically sorts the queue and places the item in the correct location
	 * 
	 * @param item 	Item being inserted into the priority queue
	 */
	@SuppressWarnings("unchecked")
	public void insert(Type item) {
		
		int min = 0;
		int max = dynamicLength;
		int mid = 0;
		boolean itemFound = false;
		
		this.dynamicLength++;
		
		while (!itemFound) {
			mid = (((max - min) / 2) + min);

			if (this.data[mid] == item || max <= min) { //If item equals data
				itemFound = true;
			}
			else if (((Comparable<Type>) item).compareTo(this.data[mid]) < 0) { //If item is smaller than data
				min = mid + 1;
			}
			else if (((Comparable<Type>) item).compareTo(this.data[mid]) > 0) { //If item is larger than data
				max = mid;
			}
		}
		
		Type[] newData = (Type[]) new Object[actualLength];

        if (actualLength == dynamicLength) {
        	newData = (Type[]) new Object[actualLength * 2];
        	actualLength *=2;
        }
		
		for (int indexFirst = 0; indexFirst < mid; indexFirst++) {
            newData[indexFirst] = this.data[indexFirst];
        }
        newData[mid] = item;
        for (int indexSecond = mid; indexSecond < dynamicLength - 1; indexSecond++) {
            newData[indexSecond + 1] = this.data[indexSecond];
        }
        
		this.data = newData;
	}

	/**
	 * Inserts multiple items stored in a collection type into the priority queue
	 * Automatically sorts the items into their correct location
	 * 
	 * @param coll	Collection of items to be inserted
	 */
	@Override
	public void insertAll(Collection<? extends Type> coll) {
		for (Type var : coll) {
			this.insert(var);
		}

	}

	/**
	 * Outputs the amount of items in the priority queue
	 */
	@Override
	public int size() {
		return dynamicLength;
	}

	/**
	 * Boolean expression that returns true if there are no items in the priority queue
	 */
	@Override
	public boolean isEmpty() {
		if (this.data[0] == null)
		{
			dynamicLength = 0;
			return true;
		}
		return false;
	}

	/**
	 * Removes all items from the priority queue
	 */
	@Override
	public void clear() {
		for (Type var : data) {
			var = null;
		}
		dynamicLength = 0;
	}

	/**
	 * Compares two items for sorting in the priority queue
	 */
	@Override
	public int compareTo(Type item) {
		return this.compareTo(item);
	}
	
	/**
	 * Returns the data of the SimplePriorityQueue in an easy to read format
	 * Example: {5, 4, 3, 2, 1}
	 */
	public String toString() {
		String stringQueue = "{";
		for (int i = 0; i < dynamicLength; i++) {
			stringQueue += data[i];
			if (i != dynamicLength - 1){
				stringQueue += ", ";
			} 
		}
		stringQueue += "}";
		return stringQueue;
	}
}
