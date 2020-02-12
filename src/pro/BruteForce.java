package pro;

import java.util.ArrayList;
import java.util.List;

/**
 * pro.BruteForce.java
 * Klasa algorytmu przegladu zupelnego.
 *
 * @author Kamil Blanik
 * @since 07-03-2019
 */
public class BruteForce implements Algorithm {
    /**
     * Pomocnicza funkcja tworzaca permutacje przedmiotow
     *
     * @param items {@code List<pro.Items>} lista przedmotow do permutacji
     * @return Zwraca w postaci listy, wszystkie permutacje przedmiotow
     */
    private List<List<Item>> permutation(List<Item> items) {
        List<List<Item>> tmpList = new ArrayList<>();
        tmpList.add(new ArrayList<Item>());

        for (Item item : items) {
            List<List<Item>> current = new ArrayList<>();
            for (List<Item> l : tmpList) {
                for (int i = 0; i < l.size() + 1; i++) {
                    l.add(i, item);

                    List<Item> temp = new ArrayList<>(l);
                    current.add(temp);

                    l.remove(i);
                }
            }

            tmpList = new ArrayList<>(current);
        }

        return tmpList;
    }

    /**
     * Wykorzystanie algorytmu przegladu zupelnego. Sprawdzenie wszystkich mozliwych podzbiorow i wybranie najlepszego.
     *
     * @param items    Lista {@code List<pro.Item>} dostepnych przedmiotow do rozwiazania problemu.
     * @param instance Instancja {@code pro.Instance} bedaca plecakiem.
     */
    @Override
    public void solveAlgorithm(List<Item> items, Instance instance) {
        List<List<Item>> sublist = permutation(items);
        List<Item> best = new ArrayList<>();
        List<Item> tmp;
        float bestValue = 0;
        float current;
        int weight;
        for (List<Item> list : sublist) {
            boolean stop = false;
            weight = 0;
            current = 0;
            tmp = new ArrayList<>();
            for (Item item : list) {
                if (instance.getBackpackSize() >= weight + item.getItemWeight() && !stop) {
                    tmp.add(item);
                    current += item.getItemValue();
                    weight += item.getItemWeight();
                } else {
                    stop = true;
                }
            }
            if (current > bestValue) {
                bestValue = current;
                best = tmp;
            }
        }
        instance.setItemList(best);
    }

    /**
     * @return Opis Algorytmu
     */
    @Override
    public String getSpecification() {
        return "Algorytm przegladu zupelnego.";
    }

    @Override
    public String getName() {
        return "BruteForce";
    }
}