package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testInsert() {
		SimplePriorityQueue<Integer> blah = new SimplePriorityQueue<Integer>();
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer five = 5;
		blah.insert(one);
		blah.insert(two);
		blah.insert(three);
		blah.insert(five);
		blah.insert(6);
		blah.insert(4);
		System.out.println(blah);
		fail("Not yet implemented");
	}

}
