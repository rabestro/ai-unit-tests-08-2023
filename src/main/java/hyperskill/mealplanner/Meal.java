package hyperskill.mealplanner;

import static java.util.Objects.requireNonNull;

public final class Meal {
    private final String category;
    private final String name;
    private final String[] ingredients;

    public Meal(String category, String name, String[] ingredients) {
        this.category = requireNonNull(category);
        this.name = requireNonNull(name);
        this.ingredients = requireNonNull(ingredients);
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}
