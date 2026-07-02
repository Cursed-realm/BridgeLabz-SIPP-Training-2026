import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name must not be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getCategory();

    public String toString() {
        return getCategory() + " -> " + name + " : Rs." + price;
    }
}

class Electronics extends WarehouseItem {
    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        if (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months must not be negative");
        }
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry date must not be empty");
        }
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material must not be empty");
        }
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getCategory() {
        return "Furniture";
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<T>();
    }

    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public int totalItems() {
        return items.size();
    }
}

public class SmartWarehouseManagementSystem {

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items list must not be null");
        }
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<Electronics>();
        electronicsStorage.addItem(new Electronics("Laptop", 55000, 12));
        electronicsStorage.addItem(new Electronics("Smartphone", 25000, 6));

        Storage<Groceries> groceriesStorage = new Storage<Groceries>();
        groceriesStorage.addItem(new Groceries("Rice Bag", 800, "2026-12-01"));
        groceriesStorage.addItem(new Groceries("Sugar Pack", 200, "2027-01-15"));

        Storage<Furniture> furnitureStorage = new Storage<Furniture>();
        furnitureStorage.addItem(new Furniture("Office Chair", 4500, "Wood"));
        furnitureStorage.addItem(new Furniture("Dining Table", 12000, "Metal"));

        System.out.println("Electronics Section:");
        displayAllItems(electronicsStorage.getItems());

        System.out.println("Groceries Section:");
        displayAllItems(groceriesStorage.getItems());

        System.out.println("Furniture Section:");
        displayAllItems(furnitureStorage.getItems());

        System.out.println("Total electronics items: " + electronicsStorage.totalItems());
    }
}
