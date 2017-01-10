/*
* Class that demonstrates the exmple for comparable and comparator
*
*/
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Optional;
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
	
	public static void main(String[] bala){
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
		
		// Java 8 stream Implementation sorting and filtering
		System.out.println("/***Java 8 stream Implementation sorting and filtering ***/");
		System.out.println("/*Stream Implementation sorting and filtering to List*/");
		List<Person> streamEx = new ArrayList<Person>();
		streamEx.add(new Person("Ramu",12));
		streamEx.add(new Person("Agil",52));
		streamEx.add(new Person("Murali",17));
		streamEx.add(new Person("Hari",17));
		streamEx.add(new Person("Kalai",45));
		streamEx.add(new Person("George",78));
		List<String> sortedNames = streamEx
		.stream().filter(s -> s.getAge() > 18)
		//.sorted(PERSON_SORT_BY_NAME) // Soreted using Comparator instance already created
		.sorted((p1,p2)->p1.getAge().compareTo(p2.getAge())) // Defining the Comparator here itself
		.map(Person::getName)
		.collect(Collectors.toList());
		System.out.println(sortedNames);
		
		// Retriving the first person of the criteria being met
		Optional<Person> firstPerson = streamEx
										.stream()
										//.sorted(PERSON_SORT_BY_AGE.reversed()) // Reverse sorting
										.sorted(PERSON_SORT_BY_AGE)
										.findFirst();
		System.out.println("Person with Minimum Age :: "+firstPerson.get());
		
		//Mutiple Sorting conditions
		System.out.println("/*\n*Mutiple Sorting conditions \n*1.Age\n*2.Name\n*/");
		streamEx
		.stream()
		.sorted(PERSON_SORT_BY_AGE.thenComparing(PERSON_SORT_BY_NAME))
		.forEach(e -> System.out.println(e));
		
		System.out.println("/*Stream Implementation sorting and filtering to Map*/");
		Map<String,Integer> sortedMap = streamEx
		.stream()
		.collect(Collectors.toMap(Person::getName,Person::getAge));
		System.out.println(sortedMap);
		
	}
}


