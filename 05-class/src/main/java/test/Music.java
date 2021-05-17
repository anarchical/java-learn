package test;

public class Music {
    String instrument;
    String author;

    public void play() {
        System.out.println(author + " is playing " + instrument);
    }
}

class Test {
    public static void main(String[] args) {
        Music music = new Music();

        music.instrument = "吉他";
        music.author = "汪峰";

        music.play();
    }
}
