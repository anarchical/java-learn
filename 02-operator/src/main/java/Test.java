/**
 * @author YeYaqiao
 */
public class Test {


    int a;

    public int a() {
        int b = 0;
        return b;
    }

    public static void main(String[] args) {

        System.out.println(test());
        ;


    }


    public static int test() {
        int result=-1;
        asd:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("i: %d,j: %d \n", i, j);

                result=j+10;
                if (j == 5)
                    break asd;

            }
        }

        result+=1;

        return result;
    }
}
