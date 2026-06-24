public class ForecastTest
{

    public static void main(String[] args)
    {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        System.out.println("=== Financial Forecasting ===\n");
        System.out.println("Present Value : ₹" + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);

        double result = FinancialForecast.predictFutureValue(presentValue, growthRate, years);
        System.out.printf("%nPredicted Future Value (Recursive)  : ₹%.2f%n", result);

        double memoResult = FinancialForecast.predictMemoized(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value (Memoized)   : ₹%.2f%n", memoResult);

        System.out.println("\n=== Analysis ===");
        System.out.println("Recursive : O(n) time, O(n) stack space — recalculates each step");
        System.out.println("Memoized  : O(n) time, avoids redundant calls by caching results");
        System.out.println("Optimization: Memoization prevents recomputation for overlapping subproblems");
    }
}
