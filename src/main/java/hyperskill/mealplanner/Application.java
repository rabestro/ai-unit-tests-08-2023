package hyperskill.mealplanner;

import java.util.List;

import static java.lang.System.out;

public final class Application implements Runnable {
    private final Ui ui;
    private final List<Meal> meals;

    public Application(Ui ui) {
        this.ui = ui;
        this.meals = new java.util.ArrayList<>();
    }

    @Override
    public void run() {
        for (; ; ) {
            out.println("What would you like to do (add, show, exit)?");
            var command = ui.get();
            if ("exit".equals(command)) {
                ui.accept("Bye!");
                break;
            }
            if ("add".equals(command)) {
                addMeal();
            }
            if ("show".equals(command)) {
                showMeals();
            }
        }
    }

    private void showMeals() {
        if (meals.isEmpty()) {
            ui.accept("No meals saved. Add a meal first.");
            return;
        }
        meals.forEach(this::print);
    }

    private void addMeal() {
        var category = ui.prompt("Which meal do you want to add (breakfast, lunch, dinner)?", Constraint.category());
        var name = ui.prompt("Input the meal's name:", Constraint.name());
        var ingredients = ui.prompt("Input the ingredients:", Constraint.ingredients()).split(", ?");
        meals.add(new Meal(category, name, ingredients));
        ui.accept("The meal has been added!");
    }

    private void print(Meal meal) {
        ui.accept("Category: " + meal.getCategory());
        ui.accept("Name: " + meal.getName());
        ui.accept("Ingredients: \n" + String.join("\n", meal.getIngredients()));
        ui.accept("");
    }
}
