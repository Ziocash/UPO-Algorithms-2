package upo.union20025432;

import java.util.ArrayList;

/**
 * Develop a class that represents an unionfind operation abstraction.<br/>
 * 
 * Use integers as data.
 */
public class UnionFind {

    private ArrayList<ArrayList<Integer>> collections;

    public UnionFind() {
        collections = new ArrayList<ArrayList<Integer>>();
    }

    private boolean exists(Integer value) {
        for (var collection : collections)
            if (collection.contains(value))
                return true;
        return false;
    }

    private int search(Integer value) {
        for (var collection : collections)
            if (collection.contains(value))
                return collections.indexOf(collection);
        return -1;
    }

    /**
     * Creates a new collection with {@code root} as collection root
     * 
     * @param root Collection root
     */
    public void makeSet(Integer root) {
        if (!exists(root)) {
            var collection = new ArrayList<Integer>();
            collection.add(0, root);
            collections.add(collection);
        }
    }

    /**
     * Merges two collection in a single one, putting as root the root of the first
     * collection
     * 
     * @param element1 Element in the first collection, it will be the new
     *                 collection root
     * @param element2 Element in the second collection
     * @throws ScemoDiMerdaException
     */
    public void union(Integer element1, Integer element2) throws IllegalArgumentException {
        int index1 = search(find(element1));
        int index2 = search(find(element2));
        if(index1 == index2)
            throw new IllegalArgumentException("Cannot merge the same set to itself.");

        if (index1 > -1 && index2 > -1) {
            collections.get(index1).addAll(collections.get(index2));
            collections.remove(collections.get(index2));
        }
    }

    /**
     * Returns the collection root in which the element is, otherwise -1
     * 
     * @param element the element to search for
     * @return the collection root in which the element is, otherwise -1
     */
    public Integer find(Integer element) {
        if (exists(element))
            for (var collection : collections)
                if (collection.contains(element))
                    return collection.get(0);
        return -1;
    }
}
