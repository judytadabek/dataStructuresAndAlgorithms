package p15239407;

import java.util.TreeSet;
import java.util.function.Predicate;

public class MySetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySet<String> set1 = new MySet<>();
		
		//set1.add("huhuhu");
		//System.out.println(set1.toList());
		
		
		//check the first method isEmpty
		System.out.println(set1);
		System.out.println("Is the set empty? " + set1.isEmpty());
		
		//check the size of the set
		System.out.println(set1.size());
		
		//check toList method
		System.out.println(set1.toList());
		
		//check if we can add any element
		set1.add("hey");
		System.out.println(set1);
		System.out.println(set1.toList());
		//check if you can add the same element twice?
		set1.add("hey");
		System.out.println(set1.toList());
		set1.add("hello");
		System.out.println(set1.toList());
		
		//check if we can remove some elements
		set1.remove("hey");
		System.out.println(set1.toList());
		
		//check if our set contains a string
		set1.add("Judyta");
		set1.add("Marcin");
		set1.add("Adas");
		System.out.println(set1.toList());
		System.out.println("Does the set contain Judyta ? " + set1.contains("Judyta"));
		
		
		//checking if are subsets
		set1.add("Adrian");
		set1.add("Barbara");
		MySet<String> subset = new MySet<>();
		subset.add("Barbara");
		//subset.add("Marcin");
		System.out.println("Set1 " + set1.toList());
		System.out.println(subset.toList());
		System.out.println("Does the set contain the subset? " + subset.isSubsetOf(set1));
		System.out.println("Does the set contain the subset? " + set1.isSubsetOf(subset));
		//System.out.println("Set contains all the elements of the subset? " + subset.containsAll(set1));
		
		
		
		System.out.println("=====================MIN STRING IN OUR SET? ====================");
		System.out.println("Min in set1 : " + set1.min());
		System.out.println("Min in subset: " + subset.min());
		MySet<String> empty = new MySet<>();
		System.out.println("Min in empty set? " + empty.min());
		System.out.println("\n \n");
		MySet<String> ojtam = new MySet<>();
		ojtam.add("Banan");
		System.out.println("Min in ojtam set? " + ojtam);
		
		System.out.println("=====================MAX STRING IN OUR SET? ====================");
		System.out.println("Max in set1 : " + set1.max());
		System.out.println("Max in subset: " + subset.max());
		
		System.out.println("Max in empty set? " + empty.max());
		System.out.println("\n \n");
		
		System.out.println("=====================MAX & MIN on INT values? ====================");
		MySet<Integer> int1 = new MySet<>();
		int1.add(5);
		int1.add(10);
		int1.add(17);
		
		System.out.println("Min in int1 set? " + int1.min());
		System.out.println("Max in int1 set? " + int1.max());
		
		System.out.println("=====================COMPARING  ====================");
		
		MySet<String> new1 = new MySet<>();
		new1.add("Judyta");
		
		MySet<String> new2 = new MySet<>();
		new2.add("Judyta");
		
		MySet <String> new3 = new MySet<>();
		new3.add("Adrian");
		
		System.out.println(new1.compareTo(new2));
		System.out.println(new1.compareTo(new3));
		
		System.out.println("=====================ADDING ELEMENTS ====================");
		
		System.out.println("Lets add sets set1 and int1 ");
		System.out.println(set1.toList());
		System.out.println(subset.toList());
		set1.addSet(subset);
		MySet<String> set2 = new MySet<>();
		set2.add("Karolina");
		set2.add("Justyna");
		set2.add("Filip");
		System.out.println(set2.toList());
		set1.addSet(set2);
		System.out.println(set1.toList());
		
		System.out.println("=====================REMOVING ELEMENTS ====================");
		System.out.println("Actual set: " + set1.toList());
		set1.removeSet(set2);
		System.out.println("Set after remowing a set" + set1.toList());
		
		
		System.out.println("=======================INTERSECTION =========================");
		MySet<String> set3 = new MySet<>();
		set3.add("Barbara");
		set3.add("Judyta");
		set3.add("Marcin");
		set3.add("Karola");
		System.out.println("Elements of the set3 : " + set3.toList());
		System.out.println("Let's do the intersection! ");
		System.out.println("Print all common elements : " + set1.restrict(set3).toList());
		
		System.out.println("=======================ALL TRUE === =========================");
		//let's build the predicate
		
		//System.out.println("Are all the instances of the same type? " + set3.allTrue(p));
		
		System.out.println("=======================ALL TRUE === =========================");
		MySet<String> tester = new MySet<String>();
		System.out.println("Tester is empty, shows as list: " + tester.toList());
		
		
		System.out.println("=======================POWER SET === =========================");
		MySet<String> jakis = new MySet<>();
		jakis.add("1").add("2").add("3");
		
		System.out.println(jakis.toList());
		System.out.println(jakis.allSubsets().toList().toString());
	}

}
