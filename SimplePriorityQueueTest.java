package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {
	
	private SimplePriorityQueue<Integer> queueInt;  // library that uses names to identify patrons (holders)
	private SimplePriorityQueue<Integer> queueInt2;  // library that uses names to identify patrons (holders)
	private SimplePriorityQueue<String> queueString;  // library that uses names to identify patrons (holders)
	private SimplePriorityQueue<String> queueString2;  // library that uses names to identify patrons (holders)
	
	@BeforeEach
	void setUp() throws Exception {
		queueInt = new SimplePriorityQueue<Integer>();
		queueInt.insert(1);
		queueInt.insert(2);
		queueInt.insert(3);
		queueInt.insert(4);
		queueInt.insert(5);
		
		queueInt2 = new SimplePriorityQueue<Integer>();
		queueInt2.insert(-40);
		queueInt2.insert(-20);
		queueInt2.insert(0);
		queueInt2.insert(20);
		queueInt2.insert(40);

		queueString = new SimplePriorityQueue<String>();
		queueString.insert("A");
		queueString.insert("B");
		queueString.insert("C");
		queueString.insert("D");
		queueString.insert("E");
		
		queueString2 = new SimplePriorityQueue<String>();
		queueString2.insert("A");
		queueString2.insert("E");
		queueString2.insert("F");
		queueString2.insert("S");
		queueString2.insert("X");
	}
	
	@Test
	void testFindMinIntArray() {
		assertEquals(1, queueInt.findMin());
		assertEquals(-40, queueInt2.findMin());
	}
	
	@Test
	void testFindMinStringArray() {
		assertEquals("A", queueString.findMin());
		assertEquals("A", queueString2.findMin());
	}
	
	@Test
	void testDelMinIntArray() {
		queueInt.deleteMin();
		queueInt2.deleteMin();
		assertEquals("{5, 4, 3, 2}", queueInt.toString());
		assertEquals("{40, 20, 0, -20}", queueInt2.toString());
		
		queueInt.deleteMin();
		queueInt2.deleteMin();
		assertEquals("{5, 4, 3}", queueInt.toString());
		assertEquals("{40, 20, 0}", queueInt2.toString());
	}
	
	@Test
	void testDelMinStringArray() {
		queueString.deleteMin();
		queueString2.deleteMin();
		assertEquals("{E, D, C, B}", queueString.toString());
		assertEquals("{X, S, F, E}", queueString2.toString());
		
		queueString.deleteMin();
		queueString2.deleteMin();
		assertEquals("{E, D, C}", queueString.toString());
		assertEquals("{X, S, F}", queueString2.toString());
	}
	
	@Test
	void testIntegerInsert() {
		queueInt.insert(100);
		queueInt.insert(-100);
		queueInt.insert(1);
		assertEquals("{100, 5, 4, 3, 2, 1, 1, -100}", queueInt.toString());
	}
	
	@Test
	void testStringInsert() {
		queueString.insert("A");
		queueString.insert("C");
		queueString.insert("Z");

		assertEquals("{Z, E, D, C, C, B, A, A}", queueString.toString());
	}
	
	@Test
	void testIntegerInsertAll() {
		ArrayList<Integer> inserted = new ArrayList<Integer>();
		inserted.add(4);
		inserted.add(5);
		inserted.add(6);
		inserted.add(7);
		inserted.add(0);
		
		queueInt.insertAll(inserted);
		assertEquals("{7, 6, 5, 5, 4, 4, 3, 2, 1, 0}", queueInt.toString());
	}
	
	@Test
	void testStringInsertAll() {
		ArrayList<String> inserted = new ArrayList<String>();
		inserted.add("A");
		inserted.add("W");
		inserted.add("N");
		inserted.add("L");
		inserted.add("Y");
		
		queueString.insertAll(inserted);
		assertEquals("{Y, W, N, L, E, D, C, B, A, A}", queueString.toString());
	}
	
	@Test
	void testIntegerSize() {
		assertEquals(5, queueInt.size());
		assertEquals(5, queueInt2.size());
	}
	
	@Test
	void testStringSize() {
		assertEquals(5, queueString.size());
		assertEquals(5, queueString2.size());
	}
	
	@Test
	void testIntegerIsEmpty() {
		SimplePriorityQueue<Integer> queueEmpty = new SimplePriorityQueue<Integer>();
		assertEquals(0, queueEmpty.size());
		assertEquals("{}", queueEmpty.toString());
	}
	
	
	@Test
	void testStringIsEmpty() {
		SimplePriorityQueue<String> queueEmpty = new SimplePriorityQueue<String>();
		assertEquals(0, queueEmpty.size());
		assertEquals("{}", queueEmpty.toString());
	}
	
	@Test
	void testIntegerIsEmptyAfterClear() {
		assertEquals(5, queueInt.size());
		assertEquals("{5, 4, 3, 2, 1}", queueInt.toString());
		queueInt.clear();
		assertEquals(0, queueInt.size());
		assertEquals("{}", queueInt.toString());
		
		assertEquals(5, queueInt2.size());
		assertEquals("{40, 20, 0, -20, -40}", queueInt2.toString());
		queueInt2.clear();
		assertEquals(0, queueInt2.size());
		assertEquals("{}", queueInt2.toString());
		
		assertEquals(queueInt2.toString(), queueInt.toString());
	}
	
	@Test
	void testStringIsEmptyAfterClear() {
		assertEquals(5, queueString.size());
		assertEquals("{E, D, C, B, A}", queueString.toString());
		queueString.clear();
		assertEquals(0, queueString.size());
		assertEquals("{}", queueString.toString());
		
		assertEquals(5, queueString2.size());
		assertEquals("{X, S, F, E, A}", queueString2.toString());
		queueString2.clear();
		assertEquals(0, queueString2.size());
		assertEquals("{}", queueString2.toString());
		
		assertEquals(queueString2.toString(), queueString.toString());
	}
	
	@Test
	void testIntegerClear() {
		queueInt.clear();
		queueInt2.clear();
		assertEquals("{}", queueInt.toString());
		assertEquals("{}", queueInt2.toString());
		assertEquals(queueInt2.toString(), queueInt.toString());
	}
	
	@Test
	void testStringClear() {
		queueString.clear();
		queueString2.clear();
		assertEquals("{}", queueString.toString());
		assertEquals("{}", queueString2.toString());
		assertEquals(queueString2.toString(), queueString.toString());
	}
	
	@Test
	void testToStringNoItems() {
		SimplePriorityQueue<Integer> testQueue = new SimplePriorityQueue<Integer>();

		assertEquals("{}", testQueue.toString());
	}
	
	@Test
	void testToStringOneItem() {
		SimplePriorityQueue<Integer> testQueue = new SimplePriorityQueue<Integer>();

		testQueue.insert(1);
		
		assertEquals("{1}", testQueue.toString());
	}
	
	@Test
	void testToStringTwoItems() {
		SimplePriorityQueue<Integer> testQueue = new SimplePriorityQueue<Integer>();

		testQueue.insert(1);
		testQueue.insert(2);
		
		assertEquals("{2, 1}", testQueue.toString());
	}

}
