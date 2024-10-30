package com.java.project;

import java.util.Collection;

public interface AstonService<T> {

    T get(int index);

    void add(T el);

    void remove(int index);

    void addAll(Collection<T> collection);

    void bubbleSort();

    static <T extends Comparable<? super T>> void sort(AstonService<T> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        if (list instanceof AstonList<T> astonList) {
            astonList.bubbleSort();
        } else {
            throw new IllegalArgumentException();
        }
    }

}
