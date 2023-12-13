/*
package org.example.demo;

import org.example.util.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class Benchmark {

    @State(Scope.Benchmark)
    public static class FullMap {

        List<String> ids;
        List<Car> cars;
        SkipListRandom<String, Car> carSkipListRandom;
        SkipListFixed<String, Car> carSkipListFixed;

        @Setup(Level.Iteration)
        public void generateIdsAndCars(BenchmarkParams params) {
            ids = Benchmark.generateIds(Integer.parseInt(params.getParam("elementCount")));
            cars = Benchmark.generateCars(Integer.parseInt(params.getParam("elementCount")));
        }

        @Setup(Level.Invocation)
        public void fillCarMap(BenchmarkParams params) {
            carSkipListRandom = new SkipListRandom<>();
            insert_SkipListRandom(ids, cars, carSkipListRandom);
            carSkipListFixed = new SkipListFixed<>();
            insert_SkipListFixed(ids, cars, carSkipListFixed);
        }
    }

    @Param({"10000", "20000"})
    public int elementCount;

    List<String> ids;
    List<Car> cars;

    @Setup(Level.Iteration)
    public void generateIdsAndCars() {
        ids = generateIds(elementCount);
        cars = generateCars(elementCount);
    }

    static List<String> generateIds(int count) {
        return new ArrayList<>(CarGenerator.generateShuffleIds(count));
    }

    static List<Car> generateCars(int count) {
        return new ArrayList<>(CarGenerator.generateShuffleCars(count));
    }
    /*
        @org.openjdk.jmh.annotations.Benchmark
        public Map<String, Car> putMap() {
            Map<String, Car> carsMap = new HashMap<>(HashManager.HashType.DIVISION);
            putMappings(ids, cars, carsMap);
            return carsMap;
        }

    @org.openjdk.jmh.annotations.Benchmark
    public void insertFixed(FullMap fullMap) {
        SkipListFixed<String, Car> skipListFixed = new SkipListFixed<>();
        List<String> ids = fullMap.ids;
        List<Car> cars = fullMap.cars;

        for (int i = 0; i < ids.size(); i++) {
            skipListFixed.insert(ids.get(i), cars.get(i));
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void insertRandom(FullMap fullMap) {
        SkipListRandom<String, Car> skipListRandom = new SkipListRandom<>();
        List<String> ids = fullMap.ids;
        List<Car> cars = fullMap.cars;

        // Preallocate data structures
        for (int i = 0; i < ids.size(); i++) {
            skipListRandom.insert(ids.get(i), cars.get(i));
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void removeFixed(FullMap fullMap) {
        SkipListFixed<String, Car> skipListFixed = new SkipListFixed<>();
        insert_SkipListFixed(fullMap.ids, fullMap.cars, skipListFixed);
        for(String id : fullMap.ids){
            skipListFixed.remove(id);
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void removeRandom(FullMap fullMap) {
        SkipListRandom<String, Car> skipListRandom = new SkipListRandom<>();
        insert_SkipListRandom(fullMap.ids, fullMap.cars, skipListRandom);
        for(String id : fullMap.ids){
            skipListRandom.remove(id);
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void searchFixed(FullMap fullMap) {
        SkipListFixed<String, Car> skipListFixed = new SkipListFixed<>();
        insert_SkipListFixed(fullMap.ids, fullMap.cars, skipListFixed);
        for(String id : fullMap.ids){
            skipListFixed.search(id);
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void searchRandom(FullMap fullMap) {
        SkipListRandom<String, Car> skipListRandom = new SkipListRandom<>();
        insert_SkipListRandom(fullMap.ids, fullMap.cars, skipListRandom);
        for(String id : fullMap.ids){
            skipListRandom.search(id);
        }
    }
    public static void insert_SkipListRandom(List<String> ids, List<Car> cars, SkipListRandom<String, Car> carsRandom) {
        for (int i = 0; i < cars.size(); i++) {
            carsRandom.insert(ids.get(i), cars.get(i));
        }
    }
    public static void insert_SkipListFixed(List<String> ids, List<Car> cars, SkipListFixed<String, Car> carsFixed) {
        for (int i = 0; i < cars.size(); i++) {
            carsFixed.insert(ids.get(i), cars.get(i));
        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

 */
