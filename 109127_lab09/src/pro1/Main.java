package pro1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<String> str = Stream.of("Bill", "Thomas", "Mary");
		System.out.println(str.collect(Collectors.joining(", ")));
	}
}
