package l_collection;
import java.util.*;

public class Ex05_TreeSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		
		
		set.add("lion");
		set.add("zebra");
		set.add("rabbit");
		set.add("fox");
		set.add("tiger");
		set.add("bee");
		set.add("ant");
		set.add("dog");
		set.add("cat");
		set.add("cat");
		
		System.out.println(set);
		System.out.println(set.subSet("d", "t"));
		System.out.println(set.headSet("e"));
		System.out.println(set.tailSet("e"));
	}

}
