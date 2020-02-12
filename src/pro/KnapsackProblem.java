package pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * pro.KnapsackProblem.java
 * Klasa glowna.
 *
 * @author Kamil Blanik
 * @since 07-03-2019
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        Instance instance1 = new Instance(10);
        Instance instance2 = new Instance(10);
        Instance instance3 = new Instance(10);
        Item item1 = new Item(1.8f, 2);
        Item item2 = new Item(3, 5);
        Item item3 = new Item(1.2f, 1);
        Item item4 = new Item(2.2f, 4);
        Item item5 = new Item(3.3f, 3);
        Item item6 = new Item(6.3f, 3);
        Item item7 = new Item(6.3f, 3);


        List<Item> items = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));
        List<Item> items2 = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));
        List<Item> items3 = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));

        Greedy greedy = new Greedy();
        greedy.solveAlgorithm(items, instance1);
        System.out.println(greedy.getSpecification());
        RandomAlg randAlg = new RandomAlg();
        randAlg.solveAlgorithm(items2, instance2);
        System.out.println(randAlg.getSpecification());
        BruteForce bf = new BruteForce();
        bf.solveAlgorithm(items3, instance3);
        System.out.println(bf.getSpecification());

        System.out.println(instance1.getCurrentValue());
        System.out.println(instance1.getCurrentWeight());
        System.out.println(instance2.getCurrentValue());
        System.out.println(instance2.getCurrentWeight());
        System.out.println(instance3.getCurrentValue());
        System.out.println(instance3.getCurrentWeight());
    }
}
