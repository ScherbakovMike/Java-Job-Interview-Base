package com.mikescherbakov.jobinterviewbase.runners;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.not;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

  private ArrayList<String> testList;

  @BeforeEach
  void initTest() {
    testList = new ArrayList<>();
    testList.addAll(List.of("1", "2", "3", "4", "5"));
  }

  @Test
  void size() {
    assertThat(testList.getSize(), equalTo(5));
  }

  @Test
  void isEmpty() {
    assertThat(testList.size(), equalTo(5));
    testList.clear();
    assertThat(testList.size(), equalTo(0));
  }

  @Test
  void contains() {
    assertThat(testList, hasItem("4"));
    assertThat(testList, not(Matchers.hasItem("7")));
  }

  @Test
  void iterator() {
    assertThat(testList.iterator(), isA(Iterator.class));
  }

  @Test
  void toArray() {
    assertThat(testList.toArray(), equalTo(new String[]{"1", "2", "3", "4", "5"}));
  }

  @Test
  void toArrayTyped() {
    assertThat(testList.toArray(new String[0]), equalTo(new String[]{"1", "2", "3", "4", "5"}));
  }

  @Test
  void add() {
    testList.add("6");
    assertThat(testList, equalTo(List.of("1", "2", "3", "4", "5", "6")));
  }

  @Test
  void remove() {
    testList.remove("3");
    assertThat(testList.size(), equalTo(4));
    assertThat(testList, equalTo(List.of("1", "2", "4", "5")));
  }

  @Test
  void containsAll() {
    assertThat(
        testList.containsAll(List.of("1", "2", "3", "4", "5")),
        equalTo(true)
    );
  }

  @Test
  void addAll() {
    var listToAdd = List.of("7", "8", "9", "10", "11");
    testList.addAll(listToAdd);
    assertThat(testList, equalTo(List.of("1", "2", "3", "4", "5", "7", "8", "9", "10", "11")));
  }

  @Test
  void testAddAll() {
    var listToAdd = List.of("7", "8", "9", "10", "11");
    testList.addAll(0, listToAdd);
    assertThat(testList, equalTo(List.of("7", "8", "9", "10", "11", "1", "2", "3", "4", "5")));
  }

  @Test
  void removeAll() {
    testList.add("1");
    testList.removeAll(List.of("1", "3", "5"));
    assertThat(testList, equalTo(List.of("2", "4")));
  }

  @Test
  void retainAll() {
    testList.retainAll(List.of("1", "7", "8"));
    assertThat(testList, equalTo(List.of("1")));
  }

  @Test
  void clear() {
    testList.clear();
    assertThat(testList.size(), equalTo(0));
  }

  @Test
  void get() {
    assertThat(testList.get(3), equalTo("4"));
  }

  @Test
  void set() {
    testList.set(3, "10");
    assertThat(testList.get(3), equalTo("10"));
  }

  @Test
  void testAdd() {
    testList.add(0, "6");
    assertThat(testList, equalTo(List.of("6", "1", "2", "3", "4", "5")));
  }

  @Test
  void testRemove() {
    testList.remove(0);
    assertThat(testList, equalTo(List.of("2", "3", "4", "5")));

  }

  @Test
  void indexOf() {
    assertThat(testList.indexOf("3"), equalTo(2));
  }

  @Test
  void lastIndexOf() {
    testList.add("1");
    assertThat(testList.lastIndexOf("1"), equalTo(5));
  }

  @Test
  void listIterator() {
    var iterator = testList.listIterator();
    assertThat(iterator, isA(ListIterator.class));
    assertThat(iterator.hasNext(), equalTo(true));
    assertThat(iterator.next(), equalTo("1"));
  }

  @Test
  void testListIterator() {
    var iterator = testList.listIterator(1);
    assertThat(iterator, isA(ListIterator.class));
    assertThat(iterator.hasNext(), equalTo(true));
    assertThat(iterator.next(), equalTo("2"));
  }

  @Test
  void testToString() {
    assertThat(testList.toString(), equalTo("[1, 2, 3, 4, 5]"));
  }

  @Test
  void subList() {
    assertThat(testList.subList(1, 3), equalTo(List.of("2", "3")));
  }

  @Test
  void testEquals() {
    assertThat(testList.equals(List.of("1", "2", "3", "4", "5")), equalTo(true));
    assertThat(testList.equals(List.of("7", "2", "3", "4", "5")), equalTo(false));
  }

  @Test
  void testHashCode() {
    assertThat(testList.hashCode(), equalTo(-953748265));
  }

  @Test
  void getSize() {
    assertThat(testList.size(), equalTo(5));
  }
}