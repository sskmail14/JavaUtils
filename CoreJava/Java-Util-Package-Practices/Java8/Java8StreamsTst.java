import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
/*
* Java 8 Streams Example
*/
class Java8StreamsTst{
	
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
		
		//Limiting Records
		System.out.println("/** Limiting Records **/");
		streamEx
		.stream()
		.sorted(PERSON_SORT_BY_NAME)
		.filter(s -> s.getAge() < 18)
		.limit(2)
		.forEach(e -> System.out.println(e));
		
		printMethodName();
	
	}
	
	private static void printMethodName(){
		//System.out.println("Current Method Name ::: "+new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println(getCurrentMethodName(0));
	}
	
	public static String getCurrentMethodName(final int depth){
		return Thread.currentThread().getStackTrace()[2+depth].getMethodName();
	}
}
