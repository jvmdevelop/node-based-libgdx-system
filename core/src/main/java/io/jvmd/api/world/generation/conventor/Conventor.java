package io.jvmd.api.world.generation.conventor;

public interface Conventor<T , R> {
    T convent(R object);
}
