package main.testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTesting {

    public void printForEach() throws IOException {
        example11();

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
        // Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("documents/hola.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(";"))
                .filter(x -> x.length >3)
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



}
