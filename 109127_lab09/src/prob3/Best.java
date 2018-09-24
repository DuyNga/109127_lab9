package prob3;

import java.util.Arrays;
import java.util.List;

public class Best {
	public static final MyFunctionInterface<List<String>, CharSequence, CharSequence, Integer> containsLetter 
	= (list, first, second, len) -> (int) list.stream().filter( name -> name.contains(first) 
	&& !name.contains(second) && name.length() == len).count();

public static void main(String[] args) {
List<String> words = Arrays.asList("aaa","aac","ddd","aaaa");
System.out.println("List before count");
System.out.println(words);
System.out.println("How many word has character a, but no character d and the length is 3: "
		+ Best.containsLetter.apply(words, "a", "d", 3));
}
}
