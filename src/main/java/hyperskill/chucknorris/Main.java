package hyperskill.chucknorris;

import hyperskill.chucknorris.decode.BinaryToAsciiConverter;
import hyperskill.chucknorris.decode.UnaryToBinaryConverter;
import hyperskill.chucknorris.encode.AsciiToBinaryConverter;
import hyperskill.chucknorris.encode.BinaryToUnaryConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        new Application(
                scanner::nextLine,
                System.out::println,
                new AsciiToBinaryConverter().andThen(new BinaryToUnaryConverter()),
                new UnaryToBinaryConverter().andThen(new BinaryToAsciiConverter())
        ).run();
    }
}
