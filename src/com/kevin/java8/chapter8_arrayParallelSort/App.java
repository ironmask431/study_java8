package com.kevin.java8.chapter8_arrayParallelSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
/**
20. 배열 ParallelSort

- Arrays.parallelSort()
Fork/Join 프레임워크를 사용해서 배열을 병렬로 정렬하는 기능을 제공한다.

- 병렬 정렬 알고리듬
배열을 둘로 계속 쪼갠다.
합치면서 정렬한다.

- sort()와 parallelSort() 비교
알고리듬 효율성은 같다. 시간 O(n logN) 공간 O(n) - 효율성은 같지만 다중스레드를 이용하므로 조금더 빠를 수 있다.
**/

        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        //numbers 배열에 랜덤한 숫자를 채움.
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);// 기본정렬 (싱글스레드)
        System.out.println("serial sorting took-"+(System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);// 패러랠 정렬
        System.out.println("serial sorting took-"+(System.nanoTime() - start));

        //실행결과
//        serial sorting took-1055600
//        serial sorting took-614400  => parallelSort 가 더빠른것을 확인할 수 있다.
    }
}
