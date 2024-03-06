package org.example;


    // Importación de paquetes necesarios

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Map;
import java.util.OptionalDouble;

// Definición de la clase StreamExamples
        public class StreamExamples {
            // Método principal
            public static void main(String[] args) {
                // Ejemplo 1 - filter
                List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                List<Integer> evenNumbers = numbers.stream()
                        .filter(n -> n % 2 == 0)  // Filtra los números pares
                        .collect(Collectors.toList());  // Recolecta los resultados en una lista
                System.out.println("filter: " + evenNumbers);

//                // Ejemplo 2 - map
                List<String> names = Arrays.asList("John", "Jane", "Bob", "Alice");
                List<Integer> nameLengths = names.stream()
                        .map(String::length)  // Mapea los nombres a sus longitudes
                        .collect(Collectors.toList());  // Recolecta las longitudes en una lista
                System.out.println("map: " + nameLengths);
//////
//                // Ejemplo 3 - forEach
                names.stream()
                        .forEach(System.out::println);  // Imprime cada nombre en una nueva línea

//                // Ejemplo 4 - collect
                Set<String> nameSet = names.stream()
                        .collect(Collectors.toSet());  // Recolecta los nombres en un conjunto
                System.out.println("collect: " + nameSet);
//
            //     Ejemplo 5 - reduce
                int sum = numbers.stream()
                        .reduce(0, Integer::sum);  // Suma todos los números
                System.out.println("reduce: " + sum);

              //   Ejemplo 6 - distinct
                List<Integer> distinctNumbers = numbers.stream()
                        .distinct()  // Elimina duplicados
                        .collect(Collectors.toList());  // Recolecta los resultados en una lista
                System.out.println("distinct: " + distinctNumbers);

                // Ejemplo 7 - sorted
                List<Integer> sortedNumbers = numbers.stream()
                        .sorted()  // Ordena los números en orden natural
                        .collect(Collectors.toList());  // Recolecta los resultados en una lista
                System.out.println("sorted: " + sortedNumbers);

                // Ejemplo 8 - flatMap
                List<List<String>> namesNested = Arrays.asList(
                        Arrays.asList("John", "Jane"),
                        Arrays.asList("Bob", "Alice")
                );
                List<String> flatNames = namesNested.stream()
                        .flatMap(List::stream)  // Convierte la lista anidada en un solo stream
                        .collect(Collectors.toList());  // Recolecta los nombres en una lista plana
                System.out.println("flatMap: " + flatNames);

                // Ejemplo 9 - allMatch
                boolean allEven = numbers.stream()
                        .allMatch(n -> n % 2 == 0);  // Verifica si todos los números son pares
                System.out.println("allMatch: " + allEven);

                // Ejemplo 10 - anyMatch
                boolean anyEven = numbers.stream()
                        .anyMatch(n -> n % 2 == 0);  // Verifica si al menos un número es par
                System.out.println("anyMatch: " + anyEven);

              //   Ejemplo 11 - noneMatch
                List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7, 9);
                boolean noneEven = oddNumbers.stream()
                        .noneMatch(n -> n % 2 == 0);  // Verifica si ninguno de los números es par
                System.out.println("noneMatch: " + noneEven);

              //   Ejemplo 12 - findFirst
                List<String> namesList = Arrays.asList("John", "Jane", "Bob", "Alice");
                Optional<String> firstName = namesList.stream()
                        .findFirst();  // Obtiene el primer nombre en el stream (o un Optional si está vacío)
                System.out.println("findFirst: " + firstName.orElse("No hay nombres"));

                // Ejemplo 13 - skip
                List<Integer> skippedNumbers = numbers.stream()
                        .skip(2)  // Omite los primeros 2 números
                        .collect(Collectors.toList());  // Recolecta los resultados en una lista
                System.out.println("skip: " + skippedNumbers);

                // Ejemplo 14 - limit
                List<Integer> limitedNumbers = numbers.stream()
                        .limit(3)  // Limita el stream a los primeros 3 números
                        .collect(Collectors.toList());  // Recolecta los resultados en una lista
                System.out.println("limit: " + limitedNumbers);

                // Ejemplo 15 - min y max
                Optional<Integer> minNumber = numbers.stream()
                        .min(Integer::compareTo);  // Encuentra el valor mínimo en el stream
                System.out.println("min: " + minNumber.orElse(0));

                Optional<Integer> maxNumber = numbers.stream()
                        .max(Integer::compareTo);  // Encuentra el valor máximo en el stream
                System.out.println("max: " + maxNumber.orElse(0));

             //   Ejemplo 16 - sum y average
                int sumNumbers = numbers.stream()
                        .mapToInt(Integer::intValue)  // Mapea los números a tipo primitivo int
                        .sum();  // Suma los valores
                System.out.println("sum: " + sumNumbers);

                OptionalDouble average = numbers.stream()
                        .mapToDouble(Integer::doubleValue)  // Mapea los números a tipo primitivo double
                        .average();  // Calcula el promedio
                System.out.println("average: " + average.orElse(0.0));

              //   Ejemplo 17 - anyMatch con Predicate
                List<String> namesWithJ = Arrays.asList("John", "Jane", "Bob", "Alice");
                Predicate<String> startsWithJ = name -> name.startsWith("B");
                boolean anyStartsWithJ = namesWithJ.stream()
                        .anyMatch(startsWithJ);  // Verifica si al menos un nombre comienza con "J"
                System.out.println("anyMatch con Predicate: " + anyStartsWithJ);

                // Ejemplo 18 - groupingBy
                List<String> namesToGroup = Arrays.asList("John", "Jane", "Bob", "Alice","MARIA" ,"Amy");
                Map<Integer, List<String>> groupedByLength = namesToGroup.stream()
                        .collect(Collectors.groupingBy(String::length));  // Agrupa los nombres por longitud
                System.out.println("groupingBy: " + groupedByLength);
            }
        }

