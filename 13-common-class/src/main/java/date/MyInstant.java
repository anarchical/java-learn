package date;

import java.time.Instant;

/**
 * @author YeYaqiao
 */
public class MyInstant {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        Instant instant=Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
    }
}
