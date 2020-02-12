package pro;

import java.util.List;

/**
 * pro.Algorithm.java
 * Interfejs dla klas o nastepujacych metodach.
 *
 * @author Kamil Blanik
 * @since 07-03-2019
 */
public interface Algorithm {
    /**
     * Glowna metoda rozwiazujaca problem plecakowy dla danego algorytmu.
     *
     * @param items    Lista {@code List<pro.Item>} dostepnych przedmiotow do rozwiazania problemu.
     * @param instance Instancja {@code pro.Instance} bedaca plecakiem.
     **/
    void solveAlgorithm(List<Item> items, Instance instance);

    /**
     * Metoda zwracajaca opis algorytmu
     *
     * @return Ciag znakow zawierajacy opis algorytmu
     **/
    String getSpecification();

    /**
     * Metoda zwracajaca nazwe algorytmu.
     *
     * @return nazwa algorytmu
     */
    String getName();

}
