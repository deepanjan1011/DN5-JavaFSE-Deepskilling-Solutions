import java.util.HashMap;
import java.util.Map;

public class FinancialForecast
{

    // Recursive: O(n) time, O(n) stack space
    static double predictFutureValue(double presentValue, double growthRate, int years)
    {
        if (years == 0)
            return presentValue;
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Memoized: avoids recomputation if called multiple times with same args
    private static Map<Integer, Double> memo = new HashMap<>();

    static double predictMemoized(double presentValue, double growthRate, int years)
    {
        if (years == 0) return presentValue;
        if (memo.containsKey(years))
            return memo.get(years);
        double result = predictMemoized(presentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, result);
        return result;
    }
}
