package prob8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high).");
		System.out.println(transactions.stream().filter(x -> x.getYear() >= 2011)
								.sorted((x, y) -> Integer.compare(x.getValue(), y.getValue()))
								.map(x -> x.toString())
								.collect(Collectors.joining("\n")));
		System.out.println("");

        
        // Query 2: What are all the unique cities where the traders work?
        System.out.println("Query 2: What are all the unique cities where the traders work?");
        System.out.println(transactions.stream()
        					.map(x -> x.getTrader())
        					.map(x -> x.getCity())
        					.distinct()
        					.collect(Collectors.toList()));
        System.out.println("");
        // Query 3: Find all traders from Cambridge and sort them by name.
        System.out.println("Find all traders from Cambridge and sort them by name.");
        System.out.println(transactions.stream()
				.map(x -> x.getTrader())
				.filter(x -> "Cambridge".equals(x.getCity()))
				.sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
				.map(x -> x.toString())
				.collect(Collectors.joining("\n")));
        System.out.println("");
        // Query 4: Return a string of all traders names sorted alphabetically.
        System.out.println("Query 4: Return a string of all traders names sorted alphabetically.");
        System.out.println(transactions.stream()
				.map(x -> x.getTrader())
				.distinct()
				.sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
				.map(x -> x.toString())
				.collect(Collectors.joining("\n")));
        System.out.println("");
        

        // Query 5: Are there any trader based in Milan?
        System.out.println("Query 5: Are there any trader based in Milan?");
        System.out.println(transactions.stream()
				.map(x -> x.getTrader())
				.filter(x -> "Milan".equals(x.getCity()))
				.findAny()
				.isPresent()? "Yes" : "No");
        System.out.println("");
        
   
     // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
		System.out.println("Query 6: Update all transactions so that the traders from Milan are set to Cambridge.");
		System.out.println(transactions.stream()
				.map(x -> x.getTrader())
				.distinct()
				.map(x -> {
					if ("Milan".equals(x.getCity())) {
						x.setCity("Cambridge");
						return x;
					}
					return x;})
				.map(x -> x.toString())
				.collect(Collectors.joining("\n")));
		System.out.println("");
        
        
        // Query 7: What's the highest value in all the transactions?
        System.out.println("Query 7: What's the highest value in all the transactions?");
        transactions.stream()
		.map(x -> x.getValue())
		.max((x, y) -> Integer.compare(x, y))
		.ifPresent(System.out::println);
    }
}
