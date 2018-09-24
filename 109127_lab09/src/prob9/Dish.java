package prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));
//    a. Is there any Vegetarian meal available ( return type boolean)
	public static boolean findVegetarianMeal() {
		return menu.stream().anyMatch(x -> x.isVegetarian());
	}
//    b. Is there any healthy menu have calories less than 1000 ( return type boolean)
	public static boolean findLessThan1000() {
		return menu.stream().anyMatch(x -> x.getCalories() < 1000);
	}
//    c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
	public static boolean findMoreThan1000() {
		return menu.stream().anyMatch(x -> x.getCalories() >= 1000);
	}
//    d. find and return the first item for the type of MEAT( return type Optional<Dish>)
	public static Optional<Dish> findMeatMeal() {
		return menu.stream().filter(x -> x.getType() == Dish.Type.MEAT).findFirst();
	}
//    e. calculateTotalCalories() in the menu using reduce. (return int)
	public static int calculateTotalCalories() {
		return menu.stream().map(x -> x.getCalories())
				.reduce((x, y) -> x+y).get();
	}
//    f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
	public static int calculateTotalCaloriesMethodReference() {
		return menu.stream().map(Dish::getCalories)
				.reduce(Integer::sum).get();
	}
//    e. Implement a main method to test.
	
	public static void main(String[] args) {

	    System.out.println("a. Is there any Vegetarian meal available ( return type boolean): "
	    + findVegetarianMeal());
		System.out.println("b. Is there any healthy menu have calories less than 1000 ( return type boolean): "
				+ findLessThan1000());
		System.out.println("c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean): "
				+ findMoreThan1000());
		System.out.println("d. find and return the first item for the type of MEAT( return type Optional<Dish>): "
				+ findMeatMeal().get());
		System.out.println("e. calculateTotalCalories() in the menu using reduce. (return int): "
				+ calculateTotalCalories());
		System.out
				.println("f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int): "
						+ calculateTotalCaloriesMethodReference());
	}
}