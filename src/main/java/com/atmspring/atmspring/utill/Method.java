package com.atmspring.atmspring.utill;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Method {

    public static void print(Object o){
        System.out.println(o);
    }



    public static <T> Object getInput(String massage, T c) {
        print(massage);
        Scanner scanner = new Scanner(System.in);
        try {
            if (c == int.class || c == Integer.class)
                return scanner.nextInt();
            if (c == String.class)
                return scanner.nextLine();
            if (c == double.class || c == Double.class)
                return scanner.nextDouble();
            if (c == float.class || c == Float.class)
                return scanner.nextFloat();
        } catch (InputMismatchException e) {
            return getInput("Not valid",c);
        }

        return null;
    }
}
