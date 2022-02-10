package test;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Date a=new Date();
        System.out.println("%d"+a);
        Scanner scanner = new Scanner(System.in);
        boolean equals=true;
        String B;
        do{
            B=scanner.nextLine();
        }while(!B.equals("a"));
        System.out.println(equals);
    }
}
