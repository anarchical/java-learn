/**
 * @author YeYaqiao
 */
public enum Response {
    SUCCESS(1, "成功"),
    FAILED(0, "失败");

    private final Integer code;
    private final String message;

    Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        System.out.println(Response.FAILED.getCode());
        System.out.println(Response.SUCCESS.getMessage());
    }
}
