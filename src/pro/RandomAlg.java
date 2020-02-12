package pro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * pro.RandomAlg.java
 * Klasa algorytmu losowego.
 *
 * @author Kamil Blanik
 * @since 07-03-2019
 */
public class RandomAlg implements Algorithm {
    /**
     * Algorytm losowania przedmiotow dodawanyh do plecaka, az do momentu jego zapelnienia
     *
     * @param items    Lista {@code List<pro.Item>}dostepnych przedmiotow do rozwiazania problemu.
     * @param instance Instancja {@code pro.Instance}bedaca plecakiem.
     */
    @Override
    public void solveAlgorithm(List<Item> items, Instance instance) {
        List<Item> tmp = new ArrayList<>(items);
        Item item;
        Random rand = new Random();
        while (instance.getCurrentWeight() <= instance.getBackpackSize() && tmp.size() > 0) {
            int i = rand.nextInt(tmp.size());
            item = tmp.get(i);
            if (instance.getCurrentWeight() + item.getItemWeight() <= instance.getBackpackSize()) {
                instance.addItem(item);
            }
            tmp.remove(i);
        }
    }

    /**
     * Metoda zwracajaca String
     *
     * @return Opis klasy
     */
    @Override
    public String getSpecification() {
        return "Algorytm przegladu losowego.";
    }

    @Override
    public String getName() {
        return "Random";
    }
}
