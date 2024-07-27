package ru.strebkov;

import java.util.*;

public class Main {
    public static List<LinkedList<Integer>> garden = new ArrayList<LinkedList<Integer>>(5);
    public static LinkedList<Integer> garden1;
    public static LinkedList<Integer> garden2;
    public static LinkedList<Integer> garden3;
    public static LinkedList<Integer> garden4;
    public static LinkedList<Integer> garden5;


    public static void main(String[] args) {

        garden1 = addInCaseQuantityCarrots(garden1, 1);
        garden2 = addInCaseQuantityCarrots(garden1, 2);
        garden3 = addInCaseQuantityCarrots(garden1, 3);
        garden4 = addInCaseQuantityCarrots(garden1, 4);
        garden5 = addInCaseQuantityCarrots(garden1, 5);

        garden.add(0, garden1);
        garden.add(1, garden2);
        garden.add(2, garden3);
        garden.add(3, garden4);
        garden.add(4, garden5);
    System.out.println( " На 5 огородах всего марковки " + Arrays.toString(new List[]{garden}));

        int x = 10;
        int quantity = 0;

        while (x > 0) {

            if (!garden5.isEmpty()) {    // 5
                quantity += garden5.removeFirst();
                x--;
            } else if (!garden4.isEmpty() && !garden1.isEmpty()) {    //4+1
                x--;
                quantity += garden4.removeFirst() + garden1.removeFirst();
            } else if (!garden3.isEmpty() && !garden2.isEmpty()) {   // 3+2
                x--;
                quantity += garden3.removeFirst() + garden2.removeFirst();
            } else if (!garden3.isEmpty() && garden1.size() > 2) { // 3+1+1
                x--;
                quantity += garden3.removeFirst() + garden1.removeFirst() + garden1.removeFirst();
            } else if (garden2.size() < 2 && !garden1.isEmpty()) {  // 2+2+1
                x--;
                quantity += garden2.removeFirst() + garden2.removeFirst() + garden1.removeFirst();
            } else if (garden1.size() >= 5) { // 1+1+1+1+1
                x--;
                quantity += garden1.removeFirst() + garden1.removeFirst() + garden1.removeFirst() +
                        garden1.removeFirst() + garden1.removeFirst();

                //TODO 444444444444444
            } else if (!garden4.isEmpty()) { // 4
                x--;
                quantity += garden4.removeFirst();
            } else if (!garden3.isEmpty() && !garden1.isEmpty()) { // 3+1
                x--;
                quantity += garden3.removeFirst() + garden1.removeFirst();
            } else if (!garden2.isEmpty() && garden2.size() >= 2) { // 2+2
                x--;
                quantity += garden2.removeFirst() + garden2.removeFirst();
            } else if (!garden1.isEmpty()) { // 1+1+1+1
                x--;
                quantity += garden1.removeFirst() + garden1.removeFirst() + garden1.removeFirst() +
                        garden1.removeFirst();

                //TODO 333333333333333333333
            } else if (!garden3.isEmpty()) {
                x--;
                quantity += garden3.removeFirst();
            } else if (!garden2.isEmpty()) { // 2
                x--;
                quantity += garden2.removeFirst();
            } else {
                break;
            }
        }
        System.out.println("Максимально заяц собрал  морковки за 10 ходок = " + quantity);
    }

    public static LinkedList<Integer> addInCaseQuantityCarrots(LinkedList<Integer> garden, int numberCarrot) {
        garden = new LinkedList<>();
        Random rn = new Random();
        int count = rn.nextInt(10) + 1;
        for (int x = 0; x < count; x++) {
            garden.add(numberCarrot);
        }
        return garden;
    }

}