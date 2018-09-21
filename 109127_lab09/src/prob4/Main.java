package prob4;

import java.util.stream.IntStream;

public class Main {

	public static void printSquares(int num) {
		IntStream.iterate(1, n -> n + 1).limit(num).map(t -> t * t).forEach(System.out::println);
	}

	public static void main(String[] args) {
		printSquares(4);
	}

}
