import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name must not be empty");
        }
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends ProductCategory {
    private String author;

    public BookCategory(String author) {
        super("Books");
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author must not be empty");
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class ClothingCategory extends ProductCategory {
    private String size;

    public ClothingCategory(String size) {
        super("Clothing");
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Size must not be empty");
        }
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

class GadgetCategory extends ProductCategory {
    private int warrantyMonths;

    public GadgetCategory(int warrantyMonths) {
        super("Gadgets");
        if (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months must not be negative");
        }
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name must not be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category must not be null");
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public String toString() {
        return name + " [" + category.getCategoryName() + "] : Rs." + price;
    }
}

public class DynamicOnlineMarketplace {

    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }

    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<Product<?>>();

        Product<BookCategory> book = new Product<BookCategory>("Java Fundamentals", 599, new BookCategory("James Gosling"));
        Product<ClothingCategory> shirt = new Product<ClothingCategory>("Cotton Shirt", 1200, new ClothingCategory("L"));
        Product<GadgetCategory> earbuds = new Product<GadgetCategory>("Wireless Earbuds", 3500, new GadgetCategory(12));

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(earbuds);

        System.out.println("Catalog before discount:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        applyDiscount(book, 10);
        applyDiscount(shirt, 25);
        applyDiscount(earbuds, 15);

        System.out.println("Catalog after discount:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }
}
