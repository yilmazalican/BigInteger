/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

/**
 *
 * @author Alican
 */
public class MyLinkedList {
    public Node first;
    public void add(int value)
    {
       Node  link = new Node (value);
link.next = first;
first = link;
    }
   
}
