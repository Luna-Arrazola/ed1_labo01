package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        ordenarAlto(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void ordenarAlto(T[] array, int bajo, int alto) {
        if (bajo < alto) {
            int pivote = particionAlto(array, bajo, alto);
            ordenarAlto(array, bajo, pivote - 1);
            ordenarAlto(array, pivote + 1, alto);
        }
    }

    private static <T extends Comparable<T>> int particionAlto(T[] array, int bajo, int alto) {
        T pivote = array[alto];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (array[j].compareTo(pivote) <= 0) {
                i++;
                cambiar(array, i, j);
            }
        }

        cambiar(array, i + 1, alto);
        return i + 1;
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        ordenarBajo(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void ordenarBajo(T[] array, int bajo, int alto) {
        if (bajo < alto) {
            int pivote = particionBajo(array, bajo, alto);
            ordenarBajo(array, bajo, pivote - 1);
            ordenarBajo(array, pivote + 1, alto);
        }
    }

    private static <T extends Comparable<T>> int particionBajo(T[] array, int bajo, int alto) {
        T pivote = array[bajo];
        int i = alto + 1;

        for (int j = alto; j > bajo; j--) {
            if (array[j].compareTo(pivote) >= 0) {
                i--;
                cambiar(array, i, j);
            }
        }

        cambiar(array, i - 1, bajo);
        return i - 1;
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        ordenarRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void ordenarRandom(T[] array, int bajo, int alto) {
        if (bajo < alto) {
            int pivote = particionRandom(array, bajo, alto);
            ordenarRandom(array, bajo, pivote - 1);
            ordenarRandom(array, pivote + 1, alto);
        }
    }

    private static <T extends Comparable<T>> int particionRandom(T[] array, int bajo, int alto) {
        Random r = new Random();
        int indice = bajo + r.nextInt(alto - bajo + 1);
        cambiar(array, indice, alto);
        return particionAlto(array, bajo, alto);
    }

    private static <T> void cambiar(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}