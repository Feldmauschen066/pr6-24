package pr_23;

class RestaurantOrder extends InternetOrder implements Order {
    private int tableNumber;

    public RestaurantOrder() {
        super();
        this.tableNumber = -1;
    }

    public RestaurantOrder(Item[] items, int tableNumber) {
        super(items);
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
