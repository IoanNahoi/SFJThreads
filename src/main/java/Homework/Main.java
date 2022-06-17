package Homework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int nrOfmaxDivisors = 0;
        int numberMaxDivisor = 0;
        ExecutorService es = Executors.newFixedThreadPool(10);
        try {
            Divisor divisor;
            for (int i = 0; i < 100000; i++) {
                divisor = new Divisor(i);
                int nr = es.submit(divisor).get();
                if (nrOfmaxDivisors <= nr) {
                    numberMaxDivisor = i;
                    nrOfmaxDivisors = nr;
                }
            }
            es.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(numberMaxDivisor + " " + nrOfmaxDivisors);
    }
}
