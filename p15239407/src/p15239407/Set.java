package p15239407;

import java.util.List;

import java.util.Optional;
import java.util.function.Predicate;


public interface Set<T	extends Comparable<T>>
extends Comparable<Set<T>>	{
	
	
	//	Basic	operations
	public boolean isEmpty();
	public int size();
	public List<T>	toList();
	public Set<T>	add(T	x);
	public Set<T>	remove(T	x);
	public boolean contains(T	x);
	public boolean isSubsetOf(Set<T>	that);
	public Optional<T>	min();
	public Optional<T>	max();
	
	
	//	Intermediate	operations
	public Set<T>	addSet(Set<T>	that);
	public Set<T>	removeSet(Set<T>	that);
	public Set<T>	restrict(Set<T>	that);
	public boolean allTrue(Predicate<T>	p);
	public boolean anyTrue(Predicate<T>	p);
	
	
	//Advanced	operation
	public Set<Set<T>>	allSubsets();
	public default boolean isEqualTo(Set<T>	that)	{
		return this.isSubsetOf(that)	&&	that.isSubsetOf(this);
	}
	public default int compareTo(Set<T>	that)	{
		boolean sub1 =	this.isSubsetOf(that);
		boolean sub2 =	that.isSubsetOf(this);
		if (sub1 &&	sub2)
			return 0;
		else if (sub1)
			return -1;
		else
			return 1;
	}
}