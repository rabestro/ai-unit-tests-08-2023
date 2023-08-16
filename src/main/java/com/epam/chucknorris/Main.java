package com.epam.chucknorris;

import com.epam.chucknorris.decode.BinaryToAsciiConverter;
import com.epam.chucknorris.decode.UnaryToBinaryConverter;
import com.epam.chucknorris.encode.AsciiToBinaryConverter;
import com.epam.chucknorris.encode.BinaryToUnaryConverter;

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
