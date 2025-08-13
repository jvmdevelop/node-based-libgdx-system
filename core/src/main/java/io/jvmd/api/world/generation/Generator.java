package io.jvmd.api.world.generation;

public interface Generator<T> {

    T generate(int size);

}
