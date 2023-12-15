package pr_23;

interface Order {
    void addPosition(Item item);

    boolean removePosition(String name);

    Item[] getItems();

    double getTotalCost();

    int getTotalDishes(String name);

    String[] getUniqueItemNames();

    Item[] getSortedItemsByCost();
}
