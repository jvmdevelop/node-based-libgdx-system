package io.jvmd.api.world.generation;

public interface Generator<T, R> {

    T generate(R size);

}
