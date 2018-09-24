package prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import prob7b.TriFunction;

//Even more functional approach -- count number of elements 
//using a pure expression -- no auxiliary function calls
//All assignments are atomic.
public class Better {
	final TriFunction<CharSequence, CharSequence, Integer, Predicate<String>> containsLetter 
			= (first, second, len) -> name -> name.contains(first) 
			&& !name.contains(second) && name.length() == len;
	
	public int countWords(List<String> words, char c, char d, int len)
	{
		return (int) words.stream()
				.filter(containsLetter.apply(String.valueOf(c), String.valueOf(d), len))
				.count();
	}
	public static void main(String[] args) {
		Better b = new Better();
		List<String> words = Arrays.asList("aaa","aac","ddd","aaaa");
		System.out.println("List before count");
		System.out.println(words);
		System.out.println("How many word has character a, but no character d and the length is 3: "
				+ b.countWords(words, 'a', 'd', 3));
	}
}
