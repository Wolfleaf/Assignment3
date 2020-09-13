package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<Type> implements PriorityQueue<Type>, Comparable<Type> {

	private Type[] data; // array where the data is stored

	private int actualLength; // length of the actual array

	private int dynamicLength; // length of the parts of the array we are actually using

	@SuppressWarnings("unchecked")
	public SimplePriorityQueue() {
//		make array
//		finding min and removing min should run fastest
//		minimum item will always be the item with the largest index
//		begin as empty array
//		natural ordering

		this.data = (Type[]) new Object[16];
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	// name to comparator parameter added
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue(Comparator<? super Type> Comp) {

		this.data = (Type[]) new Object[16];
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	@Override
	public Type findMin() throws NoSuchElementException {

		return this.data[dynamicLength - 1];
	}

	@Override
	public Type deleteMin() throws NoSuchElementException {

		Type deletedMin = this.findMin();
		this.data[dynamicLength - 1] = null;
		this.dynamicLength -= 1;
		return deletedMin;
	}

	@SuppressWarnings("unchecked")
	public void insert(Type item) {

		int min = 0;
		int max = dynamicLength;
		int mid = 0;
		boolean itemFound = false;

		this.dynamicLength++;

		while (!itemFound) {
			mid = (((max - min) / 2) + min);

			if (this.data[mid] == item || max <= min) { // If item equals data
				itemFound = true;
			} else if (((Comparable<Type>) item).compareTo(this.data[mid]) < 0) { // If item is smaller than data
				min = mid + 1;
			} else if (((Comparable<Type>) item).compareTo(this.data[mid]) > 0) { // If item is larger than data
				max = mid;
			}
		}

		Type[] newData = (Type[]) new Object[actualLength];

		for (int indexFirst = 0; indexFirst < mid; indexFirst++) {
			newData[indexFirst] = this.data[indexFirst];
		}
		newData[mid] = item;
		for (int indexSecond = mid; indexSecond < dynamicLength - 1; indexSecond++) {
			newData[indexSecond + 1] = this.data[indexSecond];
		}

		this.data = newData;
	}

	@Override
	public void insertAll(Collection<? extends Type> coll) {
			
		for (Type var : coll) {
			this.insert(var);
		}
	}

	@Override
	public int size() {

		return dynamicLength;
	}

	@Override
	public boolean isEmpty() {
	
		if (this.data[0] == null) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		
		Type[] newData = (Type[]) new Object[actualLength];
		this.data = newData;
		this.dynamicLength = 0;

	}

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
