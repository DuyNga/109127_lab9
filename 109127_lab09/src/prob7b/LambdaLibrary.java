package prob7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final TriFunction<List<Employee>, Integer, Character, String>
			GET_EMPLOYEE_BY_SALARY_NAME = (l, s, c) -> l
			.stream().filter(x -> x.salary > s)
			.filter(x -> x.lastName.charAt(0) > c)
			.map(x -> x.firstName + " " + x.lastName).sorted().collect(Collectors.joining(", "));
}
