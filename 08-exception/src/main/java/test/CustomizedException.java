package test;

/**
 * @author YeYaqiao
 */
public class CustomizedException extends Exception {

    public CustomizedException(String message) {
        super(message);
    }

    public static void main(String[] args) throws CustomizedException {
        CustomizedException customizedException = new CustomizedException("自定义异常");
        throw customizedException;
    }
}
