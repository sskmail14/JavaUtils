/*
* Class that demonstrates the exmple for comparable and comparator
*
*/
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class ComparableComparatorPractice{
	
	private static final Comparator<Person> PERSON_SORT_BY_NAME = new Comparator<Person>(){
		public int compare(Person p1,Person p2){
			return p1.getName().compareTo(p2.getName());
		}
	};
	
	private static final Comparator<Person> PERSON_SORT_BY_AGE = new Comparator<Person>(){
		public int compare(Person p1,Person p2){
			return p1.getAge().compareTo(p2.getAge());
		}
	};
	
	public static void main(String[] args){
		// String - Default implements Comparable interface
		System.out.println("Comparable and Comparator Implementation");
		System.out.println("/*String - Default implements Comparable interface*/");
		List<String> str = new ArrayList<String>();
		str.add("Validation");
		str.add("Animation");
		str.add("Art");
		str.add("Stunt");
		str.add("Horizontal");
		System.out.println("Actual List: ");
		System.out.println(str);
		Collections.sort(str);
		System.out.println("List after sorting: ");
		System.out.println(str);
		System.out.println("");
		
		//Companies - Custom implementation using Comparable interface
		System.out.println("/*Companies - Custom implementation using Comparable interface*/");
		List<Companies> c = new ArrayList<Companies>();
		c.add(new Companies("Changepond",16));
		c.add(new Companies("Franklin",78));
		c.add(new Companies("Amazon",50));
		c.add(new Companies("Flipkart",40));
		System.out.println("Actual List: ");
		System.out.println(c);
		Collections.sort(c);
		System.out.println("List after sorting: ");
		System.out.println(c);
		System.out.println("");
		
		/*Person - Custom implementation of Comparator class
		* 1.PERSONSORT_BY_NAME - Sorts by Name
		* 2.PERSON_SORT_BY_AGE - Sorts by Age
		*/
		System.out.println("/*Person - Custom implementation of Comparator class\n*1.PERSONSORT_BY_NAME - Sorts by Name\n* 2.PERSON_SORT_BY_AGE - Sorts by Age	*/");
		List<Person> p = new ArrayList<Person>();
		p.add(new Person("Ramu",12));
		p.add(new Person("Agil",52));
		p.add(new Person("Murali",19));
		p.add(new Person("Kalai",45));
		p.add(new Person("George",78));
		System.out.println("Actual List: ");
		System.out.println(p);
		Collections.sort(p);
		System.out.println("List after sorting by name(default - class level implementation): ");
		System.out.println(p);
		Collections.sort(p,PERSON_SORT_BY_NAME);
		System.out.println("List after sorting by name(enforced): ");
		System.out.println(p);
		Collections.sort(p,PERSON_SORT_BY_AGE);
		System.out.println("List after sorting by age: ");
		System.out.println(p);
		
	}
}


