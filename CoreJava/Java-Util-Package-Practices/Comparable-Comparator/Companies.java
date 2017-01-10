
class Companies implements Comparable<Companies>{
	private String name;
	private Integer age;
	
	public Companies(String name,Integer age){
		if(null == name || age == null)
			throw new NullPointerException();
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Companies p){
		return age.compareTo(p.age);
	}
	
	public String toString(){
		return "["+name+","+age+"]";
	}
}