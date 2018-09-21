package prob5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
		if (m < 0 || n < 0 || n < m)
			return Stream.empty();
		return stream.skip(m).limit(n);
	}

	public static void main(String[] args) {
		// Make three calls for the streamSection() method with different inputs
		// use nextStream() method to supply the Stream input as a first argument in
		// streamSection() method
		System.out.println("Before call streamSection function");
		System.out.println(nextStream().collect(Collectors.toList()));
		System.out.println("Call streamSection function with m = 0, n = 3");
		System.out.println(streamSection(nextStream(), 0, 3).collect(Collectors.toList()));
		System.out.println("Call streamSection function with m = 1, n = 3");
		System.out.println(streamSection(nextStream(), 1, 3).collect(Collectors.toList()));
		System.out.println("Call streamSection function with m = 8, n = 10");
		System.out.println(streamSection(nextStream(), 8, 10).collect(Collectors.toList()));
		System.out.println("Call streamSection function with m = 14, n = 16");
		System.out.println(streamSection(nextStream(), 14, 16).collect(Collectors.toList()));
	}

	// support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
	}
}
