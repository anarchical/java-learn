package sellticket;

/**
 * @author YeYaqiao
 */
public class Main {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        new Thread(ticket::sell,"线程1").start();
        new Thread(ticket::sell,"线程2").start();
    }
}
