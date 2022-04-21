package time;

import java.time.Instant;

public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
    }
}
