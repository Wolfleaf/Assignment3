package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {

	private SimplePriorityQueue<Integer> queueInt; // SimplePriorityQueue with concurrent Integers
	private SimplePriorityQueue<Integer> queueIntNegative; // SimplePriorityQueue with negative and positive Integers
	private SimplePriorityQueue<String> queueStringConcurrent; // SimplePriorityQueue with concurrent one letter Strings
	private SimplePriorityQueue<String> queueStringRandom; // SimplePriorityQueue with random one letter Strings
	private SimplePriorityQueue<String> queueStringWordsA; // SimplePriorityQueue with word Strings all starting with A
	private SimplePriorityQueue<String> queueStringWordsRandom; // SimplePriorityQueue with word Strings all starting
																// with random letters
	private SimplePriorityQueue<Character> queueCharacters; // SimplePriorityQueue of Characters
	private SimplePriorityQueue<Character> queueCharactersCase; // SimplePriorityQueue of Characters that are upper case
																// and lower case

	@BeforeEach
	void setUp() throws Exception {
		// Five element SimplePriorityQueue of Integers 1, 2, 3, 4, and 5
		queueInt = new SimplePriorityQueue<Integer>();
		queueInt.insert(1);
		queueInt.insert(2);
		queueInt.insert(3);
		queueInt.insert(4);
		queueInt.insert(5);

		// Five element SimplePriorityQueue of Integers -40, -20, 0, 20, and 40
		queueIntNegative = new SimplePriorityQueue<Integer>();
		queueIntNegative.insert(-40);
		queueIntNegative.insert(-20);
		queueIntNegative.insert(0);
		queueIntNegative.insert(20);
		queueIntNegative.insert(40);

		// Five element SimplePriorityQueue of Strings "A", "B", "C", "D", and "E"
		queueStringConcurrent = new SimplePriorityQueue<String>();
		queueStringConcurrent.insert("A");
		queueStringConcurrent.insert("B");
		queueStringConcurrent.insert("C");
		queueStringConcurrent.insert("D");
		queueStringConcurrent.insert("E");

		// Five element SimplePriorityQueue of Strings "A", "E", "F", "S", and "X"
		queueStringRandom = new SimplePriorityQueue<String>();
		queueStringRandom.insert("A");
		queueStringRandom.insert("E");
		queueStringRandom.insert("F");
		queueStringRandom.insert("S");
		queueStringRandom.insert("X");

		// Five element SimplePriorityQueue of Strings "Abstract", "Angry", "Anonymous",
		// "Alert", and
		// "Angled"
		queueStringWordsA = new SimplePriorityQueue<String>();
		queueStringWordsA.insert("Abstract");
		queueStringWordsA.insert("Angry");
		queueStringWordsA.insert("Anonymous");
		queueStringWordsA.insert("Alert");
		queueStringWordsA.insert("Angled");

		// Five element SimplePriorityQueue of Strings "Apple", "Frog", "Poison",
		// "Yankee", and
		// "Jeans"
		queueStringWordsRandom = new SimplePriorityQueue<String>();
		queueStringWordsRandom.insert("Apple");
		queueStringWordsRandom.insert("Frog");
		queueStringWordsRandom.insert("Poison");
		queueStringWordsRandom.insert("Yankee");
		queueStringWordsRandom.insert("Jeans");

		queueCharacters = new SimplePriorityQueue<Character>();
		queueCharacters.insert('A');
		queueCharacters.insert('B');
		queueCharacters.insert('C');
		queueCharacters.insert('D');
		queueCharacters.insert('E');

		queueCharactersCase = new SimplePriorityQueue<Character>();
		queueCharactersCase.insert('A');
		queueCharactersCase.insert('b');
		queueCharactersCase.insert('C');
		queueCharactersCase.insert('d');
		queueCharactersCase.insert('E');
	}

	@Test

	void testFindMinIntArray() {
		assertEquals(1, queueInt.findMin());
	}

	void testFindMinNegativeIntArray() {
		assertEquals(1, queueInt.findMin());

	}

	@Test
	void testFindMinStringArrayLetters() {
		assertEquals("A", queueStringConcurrent.findMin());
		assertEquals("A", queueStringRandom.findMin());
	}

	@Test
	void testFindMinStringArrayWords() {
		assertEquals("Abstract", queueStringWordsA.findMin());
		assertEquals("Apple", queueStringWordsRandom.findMin());
	}

	@Test
	void testFindMinCharacter() {
		assertEquals('A', queueCharacters.findMin());
		// since characters are compared with ASCII code, lower case letters have a
		// larger sort value than upper case letters
		assertEquals('A', queueCharactersCase.findMin());
	}

	@Test
	void testFindMinIntArrayNone() {
		SimplePriorityQueue<Integer> queueEmpty = new SimplePriorityQueue<Integer>();
		assertThrows(NoSuchElementException.class, () -> {
			queueEmpty.findMin();
		});
	}

	@Test
	void testFindMinStringArrayNone() {
		SimplePriorityQueue<String> queueEmpty = new SimplePriorityQueue<String>();
		assertThrows(NoSuchElementException.class, () -> {
			queueEmpty.findMin();
		});
	}

	@Test
	void testFindMinCharacterArrayNone() {
		SimplePriorityQueue<Character> queueEmpty = new SimplePriorityQueue<Character>();
		assertThrows(NoSuchElementException.class, () -> {
			queueEmpty.findMin();
		});
	}

	@Test
	void testDelMinIntArray() {
		queueInt.deleteMin();
		queueIntNegative.deleteMin();
		assertEquals("{5, 4, 3, 2}", queueInt.toString());
		assertEquals("{40, 20, 0, -20}", queueIntNegative.toString());

		queueInt.deleteMin();
		queueIntNegative.deleteMin();
		assertEquals("{5, 4, 3}", queueInt.toString());
		assertEquals("{40, 20, 0}", queueIntNegative.toString());
	}

	@Test
	void testDelMinStringArray() {
		queueStringConcurrent.deleteMin();
		queueStringRandom.deleteMin();
		assertEquals("{E, D, C, B}", queueStringConcurrent.toString());
		assertEquals(4, queueStringConcurrent.size());
		assertEquals("{X, S, F, E}", queueStringRandom.toString());
		assertEquals(4, queueStringRandom.size());

		queueStringConcurrent.deleteMin();
		queueStringRandom.deleteMin();
		assertEquals("{E, D, C}", queueStringConcurrent.toString());
		assertEquals(3, queueStringConcurrent.size());
		assertEquals("{X, S, F}", queueStringRandom.toString());
		assertEquals(3, queueStringRandom.size());
	}

	@Test
	void testDelMinCharacterArray() {
		queueCharacters.deleteMin();
		assertEquals("{E, D, C, B}", queueCharacters.toString());
		assertEquals(4, queueCharacters.size());

		queueCharacters.deleteMin();
		assertEquals("{E, D, C}", queueCharacters.toString());
		assertEquals(3, queueCharacters.size());
	}

	@Test
	void testDelMinEmptyArray() {
		SimplePriorityQueue<Integer> queueEmpty = new SimplePriorityQueue<Integer>();
		assertThrows(NoSuchElementException.class, () -> {
			queueEmpty.deleteMin();
		});
	}

	@Test
	void testDeleteAll() {
		queueCharacters.deleteMin();
		assertEquals(4, queueCharacters.size());
		queueCharacters.deleteMin();
		assertEquals(3, queueCharacters.size());
		queueCharacters.deleteMin();
		assertEquals(2, queueCharacters.size());
		queueCharacters.deleteMin();
		assertEquals(1, queueCharacters.size());
		queueCharacters.deleteMin();
		assertEquals(0, queueCharacters.size());
		assertTrue(queueCharacters.isEmpty());
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
		queueStringConcurrent.insert("A");
		queueStringConcurrent.insert("C");
		queueStringConcurrent.insert("Z");

		assertEquals("{Z, E, D, C, C, B, A, A}", queueStringConcurrent.toString());
	}

	@Test
	void testCharacterInsert() {
		queueCharacters.insert('A');
		queueCharacters.insert('C');
		queueCharacters.insert('Z');

		assertEquals("{Z, E, D, C, C, B, A, A}", queueCharacters.toString());
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

		queueStringConcurrent.insertAll(inserted);
		assertEquals("{Y, W, N, L, E, D, C, B, A, A}", queueStringConcurrent.toString());
	}

	@Test
	void testCharacterInsertAll() {
		ArrayList<Character> inserted = new ArrayList<Character>();
		inserted.add('A');
		inserted.add('W');
		inserted.add('N');
		inserted.add('L');
		inserted.add('Y');

		queueCharacters.insertAll(inserted);
		assertEquals("{Y, W, N, L, E, D, C, B, A, A}", queueCharacters.toString());
	}

	@Test
	void testChangeSizeInteger() {
		assertEquals(5, queueInt.size());

		ArrayList<Integer> inserted = new ArrayList<Integer>();
		inserted.add(1);
		inserted.add(2);
		inserted.add(3);
		inserted.add(4);
		inserted.add(5);
		inserted.add(6);
		inserted.add(7);
		inserted.add(8);
		inserted.add(9);
		inserted.add(10);
		inserted.add(11);
		inserted.add(12);
		inserted.add(13);
		inserted.add(14);
		inserted.add(15);
		inserted.add(16);
		queueInt.insertAll(inserted);

		assertEquals(21, queueInt.size());
		assertEquals("{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1}", queueInt.toString());
	}

	@Test
	void testChangeSizeString() {
		assertEquals(5, queueStringConcurrent.size());

		ArrayList<String> inserted = new ArrayList<String>();
		inserted.add("A");
		inserted.add("B");
		inserted.add("C");
		inserted.add("D");
		inserted.add("E");
		inserted.add("F");
		inserted.add("G");
		inserted.add("H");
		inserted.add("I");
		inserted.add("J");
		inserted.add("K");
		inserted.add("L");
		inserted.add("M");
		inserted.add("N");
		inserted.add("O");
		inserted.add("P");
		queueStringConcurrent.insertAll(inserted);

		assertEquals(21, queueStringConcurrent.size());
		assertEquals("{P, O, N, M, L, K, J, I, H, G, F, E, E, D, D, C, C, B, B, A, A}",
				queueStringConcurrent.toString());
	}

	void testChangeSizeCharacter() {
		assertEquals(5, queueCharacters.size());

		ArrayList<Character> inserted = new ArrayList<Character>();
		inserted.add('A');
		inserted.add('B');
		inserted.add('C');
		inserted.add('D');
		inserted.add('E');
		inserted.add('F');
		inserted.add('G');
		inserted.add('H');
		inserted.add('I');
		inserted.add('J');
		inserted.add('K');
		inserted.add('L');
		inserted.add('M');
		inserted.add('N');
		inserted.add('O');
		inserted.add('P');
		queueCharacters.insertAll(inserted);

		assertEquals(21, queueCharacters.size());
		assertEquals("{P, O, N, M, L, K, J, I, H, G, F, E, E, D, D, C, C, B, B, A, A}", queueCharacters.toString());
	}

	@Test
	void testIntegerSize() {
		assertEquals(5, queueInt.size());
		assertEquals(5, queueIntNegative.size());
	}

	@Test
	void testStringSize() {
		assertEquals(5, queueStringConcurrent.size());
		assertEquals(5, queueStringRandom.size());
	}

	@Test
	void testCharactersSize() {
		assertEquals(5, queueCharacters.size());
		assertEquals(5, queueCharactersCase.size());
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
	void testCharactersIsEmpty() {
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

		assertEquals(5, queueIntNegative.size());
		assertEquals("{40, 20, 0, -20, -40}", queueIntNegative.toString());
		queueIntNegative.clear();
		assertEquals(0, queueIntNegative.size());
		assertEquals("{}", queueIntNegative.toString());

		assertEquals(queueIntNegative.toString(), queueInt.toString());
	}

	@Test
	void testStringIsEmptyAfterClear() {
		assertEquals(5, queueStringConcurrent.size());
		assertEquals("{E, D, C, B, A}", queueStringConcurrent.toString());
		queueStringConcurrent.clear();
		assertEquals(0, queueStringConcurrent.size());
		assertEquals("{}", queueStringConcurrent.toString());

		Character a = 'd';
		System.out.println(a.compareTo(a));
		Character a2 = 'b';
		System.out.println(a.compareTo(a2));
		System.out.println(a2.compareTo(a));

		assertEquals(5, queueStringRandom.size());
		assertEquals("{X, S, F, E, A}", queueStringRandom.toString());
		queueStringRandom.clear();
		assertEquals(0, queueStringRandom.size());
		assertEquals("{}", queueStringRandom.toString());

		assertEquals(queueStringRandom.toString(), queueStringConcurrent.toString());
	}

	@Test
	void testCharacterIsEmptyAfterClear() {
		assertEquals(5, queueCharacters.size());
		assertEquals("{E, D, C, B, A}", queueCharacters.toString());
		queueCharacters.clear();
		assertEquals(0, queueCharacters.size());
		assertEquals("{}", queueCharacters.toString());

		assertEquals(5, queueCharactersCase.size());
		// again, since characters are compared with ASCII code, lower case letters have
		// a larger sort value than upper case letters
		assertEquals("{d, b, E, C, A}", queueCharactersCase.toString());

		queueCharactersCase.clear();
		assertEquals(0, queueCharactersCase.size());
		assertEquals("{}", queueCharactersCase.toString());

		assertEquals(queueCharacters.toString(), queueCharactersCase.toString());
	}

	@Test
	void testIntegerClear() {
		queueInt.clear();
		queueIntNegative.clear();
		assertEquals("{}", queueInt.toString());
		assertEquals("{}", queueIntNegative.toString());
		assertEquals(queueIntNegative.toString(), queueInt.toString());
	}

	@Test
	void testStringClear() {
		queueStringConcurrent.clear();
		queueStringRandom.clear();
		assertEquals("{}", queueStringConcurrent.toString());
		assertEquals("{}", queueStringRandom.toString());
		assertEquals(queueStringRandom.toString(), queueStringConcurrent.toString());
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
