package p15239407;
import java.util.ArrayList;


import java.util.HashSet;

import java.util.LinkedHashSet;

//import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import java.util.function.Predicate;
;

/**
 * MySet is a set of some elements of generic type T.
 * It is been initialised to the HashSet for better performance - it will not allow duplicate elements 
 * to exist in the set and allows faster retrieving of information.
 * 
 * MySet extends Comparable interface, what allows elements to be compared
 * and implements another interface Set, what allows to override the methods.
 * 
 * Class has methods to check, if the set is empty, what is the size of the set,
 * converting set into list, adding elements to the set, removing element from the set,
 * if set contains specified element, if another set is a subset of this set,
 * what is the least and the biggest element of the set, if set is filling predicate requirements
 * (any of the elements matches or all match).
 * Also, we can add new set to this set, remove a set from this set, find common elements between this
 * set and another (do the intersection).
 * Class also shows powerset of this set.
 * @author p15238406
 *
 * @param <T> - generic type (generic class or interface parameterised over types), type of elements
 * maintained by this set
 */
public class MySet<T	extends Comparable<T>>	implements Set<T> {
	
	//field
	private HashSet<T> set;
	
	//constructor
	/**
	 * Default constructor that creates
	 * MySet as HashSet
	 */
	public MySet() {
		set = new HashSet<>();
	}
	
	



	//Basic operations
	/**
	 * Checks if set contains elements or not.
	 * Returns true if set does not contain any elements and false if they is/are any element/elements
	 * within the set
	 * @return true - set does not contain any elements or false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	/**
	 * Returns the size of the set - amount of the elements this set has.
	 * 
	 * @return size - number of elements in the set
	 */
	@Override
	public int size() {
		return set.size();
	}

	/**
	 * Returns new ArrayList containing elements of the set.
	 * Shows all elements of the set as a list and is useful for further methods.
	  @return a new ArrayList containing elements of the set
	 */
	@Override
	public List<T> toList() {
		return new ArrayList<>(set);
	}
	
	
	/**
	 * If element is unique, is being added to the set.
	 * If element appeared within the set before, it is not added.
	 * Returns set with new element, if unique or the same as before if element was the same
	 * like any other within the set.
	 * 
	 * @param x - new element to add to the set
	 * @return set - containing new element if is unique or the same as before if element was not unique
	 */
	@Override
	public Set<T>	add(T	x) {
		set.add(x);
		return this;
		
	}
	
	/**
	 * Returns set after removing one of the elements.
	 * First, x is being compared if exists in set. If does, then is removed from the set.
	 * If not, set is returned without changes.
	 * 
	 * @param x - the element to remove from the set
	 * @return set after removing specified element x if exists
	 */
	@Override
	public Set<T>	remove(T x) {
		
		set.remove(x);
		return this;
	}
	
	
	/**
	 * Checks if element is contained within the set.
	 * There is a boolean z initialised to true, but if set meets the condition,
	 * it remains true, otherwise - is set to false.
	 * 
	 * Returns true if element is contained within the set or false if not.
	 * 
	 * @param x - element to compare to the set
	 * @return true - if element is within the set or false, if 
	 * compared element is not contained within the set
	 */
	@Override
	public boolean contains(T	x) {
		boolean z = true;
		
		if (set.contains(x) == true) {
			z = true;
		} else {
			z = false;
		} return z;
		
	}
	

	/**
	 * Checks if given subset is contained in the set
	 * Returns true, if a set (that) is contained within set (this)
	 * or false, if a set (that) is not contained within set (this).
	 * Since the Set interface is not Iterable we have to convert it to a List.
	 * If even one element isn't contained in this set - it fails immediately.
	 * 
	 * @param that - a set to compare to the set (this) of generic type
	 * @return true, if a set (that) is contained within set (this)
	 * or false, if a set (that) is not contained within set (this)
	 */
	@Override
	public boolean isSubsetOf(Set<T> that) {

			for (T element : that.toList()) {
				if (!set.contains(element)) {
					return false;
				}
			}
			return true;
		
		
		
}
	
	/**
	 * Returns the smallest element value in the set or Optional.empty() if set is empty.
	 * Uses stream on the set, then is comparing using compareTo() method two elements - if any is less 
	 * than the second, then is comparing another one till as a result we will receive
	 * the smallest element from our set. If the set is empty, then as a result it returns Optional.empty()
	 * 
	 * If generic type is String, then this method compares strings and returns this, which
	 * starts with very first letter of the alphabet
	 * @return - the smallest value in the set within square brackets of Optional[smallest value] or Optional.empty() if set is empty
	 */
	@Override
	public Optional<T>	min() {
		return this.toList().stream().min((x,y) -> (x.compareTo(y)));
		//return this.toList().stream().min(Comparator.comparing((x, y) -> x));
	}
	

	/**
	 * Returns the largest value in the set or Optional.empty() if set is empty.
	 * Uses stream on the set, then is comparing using compareTo() method two elements - if any is greater 
	 * than the second, then is comparing another one till as a result we will receive
	 * the largest value from our set. If the set is empty, then as a result it returns Optional.empty()
	 * 
	 * If generic type is String, then this method compares strings and returns this, which
	 * starts with very last letter of the alphabet
	 * @return - the largest value in the set within square brackets of Optional[largest element] or Optional.empty() if set is empty	 */
	@Override
	public Optional<T>	max() {
		//this.filter().
		return this.toList().stream().max((x,y) -> (x.compareTo(y)));
	}



