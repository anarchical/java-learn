package test;

import java.io.IOException;

/**
 * @author YeYaqiao
 */
public class ThrowException {

    public void method() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {

        ThrowException throwException = new ThrowException();
        try {
            throwException.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
