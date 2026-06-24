import java.util.Arrays;

public class SearchTest
{
    static Product linearSearch(Product[] products, int targetId)
    {
        for (Product p : products)
        {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    static Product binarySearch(Product[] products, int targetId)
    {
        int low = 0, high = products.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId)
                return products[mid];
            if (products[mid].productId < targetId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args)
    {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Phone", "Electronics"),
            new Product(5, "Shoes", "Fashion"),
            new Product(2, "Book", "Education"),
            new Product(4, "Watch", "Fashion")
        };

        System.out.println("=== Linear Search ===");
        System.out.println(linearSearch(products, 3));
        System.out.println(linearSearch(products, 9));

        Product[] sorted = products.clone();
        Arrays.sort(sorted, (a, b) -> a.productId - b.productId);

        System.out.println("\n=== Binary Search ===");
        System.out.println(binarySearch(sorted, 3));
        System.out.println(binarySearch(sorted, 9));

        System.out.println("\n=== Analysis ===");
        System.out.println("Linear Search: O(n) — no sorting needed, slow on large data");
        System.out.println("Binary Search: O(log n) — fast, but requires sorted array");
        System.out.println("Verdict: Binary search preferred for large product catalogs");
    }
}