	/**
	 * Adds a new set to the existing one. Uses foreach loop to go through all elements of the new set (that)
	 * and add them in turn to the set(this). If any of the element of the new set (that) is the same
	 * as in the old set (this) will not be added. Our set is HashSet and does not allow
	 * duplicate elements within. Only unique to the old set (this) elements will be added to.
	 * 
	 * Returns enlarged set (this) containing unique for set (this) elements from the set (that)
	 * 
	 * @param that - new set we want to add to our set (this) of generic type
	 * @return enlarged set (this) containing unique for set (this) elements from the set (that)
	 */
	@Override
	public Set<T> addSet(Set<T> that) {
		for (T ele : that.toList()) {
			// if even one element isn't contained in this set we fail immediately
			this.add(ele);
			}
		return this;
		
	}

	/**
	 * Removes a new set (that) from the existing one (this). Uses foreach loop to go through all elements of the new set (that)
	 * and remove them if contained within set (this). If any of the element of the new set (that) is not
	 * contained in the old set (this) there will be no change for old set (this). 
	 * Only contained in the old set (this) elements from the new set (that) will be removed.
	 * 
	 * Returns reduced set (this) without common elements contained in new set (that)
	 * 
	 * @param that - new set we want to remove from our set (this) of generic type
	 * @return reduced set (this) without common elements contained in new set (that)
	 */
	@Override
	public Set<T> removeSet(Set<T> that) {
		for (T e : that.toList()) {
			this.remove(e);
		} return this;
	}

	
	/**
	 * Returns intersection of two sets - their common elements.
	 * 
	 * In order to do the intersection on two sets we need to create new Linked HashSet
	 * - this will allow us to collect elements to another set, compare them with the new set (that)
	 * and as result - return only those common for both sets.
	 * LinkedHashSet class contains only unique elements.
	 * 
	 * @param that - a set of generic type (that) we want to compare to the set (this)
	 * @return - intersection of two sets - their common elements.
	 */
	@Override
	public Set<T> restrict(Set<T> that) {
		
		
		LinkedHashSet<T> following = new LinkedHashSet<T>();
		Set<T> intersection = new MySet<T>();
		
		for (T e : this.toList()) {
			following.add(e);
			
			for (T e2 : that.toList()) {
				
				if (following.contains(e2)) {
					intersection.add(e2);
				}
			}
		} return intersection;
	}


	
	
	/**
	 * Returns true, if all the elements of the set meet the requirements of the given predicate,
	 * false otherwise
	 *
	 * @param p - given predicate on the generic type
	 * @return true if all the elements meet the requirements of the predicate or false otherwise
	 * 
	 */
	@Override
	public boolean allTrue(Predicate<T> p) {
		return set.stream().allMatch(p);
	}

	/**
	 * Returns true, if any of the elements of the set meets the requirements of the given predicate,
	 * false otherwise
	 *
	 * @param p - given predicate on the generic type
	 * @return true if any of the elements meets the requirements of the predicate or false otherwise
	 * 
	 */
	@Override
	public boolean anyTrue(Predicate<T> p) {
		return this.toList().stream().anyMatch(p);
	}







	/**
	 * Returns all the subsets of the set - so called power set of the set.
	 * To implement this method first we have to create set of sets as MySet of sets
	 * of generic type. If our original set is empty, add new MySet of generic type.
	 * 
	 * List is used to collect all elements of the original set and then separate
	 * first element. New set contains the rest of the remaining set.
	 * All its elements are collected through the for loop.
	 * 
	 * First foreach loop in method requires creating new inner set within. To this set add a head and through
	 * new inner foreach loop add to this newest set elements of the original set.
	 * 
	 * After completing iteration through second inner loop, add the newest and the original sets to the set of sets.
	 * 
	 * Return set containing all the subsets of the original set.
	 * @return set containing all the subsets of the original set.
	 */
	@Override
	public Set<Set<T>> allSubsets() {
		Set<Set<T>> sets = new MySet<Set<T>>();
		
		if (this.isEmpty()) {
	        sets.add(new MySet<T>());
	        return sets;
	    }
		
		List<T> list = new ArrayList<T>(this.toList());
		T head = list.get(0);
		Set<T> rest = new MySet<>();
		for(int i =1; i < list.size(); i++) {
			rest.add(list.get(i));
		}
		
		Set<Set<T>> subsets = rest.allSubsets();
		for(Set<T> set : subsets.toList()) {
			Set<T> newSet = new MySet<T>();
			newSet.add(head);
			for(T obj : set.toList()){
				newSet.add(obj);
			}
		
			sets.add(newSet);
			sets.add(set);
		}	
		
		
		return sets;
		}
	
	/**
	 * Returns textual representation
	 * @return textual representation
	 */
	@Override
	public String toString() {
		return set.toString();
	}
	
	
}
	


	





