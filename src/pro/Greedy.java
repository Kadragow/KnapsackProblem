package pro;

import java.util.List;

/**
 * pro.Greedy.java
 * Klasa algorytmu zachlannego.
 *
 * @author Kamil Blanik
 * @since 07-03-2019
 */
public class Greedy implements Algorithm {
    /**
     * Metoda rozwiazujaca problem plecakowy w sposob zachlanny.
     * Porownoje ona przedmioty na podstawie ich stosunku wartosc/waga.
     *
     * @param items    Lista {@code List<pro.Item>} dostepnych przedmiotow do rozwiazania problemu.
     * @param instance Instancja {@code pro.Instance} bedaca plecakiem.
     */
    @Override
    public void solveAlgorithm(List<Item> items, Instance instance) {
        items.sort(Item.byRatio());

        for (Item item : items) {
            if (instance.getCurrentWeight() + item.getItemWeight() <= instance.getBackpackSize()) {
                instance.addItem(item);
            }
        }

    }

    /**
     * Metoda zwracajaca opis algorytmu zachalnnego.
     *
     * @return Opis algorytmu
     **/
    @Override
    public String getSpecification() {
        return "Algorytm zachlanny. Sugeruje sie stostunkiem wartosc/waga.";
    }

    @Override
    public String getName() {
        return "Greedy";
    }
}