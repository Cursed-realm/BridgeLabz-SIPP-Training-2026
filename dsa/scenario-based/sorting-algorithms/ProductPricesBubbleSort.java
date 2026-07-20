public class ProductPricesBubbleSort {
    public static void main(String[] args) {
        int[] prices = {450, 120, 780, 300, 250, 600};
        bubbleSort(prices);
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }

    public static void bubbleSort(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
