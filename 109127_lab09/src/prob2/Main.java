package prob2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1, 2, 3, -6, -7);
		Supplier<Stream<Integer>> sup = () -> l.stream();
		System.out.println("List: " + l);
		Integer min = sup.get().min((x, y) -> Integer.compare(x, y)).get();
		System.out.println("Min Value: " + min);
		Integer max = sup.get().max((x, y) -> Integer.compare(x, y)).get();
		System.out.println("Max Value: " + max);
	}
}
