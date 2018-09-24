package prob3;

import java.util.Arrays;
import java.util.List;

public class Good {
	public int countWords(List<String> words, char c, char d, int len)
	{
		return (int) words.stream()
				.filter(x -> x.contains(""+c) && !x.contains(""+d) && x.length() == len)
				.count();
	}
	public static void main(String[] args) {
		Good g = new Good();
		List<String> words = Arrays.asList("aaa","aac","ddd","aaaa");
		System.out.println("List before count");
		System.out.println(words);
		System.out.println("How many word has character a, but no character d and the length is 3: "
				+ g.countWords(words, 'a', 'd', 3));

	}

}
