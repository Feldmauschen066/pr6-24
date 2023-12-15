package pr_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderManager {
    private final Map<String, Order> ordersByAddress;
    private final Map<Integer, Order> ordersByTable;
    private final List<Order> allOrders;

    public OrderManager() {
        ordersByAddress = new HashMap<>();
        ordersByTable = new HashMap<>();
        allOrders = new ArrayList<>();
    }

    public void addOrder(String address, Order order) throws OrderAlreadyAddedException {
        if (ordersByAddress.containsKey(address) || allOrders.contains(order)) {
            throw new OrderAlreadyAddedException("Заказ с этим адресом уже добавлен");
        }

        ordersByAddress.put(address, order);
        allOrders.add(order);

        if (order instanceof RestaurantOrder) {
            RestaurantOrder restaurantOrder = (RestaurantOrder) order;
            if (restaurantOrder.getTableNumber() != -1) {
                ordersByTable.put(restaurantOrder.getTableNumber(), order);
            }
        }
        System.out.println("Добавлен интернет-заказ по адресу: " + address);
    }

    public Order getOrder(String address) {
        return ordersByAddress.get(address);
    }

    public void removeOrder(String address) {
        Order order = ordersByAddress.get(address);
        if (order != null) {
            ordersByAddress.remove(address);
            allOrders.remove(order);
            if (order instanceof RestaurantOrder) {
                RestaurantOrder restaurantOrder = (RestaurantOrder) order;
                if (restaurantOrder.getTableNumber() != -1) {
                    ordersByTable.remove(restaurantOrder.getTableNumber());
                }
            }
        }
    }

    public void addDishToOrder(String address, Item item) throws IllegalTableNumber {
        Order order = ordersByAddress.get(address);
        if (order == null) {
            throw new IllegalTableNumber("Нет заказа с таким адресом");
        }

        if (item instanceof Dish) {
            order.addPosition(item);
        } else {
            System.err.println("Ошибка! Только блюда могут быть добавлены");
        }
    }


    public Order[] getAllOrders() {
        return allOrders.toArray(new Order[0]);
    }

    public double getTotalOrdersCost() {
        double totalCost = 0;
        for (Order order : allOrders) {
            totalCost += order.getTotalCost();
        }
        return totalCost;
    }

    public int getTotalDishesByName(String dishName) {
        int totalDishes = 0;
        for (Order order : allOrders) {
            totalDishes += order.getTotalDishes(dishName);
        }
        return totalDishes;
    }
}

