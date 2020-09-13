package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {

	@Test
	void testIntegerInsert() {

		SimplePriorityQueue<Integer> testQueue = new SimplePriorityQueue<Integer>();

		testQueue.insert(1);
		testQueue.insert(2);
		testQueue.insert(3);
		testQueue.insert(100);
		testQueue.insert(4);
		testQueue.insert(-100);

		assertEquals("{100, 4, 3, 2, 1, -100}", testQueue.toString());
	}
	
	@Test
	void testStringInsert() {

		SimplePriorityQueue<String> testQueue = new SimplePriorityQueue<String>();

		testQueue.insert("A");
		testQueue.insert("C");
		testQueue.insert("B");
		testQueue.insert("C");
		testQueue.insert("W");
		testQueue.insert("D");
		testQueue.insert("A");

		assertEquals("{W, D, C, C, B, A, A}", testQueue.toString());
	}

}
