/**
 * @author YeYaqiao
 * 枚举类型
 */
public enum Week {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURADAY,
    SUNDAY;

    public static void main(String[] args) {
        for (Week week : Week.values()) {
            System.out.println(week);
        }
    }
}
