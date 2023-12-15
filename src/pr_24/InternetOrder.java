package pr_23;

import java.util.Arrays;
import java.util.HashSet;

class InternetOrder implements Order {
    private ListNode head;
    private int size;

    public InternetOrder() {
        head = new ListNode(null);
        size = 0;
    }

    public InternetOrder(Item[] items) {
        this();
        for (Item item : items) {
            addPosition(item);
        }
    }

    public void addPosition(Item item) {
        if (item == null) {
            return;
        }

        ListNode newNode = new ListNode(item);
        ListNode lastNode = head.getPrev();

        if (lastNode == null) {
            head.setNext(newNode);
            newNode.setPrev(head);
        } else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
        }

        head.setPrev(newNode);
        newNode.setNext(head);

        size++;
    }

    public boolean removePosition(String name) {
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null && item.name().equals(name)) {
                ListNode prevNode = currentNode.getPrev();
                ListNode nextNode = currentNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public Item[] getItems() {
        Item[] items = new Item[size];
        ListNode currentNode = head.getNext();
        for (int i = 0; i < size; i++) {
            items[i] = currentNode.getItem();
            currentNode = currentNode.getNext();
        }
        return items;
    }

    public double getTotalCost() {
        double totalCost = 0;
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null) {
                totalCost += item.cost();
            }
            currentNode = currentNode.getNext();
        }
        return totalCost;
    }

    public int getTotalDishes(String name) {
        int count = 0;
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null && item.name().equals(name)) {
                count++;
            }
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public String[] getUniqueItemNames() {
        HashSet<String> uniqueNames = new HashSet<>();
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null) {
                uniqueNames.add(item.name());
            }
            currentNode = currentNode.getNext();
        }
        return uniqueNames.toArray(new String[0]);
    }

    public Item[] getSortedItemsByCost() {
        Item[] items = getItems();
        Arrays.sort(items, (a, b) -> Double.compare(b.cost(), a.cost()));
        return items;
    }

    private class ListNode {
        private Item item;
        private ListNode prev;
        private ListNode next;

        public ListNode(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

