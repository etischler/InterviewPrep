import java.math.BigDecimal;
import java.math.RoundingMode;

public class BinarySearch_SquareRootOfInteger {
    public static void main(String[] args) {
        System.out.println(solution(11));
        System.out.println(solution(4));
        System.out.println(solution(0));
        System.out.println(solution(1));

    }

    private static int solution(int a) {
        BigDecimal start = BigDecimal.valueOf(0);
        BigDecimal end = BigDecimal.valueOf(a);

        while(!(end.subtract(start)).equals(BigDecimal.ONE)) {
            BigDecimal mid = end.subtract(start).divide(BigDecimal.valueOf(2)).add(start);
            mid = mid.setScale(0, RoundingMode.UP);

            if(mid.multiply(mid).equals(BigDecimal.valueOf(a)))
                return mid.intValue();
            if(mid.multiply(mid).compareTo(BigDecimal.valueOf(a)) == 1)
                end = mid;
            else
                start = mid;
        }
        return a != 1 ? start.intValue() : 1;
    }
}
