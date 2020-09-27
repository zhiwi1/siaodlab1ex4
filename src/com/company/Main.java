package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DoublyLinkedList dlist=new DoublyLinkedList();
        int n=0;
        LinkedList r2=new LinkedList();
        while (true) {
            System.out.println("Нажмите 1, добавить номер абонента и спецслужбы");
            System.out.println("Нажмите 2, если хотите из двунаправленного списка добавить в однонаправленный ");
            System.out.println("Нажмите 3, вывод однонаправленного списка");
            System.out.println("Нажмите 4, чтобы выйти из программы");
            do {

                while (!in.hasNextInt()) {
                    System.out.println("Неверный ввод");
                    in.next();
                }

                n = in.nextInt();
                in.nextLine();
            } while (n < 1 || n > 4);

            if (n == 1) {
                int x=input7(in);
                int y=input3(in);
                dlist.insertLast(y,x);
               System.out.println("Успешно добавлено");
            }
            if (n == 2) {addlists(dlist,r2);
System.out.println("Успешно добавлено");
            }
            if (n == 3) {
            for (int i=0;i<r2.size();i++){
               System.out.println( r2.getEl(i));
            }

              }

            if (n == 4) {
                break;
            }
        }






System.out.println(r2.getEl(0));


    }
    static int input3(Scanner in) {
        int n1 = 0;

        System.out.println("Введите трехначный номер спецслужбы");
        do {
            while (!in.hasNextInt()) {
                System.out.println("Неверный ввод");
                in.next();
            }

            n1 = in.nextInt();
            in.nextLine();
            if(n1>=10000000||n1<1000000){
                System.out.println("Вы ввели не трехзначный номер");
            }
        } while (n1 >= 1000 || n1 < 100);
        return n1;
    }
    static int input7(Scanner in){
        int n2 =0;
        System.out.println("Введите семизначный номер абонента");
        do{
            while (!in.hasNextInt()) {
                System.out.println("Неверный ввод");
                in.next();
            }


            n2=in.nextInt();
            in.nextLine();
            if(n2>=10000000||n2<1000000){
                System.out.println("Вы ввели не семизначный номер");
            }
        }while (n2>=10000000||n2<1000000);
        return n2;}


    static void addlists (DoublyLinkedList x,LinkedList y){
        Link2 newLink=x.last;
        for(int i=0;i<x.size;i++) {
            y.insert(newLink);
            newLink=newLink.previous;
        }

    }
}

class Link2 {
    public int n3;
    public int n7;
    public Link2 next;
    public Link2 previous;


    public Link2(int n3, int n7)
    {
        this.n3 = n3;
        this.n7 = n7;
    }
    public Link2(Link x){
        this.n3=x.getNumber();
    }



}

class DoublyLinkedList {
    public Link2 first;
    public Link2 last;
public int size;

    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }


    public boolean isEmpty()
    {
        return first == null;
    }

    public void insertLast(int n3, int n7)
    {
        Link2 newLink = new Link2(n3, n7);
        if (isEmpty()) {
            first = newLink;
        }
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        size++;
    }
}

class Link {
    private int number;
    public Link next;

    Link(int l) {
        this.number = l;

    }

    Link(Link2 x) {
         this.number = x.n7;

    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override// переопределние метода ToString
    public String toString() {

        return  getNumber() + "\n ";
    }
}
class LinkedList { private int size = 0;
    private Link first ;




    public int size() {
        return size;
    }



    public LinkedList()
    {
        first = null;
    }


    public void insert(Link2 k)
    {size++;
        Link newLink = new Link(k);
        Link previous = null;
        Link current = first;

        while (current != null &&k.n3<current.getNumber()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;

        }
        else {

            previous.next = newLink; }
        ;newLink.next = current;
    }


    public Link getEl(int index) {
        Link current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }




}

