package com.satyam.benchmark;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
@State(Scope.Thread)
public class SortBenchmark {

    private int[] data;
    @Setup(Level.Invocation)
    public void setup() {
        Random random = new Random(42);
        data = new int[100000];

        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }
    }

    @Benchmark
    public void quickSortBenchmark() {
        QuickSort.sort(data);
    }
}