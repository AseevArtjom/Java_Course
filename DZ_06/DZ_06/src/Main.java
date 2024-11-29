import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> randomNumbers = new Random()
                .ints(100,-1000,1000)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("random numbers : " + randomNumbers);

        long positiveCount = randomNumbers.stream().filter(num -> num > 0).count();
        System.out.println("Positive numbers count : " + positiveCount);

        long negativeCount = randomNumbers.stream().filter(num -> num < 0).count();
        System.out.println("Negative numbers count : " + negativeCount);

        long TwoDigitNumbersCount = randomNumbers.stream().filter(num -> Math.abs(num) >= 10 && Math.abs(num) < 100).count();
        System.out.println("Two digit numbers count : " + TwoDigitNumbersCount);

        long MirroredNumbersCount = randomNumbers.stream().filter(num -> isMirroredNumber(num)).count();
        System.out.println("Mirrored numbers count : " + MirroredNumbersCount);
    }
    private static boolean isMirroredNumber(int num){
        String tmp = String.valueOf(Math.abs(num));
        return new StringBuilder(tmp).reverse().toString().equals(tmp);
    }
}