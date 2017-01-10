
class Person implements Comparable<Person>{
	private String name;
	private Integer age;
	
	public Person(String name,Integer age){
		if(null == name || null == age)
			throw new NullPointerException();
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public Integer getAge(){
		return age;
	}
	
	public String toString(){
		return "["+name+","+age+"]";
	}
	
	public int compareTo(Person p){
		return name.compareTo(p.name);
	}
}