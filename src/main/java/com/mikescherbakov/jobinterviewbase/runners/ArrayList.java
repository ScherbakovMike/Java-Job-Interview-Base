package com.mikescherbakov.jobinterviewbase.runners;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import lombok.Getter;

class ArrayList<E> implements List<E> {

  private Object[] array = new Object[10];
  @Getter
  private int size = 0;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return indexOf(o) != -1;
  }

  @Override
  public Iterator<E> iterator() {
    return (Iterator<E>) Arrays.stream(array).limit(size).iterator();
  }

  @Override
  public Object[] toArray() {
    var result = new Object[size];
    System.arraycopy(array, 0, result, 0, size);
    return result;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(array, size, a.getClass());
    }
    System.arraycopy(array, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public boolean add(E e) {
    resizeArray(1);
    array[size] = e;
    size++;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    var index = indexOf(o);
    if (index == -1) {
      return false;
    }
    remove(index);
    return true;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (var item : c) {
      if (!contains(item)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    resizeArray(c.size());
    var index = size;
    for (var item : c) {
      array[index] = item;
      index++;
      size++;
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    resizeArray(c.size());
    System.arraycopy(array, index, array, index + c.size(), size - index);
    var i = index;
    for (var item : c) {
      array[i] = item;
      i++;
    }
    size += c.size();
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    var index = 0;
    while (index < size) {
      if (c.contains(array[index])) {
        remove(array[index]);
      } else {
        index++;
      }
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    var index = 0;
    while (index < size) {
      if (!c.contains(array[index])) {
        remove(index);
      } else {
        index++;
      }
    }
    return true;
  }

  @Override
  public void clear() {
    size = 0;
  }

  @Override
  public E get(int index) {
    return (E) array[index];
  }

  @Override
  public E set(int index, E element) {
    array[index] = element;
    return element;
  }

  @Override
  public void add(int index, E element) {
    if (index > size) {
      throw new IllegalArgumentException();
    }
    resizeArray(1);
    if (index == size) {
      array[size] = element;
    } else {
      System.arraycopy(array, index, array, index + 1, size - index);
      array[index] = element;
    }
    size++;
  }

  @Override
  public E remove(int index) {
    var result = array[index];
    System.arraycopy(array, index + 1, array, index, size - index - 1);
    size--;
    return (E) result;
  }

  @Override
  public int indexOf(Object o) {
    var index = 0;
    while (index < size && array[index] != o) {
      index++;
    }
    if (index == size) {
      return -1;
    }
    return index;
  }

  @Override
  public int lastIndexOf(Object o) {
    var index = size - 1;
    while (index >= 0 && array[index] != o) {
      index--;
    }
    return index;
  }

  @Override
  public ListIterator<E> listIterator() {
    return (ListIterator<E>) Arrays.stream(array)
        .limit(size)
        .toList().listIterator();
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return (ListIterator<E>) Arrays.stream(array)
        .skip(index)
        .limit(size - index)
        .toList().listIterator();
  }

  @Override
  public String toString() {
    return Arrays.stream(array).limit(size).toList().toString();
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException();
    }
    return Arrays.asList((E[]) Arrays.copyOfRange(array, fromIndex, toIndex));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof List<?>)) {
      return false;
    }

    var arrayList = (List<E>) o;
    if (size != arrayList.size()) {
      return false;
    }
    var index = 0;
    while (index < size && array[index] == arrayList.get(index)) {
      index++;
    }
    return (index == size);
  }

  @Override
  public int hashCode() {
    int result = Arrays.hashCode(array);
    result = 31 * result + size;
    return result;
  }

  private void resizeArray(int itemsToBeAdded) {
    if ((size + itemsToBeAdded) >= array.length / 2) {
      var newArray = new Object[array.length * 2];
      System.arraycopy(array, 0, newArray, 0, size);
      array = newArray;
    }
  }
}