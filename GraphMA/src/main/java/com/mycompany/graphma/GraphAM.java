/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphma;

/**
 *
 * @author Usuario
 */
import java.util.Comparator;

public class GraphAM<V, E> {

    private V[] vertices;
    private int[][] adjMatrix;
    private E[][] metadataMatrix;
    private int effectiveSize;
    private int CAPACITY = 100;
    private boolean isDirected;
    private Comparator<V> cmpVertices;
    
    public boolean addVertex (V vertex) {
        if (vertex == null || this.hasVertex(vertex)) {
            return false;
        }
        // chequear tamaño y hacer crecer si fuera necesario
        if (this.isFull()) {
            // llamar a addCapacity
        }
        this.vertices[effectiveSize] = vertex;
        effectiveSize++;
        return true;
    }

    public boolean connect(V v1, V v2) {
        return connect (v1, v2, 1, null);
    }

    public boolean connect(V v1, V v2, int w) {
        return connect (v1, v2, w, null);
    }

    public boolean connect(V source, V target, int w, E metadata) {
        if (source == null || target == null) {
            return false;
        }
        int i1 = findVertex(source);
        int i2 = findVertex(target);
        if (i1 == -1 || i2 == -1) {
            return false;
        }
        this.adjMatrix[i1][i2] = w;
        this.metadataMatrix[i1][i2] = metadata;
        if (!this.isDirected) {
            this.adjMatrix[i2][i1] = w;
            this.metadataMatrix[i2][i1] = metadata;
        }
        return true;
    }

    private int findVertex(V v) {
        for (int i = 0; i < effectiveSize; i++) {
            if (this.cmpVertices.compare(v, vertices[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean hasVertex (V vertex) {
        return findVertex(vertex) != -1;
    }

    private boolean isFull() {
        return this.effectiveSize == this.CAPACITY;
    }
}
