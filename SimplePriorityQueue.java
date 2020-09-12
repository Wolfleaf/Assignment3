package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<Type> implements PriorityQueue<Type> {

	private static Object[] array;
	
	private static int actualLength;
	
	private static int dynamicLength;
	
	
	
	
	public SimplePriorityQueue() {
//		make array
//		finding min and removing min should run fastest
//		minimum item will always be the item with the largest index
//		begin as empty array
//		natural ordering
		
//		@SuppressWarnings("unchecked")
		Type[] SParray = (Type[]) new Object[16];
		this.array = SParray;
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	//name to comparator parameter added
	public SimplePriorityQueue(Comparator<? super Type> Comp) {
		@SuppressWarnings("unchecked")
		Type[] SParray = (Type[]) new Object[16];
		this.array = SParray;
		this.actualLength = 16;
		this.dynamicLength = 0;
	}

	@Override
	public Type findMin() throws NoSuchElementException {
		// TODO Auto-generated method stub 

		return (Type) this.array[dynamicLength];
	}

	@Override
	public Type deleteMin() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Type item) {
		// TODO Auto-generated method stub
		//binary search - sorted list - check to double array size

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
}
