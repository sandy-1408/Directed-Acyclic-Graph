package com.ipac.DirectAcyclicGraph;

import java.util.Objects;

public class Vertex {
    long id;

    Vertex(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vertex(" + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
