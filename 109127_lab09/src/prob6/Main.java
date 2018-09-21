package prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.omg.CORBA.UnionMember;

public class Main {

	public static Set<String> union(List<Set<String>> sets) {
		return sets.stream().reduce((x, y) -> {
//			x.addAll(y);
			y.stream().forEach(t -> {
				x.add(t);
//				System.out.println(x.stream().collect(Collectors.toList()));
			});
			return x;
		}).get();
	}

	public static void main(String[] args) {
		List<Set<String>> sets = new ArrayList<>();
		sets.add(new HashSet<>(Arrays.asList("A", "B")));
		sets.add(new HashSet<>(Arrays.asList("D")));
		sets.add(new HashSet<>(Arrays.asList("E", "R", "T")));
//		sets.add(new HashSet<>(Arrays.asList("1", "3", "5")));
		System.out.println(union(sets).stream().collect(Collectors.toList()));
	}

}
