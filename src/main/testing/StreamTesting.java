package main.testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTesting {

    public void printForEach() throws IOException {
        example14();

    }

    private void example1() {
        IntStream intStream = IntStream.range(1, 10);
        // recorre del 1 al 9
        intStream
                .forEach(System.out::print);
    }

    private void example2() {
        IntStream intStream = IntStream.range(1, 10);
        // Recorre del 6 al 9
        intStream
                .skip(5)
                .forEach(x -> System.out.print(x));
    }

    private void example3() {
        IntStream intStream = IntStream.range(1, 10);
        // Suma todos los valores
        System.out.println(intStream
                .sum());
    }

    private void example4() {
        // Ordena y coge el primero
        List<String> listString = Arrays.asList("Bocina", "Colacao", "Agua");
        Optional<String> firstOnList = listString.stream().sorted().findFirst();
        if (firstOnList.isPresent()) {
            System.out.println(firstOnList.get());
        } else {
            System.out.println("Optional is empty");
        }
    }

    private void example5() {
        // filtra y ordena
        String[] names = {"Paco", "Alba", "Julio", "Javier"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("J"))
                .sorted()
                .forEach(System.out::println);
    }

    private void example6() {
        // Mapeo y media
        IntStream intStream = Arrays.stream(new int[]{2, 4, 6, 8, 10});
        OptionalDouble optInt = intStream
                .map(x -> x * x)
                .average();
        if (optInt.isPresent()) {
            System.out.println(optInt.getAsDouble());
        } else {
            System.out.println("No value in optional");
        }
    }

    private void example7() {
        // Filtra sin mayúsculas
        List<String> people = Arrays.asList("Paco", "Alba", "Julio", "Javier");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("j"))
                .sorted()
                .forEach(System.out::println);

    }

    private void example8() throws IOException {
        // Lee líneas de un archivo
        Stream<String> bands = Files.lines(Paths.get("documents/hola.txt"));
        bands
                .sorted()
                .filter(x -> x.contains("2"))
                .forEach(System.out::println);
        bands.close();
    }

    private void example9() throws IOException {
        List<String> bands2 = Files.lines(Paths.get("documents/hola.txt"))
                .filter(x ->
                        x.contains("1") || x.contains("2")
                )
                .collect(Collectors.toList());
        bands2.forEach(System.out::println);
    }

    private void example10() throws IOException {
        // Stream rows from CSV file, filter depending on content and count rows
        Stream<String> rows1 = Files.lines(Paths.get("documents/hola.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(";"))
                .filter(x -> x.length > 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
    }

    private void example11() throws IOException {
        // Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("documents/hola.txt"));
        rows2
                .map(x -> x.split(";"))
                .filter(x -> x.length > 3)
                .filter(x -> Arrays.toString(x).contains("ñ"))
                .forEach(x -> System.out.println(x[3]));
        rows2.close();
    }

    private void example12() throws IOException {
        // Stream rows from CSV, convert into map (get key and value)
        Stream<String> rows3 = Files.lines(Paths.get("documents/hola.txt"));
        Map<String, String> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(";"))
                .filter(x -> x.length > 3)
                .filter(x -> Integer.parseInt(x[3]) > 1)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> x[1]));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    private void example13() throws IOException {
        // Sum amount through Stream.reduce()
        // 0.0 Starting value, Double a the total acumulated, Double b the new element in Stream.
        double total = Stream.of(1.2, 3.4, 5.6)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
    }

    private void example14() throws IOException {
        //
        IntSummaryStatistics summary = IntStream.of(7, 2, 19)
                .summaryStatistics();
        System.out.println(summary);
        int min = summary.getMin();
        System.out.println("Min -> " + min);
    }


}
