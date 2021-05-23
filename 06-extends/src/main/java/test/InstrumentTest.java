package test;

class Instrument {
    public void play() {
        System.out.println("弹奏乐器");
    }
}

class Violin extends Instrument {

    @Override
    public void play() {
        System.out.println("拉小堤琴");
    }
}

class Piano extends Instrument {

    @Override
    public void play() {
        System.out.println("弹钢琴");
    }
}

public class InstrumentTest {

    public static void main(String[] args) {

        Instrument violin = new Violin();
        violin.play();

        Instrument piano = new Piano();
        piano.play();
    }

}
