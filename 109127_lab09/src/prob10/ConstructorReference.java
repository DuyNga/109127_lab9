package prob10;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import prob7b.TriFunction;

class Human
{
	String name;
	int age;
	String gender;
	
	public Human(String name){
		this.name = name;
	}
	public Human(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Human(String name,int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

public class ConstructorReference {
public static void main(String args[]){
	Human[] list = { new Human("Joe",35,"feMale"), new Human("Jane",45,"Female"), new Human("John",30,"Male")};
	
    // Query 1  : Print only Female canditates names
	System.out.println("Query 1  : Print only Female canditates names");
	System.out.println(Stream.of(list).filter(x -> "Female".equalsIgnoreCase(x.getGender()))
			.map(x -> x.getName())
			.collect(Collectors.toList()));
	System.out.println("");

    // Query 2 : Cretae an objecy by choosing suitable Interface to the specified constructors
	//(Totally 3 constuctors)using fouth type of Method Reference ClassName::new. 
	//Then print the object status 
	System.out.println("Query 2: Using fouth type of Method Reference ClassName::new.");
	Function<String, Human> f1 = Human::new;
	BiFunction<String, Integer, Human> f2 = Human::new;
	TriFunction<String, Integer, String, Human> f3 = Human::new;
	System.out.println("Constructor 1: " + f1.apply("Alex"));
	System.out.println("Constructor 2: " + f2.apply("Alex", 30));
	System.out.println("Constructor 3: " + f3.apply("Alex", 30, "Male"));
	System.out.println("");
 
	// Query 3 : Count the male candidates whose age is more than 30
	System.out.println("Query 3 : Count the male candidates whose age is more than 30: " +
			Stream.of(list)
	.filter(x -> "Male".equalsIgnoreCase(x.getGender()) && x.getAge() > 30).count());
   }
}
