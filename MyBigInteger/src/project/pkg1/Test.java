/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

import java.util.Scanner;

/**
 *
 * @author Alican
 */
public class Test {

    public static void Reverse(MybigInteger list) {
        Node n = list.itsNumber.first;
        MyLinkedList reversed = new MyLinkedList();
        while (n != null) {
            reversed.add(n.value);
            n = n.next;

        }

        n = reversed.first;
        while (n != null) {
            System.out.print(n.value);
            n = n.next;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to the program");
        MybigInteger first;
        MybigInteger second;
        MybigInteger old;
        int secim;

        while (true) {
            System.out.println("Choose \n 1:Add \n 2:Substract \n 3:Multiply \n 4:Exponent \n 5:Exit");
            secim = scn.nextInt();
            switch (secim) {
                case 1:
                    System.out.println("Enter the first number");
                    first = new MybigInteger(scn.next());
                    System.out.println("Enter the second number");
                    second = new MybigInteger(scn.next());
                    System.out.print("Result: ");
                    old = first.add(second);
                    Reverse(old);

                    break;
                case 2:
                    System.out.println("Enter the first number Note: PLEASE ENTER THE FIRST NUMBER BIGGER THAN SECOND! due to program's requirements");
                    first = new MybigInteger(scn.next());
                    System.out.println("Enter the second number");
                    second = new MybigInteger(scn.next());
                    System.out.print("Result: " + first.subtract(second));
                    System.out.println("");
                    System.out.println("");
                
                  
                    break;
                case 3:
                    System.out.println("Enter the first number");
                    first = new MybigInteger(scn.next());
                    System.out.println("Enter the second number");
                    second = new MybigInteger(scn.next());
                    System.out.print("Result: ");
                    old = first.multiply(second);
                    Reverse(old);
                    break;
                case 4:
                    System.out.println("Enter the first number");
                    first = new MybigInteger(scn.next());
                    System.out.println("Enter the second number");
                    second = new MybigInteger(scn.next());
                    System.out.print("Result: ");
                    old = first.exponent(second);
                    Reverse(old);
                    break;
                
            }
            if (secim==5) {
                break;
            }
        }

    }

}
