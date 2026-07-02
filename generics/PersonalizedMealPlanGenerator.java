import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    int getCalories();
    String getPlanName();
}

class VegetarianMeal implements MealPlan {
    private int calories;

    public VegetarianMeal(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be positive");
        }
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanName() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    private int calories;

    public VeganMeal(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be positive");
        }
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanName() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    private int calories;

    public KetoMeal(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be positive");
        }
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanName() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    private int calories;

    public HighProteinMeal(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be positive");
        }
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanName() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    private String userName;
    private T mealPlan;

    public Meal(String userName, T mealPlan) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name must not be empty");
        }
        if (mealPlan == null) {
            throw new IllegalArgumentException("Meal plan must not be null");
        }
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public String getUserName() {
        return userName;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String toString() {
        return userName + " -> " + mealPlan.getPlanName() + " (" + mealPlan.getCalories() + " kcal)";
    }
}

public class PersonalizedMealPlanGenerator {

    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan, int maxAllowedCalories) {
        if (mealPlan == null) {
            throw new IllegalArgumentException("Meal plan must not be null");
        }
        if (maxAllowedCalories <= 0) {
            throw new IllegalArgumentException("Max allowed calories must be positive");
        }
        return mealPlan.getCalories() <= maxAllowedCalories;
    }

    public static <T extends MealPlan> Meal<T> generateMealPlan(String userName, T mealPlan, int maxAllowedCalories) {
        if (!validateMealPlan(mealPlan, maxAllowedCalories)) {
            throw new IllegalStateException("Meal plan exceeds maximum allowed calories");
        }
        return new Meal<T>(userName, mealPlan);
    }

    public static void main(String[] args) {
        List<Meal<?>> meals = new ArrayList<Meal<?>>();

        Meal<VegetarianMeal> vegMeal = generateMealPlan("Aditya", new VegetarianMeal(1800), 2000);
        Meal<VeganMeal> veganMeal = generateMealPlan("Simran", new VeganMeal(1600), 2000);
        Meal<KetoMeal> ketoMeal = generateMealPlan("Rohit", new KetoMeal(1900), 2000);
        Meal<HighProteinMeal> proteinMeal = generateMealPlan("Manav", new HighProteinMeal(2200), 2500);

        meals.add(vegMeal);
        meals.add(veganMeal);
        meals.add(ketoMeal);
        meals.add(proteinMeal);

        System.out.println("Generated Meal Plans:");
        for (Meal<?> meal : meals) {
            System.out.println(meal);
        }

        try {
            generateMealPlan("Zara", new KetoMeal(3000), 2000);
        } catch (IllegalStateException exception) {
            System.out.println("Validation failed: " + exception.getMessage());
        }
    }
}
