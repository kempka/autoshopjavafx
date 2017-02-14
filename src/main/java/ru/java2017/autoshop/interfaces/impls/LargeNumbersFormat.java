package ru.java2017.autoshop.interfaces.impls;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by UserBoot on 11.02.2017.
 */
public class LargeNumbersFormat {

    public LargeNumbersFormat() {
    }

    public String spaceBetween(String ss) {

        String[] arrStrings = ss.split("");
        LinkedList list = new LinkedList();
        Collections.addAll(list, arrStrings);

        switch (arrStrings.length) {
            case 5:                 // 10 тыщ
                list.add(2, " ");
                break;
            case 6:                 // 100 тыщ
                list.add(3, " ");
                break;
            case 7:                 // мульён
                list.add(1, " ");
                list.add(5, " ");
                break;
            case 8:                 // 10 мульёнов
                list.add(2, " ");
                list.add(6, " ");
                break;
            case 9:                 // 100 мульёнов
                list.add(3, " ");
                list.add(7, " ");
                break;
            case 10:                // мульярд
                list.add(1, " ");
                list.add(5, " ");
                list.add(9, " ");
                break;
        }
        String s = "";
        for (Object ll : list) {
            s = s + ll;
        }
        return s;
    }
}
