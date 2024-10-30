package com.java.project;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Collection;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AstonList<T> implements AstonService<T> {

    int size = 0;
    T[] arr;

    @SuppressWarnings("unchecked")
    public AstonList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        arr = (T[]) new Object[length];
    }

    @SuppressWarnings("unchecked")
    public AstonList(Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        size = collection.size();
        arr = (T[]) new Object[size];
        int i = 0;
        for (T el : collection) {
            arr[i++] = el;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public void add(T el) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = el;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final var numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMoved);
        }
        size--;
    }

    @Override
    public void addAll(Collection<T> collection) {
        for (T el : collection) {
            add(el);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            var flag = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AstonList(size=").append(size).append(", arr=[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

}
