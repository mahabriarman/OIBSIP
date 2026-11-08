import java.util.Random;
public class Game {
    private final Random random = new Random();
    public int generateRandomNumber(int min, int max){
        if (min > max) {
            throw new IllegalArgumentException(
                    "Minimum value cannot be greater than maximum value."
            );
        }

        return  random.nextInt(max-min + 1 ) + min;
    }
}
