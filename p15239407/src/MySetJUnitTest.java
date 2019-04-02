import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Test;

import p15239407.MySet;

/**
 * 
 */

/**
 * @author p15238407
 *
 */
public class MySetJUnitTest {

	MySet<String> tester = new MySet<>();
	MySet<String> tester2 = new MySet<>();
	

	/**
	 * Test method for {@link p15239407.MySet#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		
		assertEquals(true, tester.isEmpty());
		tester2.add("Something");
		
		assertEquals(false, tester2.isEmpty());
		
	}


	
	/**
	 * Test method for {@link p15239407.MySet#size()}.
	 */
	@Test
	public final void testSize() {
			
		assertEquals(0, tester.size());
		tester.add("something");
		assertEquals(1, tester.size());
		tester.add("something else");
		assertEquals(2, tester.size());
	}
	


	/**
	 * Test method for {@link p15239407.MySet#toList()}.
	 */
	@Test
	public final void testToList() {
				
		tester.add("one");
		tester.add("two");
		List<String> list = new ArrayList<>();
		list = tester.toList();
		assertEquals(list.get(0), "one");
		assertEquals(list.get(1), "two");
		
	}

	/**
	 * Test method for {@link p15239407.MySet#add(java.lang.Comparable)}.
	 */
	@Test
	public final void testAdd() {
		tester.add("one");
		
		assertEquals("one", tester.toList().get(0));
		}

	/**
	 * Test method for {@link p15239407.MySet#remove(java.lang.Comparable)}.
	 */
	@Test
	public final void testRemove() {
		
		tester.add("one");
		tester.add("two");
		
		assertEquals("one", tester.toList().get(0));
		
		tester.remove("one");
		assertEquals("two", tester.toList().get(0));
		
	}

	/**
	 * Test method for {@link p15239407.MySet#contains(java.lang.Comparable)}.
	 * We should compare if set contains element or not.
	 */
	@Test
	public final void testContains() {
		
		tester.add("raz");
		tester.add("dwa");
		tester.add("trzy");
		
		assertEquals(true, tester.contains("raz"));
		
		
		
	}

	/**
	 * Test method for {@link p15239407.MySet#isSubsetOf(p15239407.Set)}.
	 */
	@Test
	public final void testIsSubsetOf() {
		tester.add("une");
		tester.add("deux");
		tester.add("tres");
		
		tester2.add("deux");
		tester2.add("tres");
		
		assertEquals(true, tester.isSubsetOf(tester2));
	}

	/**
	 * Test method for {@link p15239407.MySet#min()}.
	 */
	@Test
	public final void testMin() {
		
		assertEquals(false, tester.min().isPresent());
		
		tester.add("eins");
		tester.add("zwei");
		tester.add("drei");
		
		assertEquals("drei", tester.min().get());		
	}
	
	

	/**
	 * Test method for {@link p15239407.MySet#max()}.
	 */
	@Test
	public final void testMax() {
		
		assertEquals(false, tester.max().isPresent());
		
		tester.add("eins");
		tester.add("zwei");
		tester.add("drei");
		
		assertEquals("zwei", tester.max().get());
	}


	
	/**
	 * Test method for {@link p15239407.MySet#addSet(p15239407.Set)}.
	 */
	@Test
	public final void testAddSet() {
		
		tester.add("one");
		tester.add("two");
		tester.add("three");
		
		
		tester2.add("four");
		tester2.add("five");
		
		
		//adding sets
		tester.addSet(tester2);
		assertEquals(5, tester.size());
		

	}

	/**
	 * Test method for {@link p15239407.MySet#removeSet(p15239407.Set)}.
	 */
	@Test
	public final void testRemoveSet() {
		
		tester.add("one");
		tester.add("two");
		tester.add("three");
		tester.add("four");
		tester.add("five");
		assertEquals(5, tester.size());
		
		
		tester2.add("four").add("six");
		assertEquals(2, tester2.size());
		
		//removing set
		tester.removeSet(tester2);
		assertEquals(4, tester.size());
		
	}

	/**
	 * Test method for {@link p15239407.MySet#restrict(p15239407.Set)}.
	 */
	@Test
	public final void testRestrict() {
		tester.add("one");
		tester.add("two");
		tester.add("three");
			
		
		tester2.add("two");
		tester2.add("four");


		MySet<String> tester3 = new MySet<>();
		tester3.addSet(tester.restrict(tester2));
		assertEquals("two", tester3.toList().get(0));		
	}

	/**
	 * Test method for {@link p15239407.MySet#allTrue(java.util.function.Predicate)}.
	 */
	@Test
	public final void testAllTrue() {
		tester.add("eins").add("zwei").add("drei");
		
		assertEquals(true, tester.allTrue(s->s.contains("i")));
	}

	/**
	 * Test method for {@link p15239407.MySet#anyTrue(java.util.function.Predicate)}.
	 */
	@Test
	public final void testAnyTrue() {
		tester.add("eins").add("zwei").add("drei");
		
		assertEquals(true, tester.anyTrue(s->s.contains("d")));
	}

	/**
	 * Test method for {@link p15239407.MySet#allSubsets()}.
	 */
	@Test
	public final void testAllSubsets() {
		tester.add("1").add("2").add("3");
		
		assertEquals("[[1], [1, 2, 3], [], [2, 3], [3], [1, 2], [2], [1, 3]]", tester.allSubsets().toList().toString());
	}

}
