package com.epam.homework;

import javafx.util.Pair;

import java.util.*;

/*
Задан список чисел, длиной [2, 1024] со значениями [0, 32767].
А также предоставляется число k [1, 32767].
Требуется реализовать функцию, которая будет возвращать true, в случае, если в массиве имеются два числа, сумма которых равна k.

Ограничение по памяти - 4кб
Однопроходный алгоритм.
*/
public class checkIfListHasSum {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList<Integer>(Arrays.asList(1, 11, 3, 5, 10));
        System.out.println("Strait: " + isSumPresentStraitWay(arr, 6));
        System.out.println("Smart: " + isSumPresent(arr, 6));

        System.out.println("In class: " + isSumPresentInClass(arr, 9));
    }

    static boolean isSumPresent(List<Integer> list, int sum) {
        boolean result = false;
        int size = list.size();
        int previous = list.get(0);
        int allSum = previous;
        ArrayList arr = (ArrayList) list;
        for (int i=1; i<size; i++) {
            int temp = previous;
            previous = list.get(i);
            allSum += previous;

            if (sum == allSum) {
                result = true;
                break;
            }

            allSum -= temp;

        }
        return result;
    }

    static boolean isSumPresentStraitWay(List<Integer> list, int sum) {
        Collections.sort(list);
        boolean result = false;
        int size = list.size();
        int previous = list.get(0);
        int allSum = previous;
        ArrayList arr = (ArrayList) list;
        for (int i=1; i<size; i++) {
            int temp = previous;
            previous = list.get(i);
            allSum += previous;

            if (sum == allSum) {
                result = true;
                break;
            }

            allSum -= temp;

        }
        return result;
    }
    static boolean isSumPresentInClass(List<Integer> list, int sum) {

        // Можно сделать через битовую маску О_о
        // Памяти понадобится на 2^9 элементов
        // Класс BitSet()

        boolean result = false;
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        BitSet bitSet = new BitSet();
        bitSet.get(1);
        for (int i: list) {
            if (i<sum) {
                set.add(i);
            }
        }

        for (int i:list) {
            result = set.contains(sum-i);
        }

        for (int i: list){
            if (i<sum) {
                map.put(i, true);
            }
        }

        return result;

    }
}
