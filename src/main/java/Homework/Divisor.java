package Homework;

import java.util.concurrent.Callable;

public class Divisor implements Callable<Integer> {

    int number;

    public Divisor(int x) {
        number = x;
    }

    public int numberOfDivisors() {
        int nr_div = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {

                if (number / i == i)
                    nr_div++;
                else
                    nr_div = nr_div + 2;
            }
        }
        return nr_div;
    }


    @Override
    public Integer call() throws Exception {
        return numberOfDivisors();
    }
}
