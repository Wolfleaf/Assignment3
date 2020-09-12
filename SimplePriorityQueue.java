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
		// Check if enough space, if not double it
		// Search for correct location to insert
		// Move other objects to different locations
		// Add item
		this.dynamicLength++;
		if (this.actualLength == this.dynamicLength) {
			Type[] newData = (Type[]) new Object[actualLength * 2];
			for (int i = 0; i < actualLength; i++) {
				newData[i] = this.data[i];
			}
			this.actualLength *= 2;
		}

		int min = 0;
		int max = dynamicLength - 1;
		int mid = 0;
		int count = 0;
		boolean itemFound = false;

		//maybe unneeded
		if (((Comparable<Type>) this.data[mid]) == null) {
			this.data[0] = item;
			return;
		}

		while (!itemFound && (count != (dynamicLength - 1))) {
			if (max < min) {
				mid = max;
				break;
			}
			mid = ((max - min) / 2) + min;
			System.out.println(this.data[mid] + " this.data[mid]");
			System.out.println(this.data[0] + " this.data[0]");
			System.out.println(this.data[1] + " this.data[1]");
			if (((Comparable<Type>) this.data[mid]).compareTo(item) > 0) {
				max = mid + 1;
			} else if (((Comparable<Type>) this.data[mid]).compareTo(item) < 0) {
				min = mid + 1;
			} else {
				itemFound = true;
			}
			count++;
		}

		for (int i = dynamicLength; i > mid; i--) {
			this.data[dynamicLength] = this.data[dynamicLength - 1];
		}
		this.data[mid] = item;
	}

	@Override
	public void insertAll(Collection<? extends Type> coll) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Type item) {

		return this.compareTo(item);
	}
}
