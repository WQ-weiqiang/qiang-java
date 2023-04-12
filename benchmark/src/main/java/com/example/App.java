package com.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 * @author Qiang
 * https://github.com/openjdk/jmh/tree/master/jmh-samples/src/main/java/org/openjdk/jmh/samples
 */
public class App {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(App.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void wellHelloThere() throws InterruptedException {
        // this method was intentionally left blank.
        System.out.println(LocalDateTime.now());
        Thread.sleep(1000);
    }
}
