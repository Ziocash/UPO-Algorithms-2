package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import upo.union20025432.UnionFind;

public class UnionFindTest {
    UnionFind unionFind = new UnionFind();

    @Test
    public void testMakeSetAndFind() {
        unionFind.makeSet(1);
        assertEquals(1, unionFind.find(1));
        unionFind.makeSet(2);
        assertEquals(2, unionFind.find(2));
        unionFind.makeSet(3);
        assertEquals(3, unionFind.find(3));
    }

    @Test
    public void testUnionOnError() {
        unionFind.makeSet(1);
        unionFind.makeSet(1);
        assertThrows(IllegalArgumentException.class,() -> unionFind.union(1, 1));
    }

    @Test
    public void testAll(){
        unionFind.makeSet(1);
        unionFind.makeSet(2);
        unionFind.union(1, 2);
        assertEquals(1, unionFind.find(1));
        assertEquals(1, unionFind.find(2));
        unionFind.makeSet(3);
        unionFind.makeSet(4);
        unionFind.union(3, 4);
        assertEquals(3, unionFind.find(3));
        assertEquals(3, unionFind.find(4));
        unionFind.makeSet(5);
        unionFind.makeSet(6);
        unionFind.union(5, 6);
        assertEquals(5, unionFind.find(5));
        assertEquals(5, unionFind.find(6));
        unionFind.union(1, 3);
        assertEquals(1, unionFind.find(4));
        unionFind.union(5, 1);
        assertEquals(5, unionFind.find(1));
    }
}
