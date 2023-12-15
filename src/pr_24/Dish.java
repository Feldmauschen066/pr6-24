package pr_23;

record Dish(double cost, String name, String description) implements Item {
    Dish {
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Неправильные параметры");
        }
    }
}
