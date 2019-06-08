package com.socialserv.model.tests;

import java.util.function.Function;

public interface Monad<T> {
    public <U> Monad<U> bind(Function<T, Monad<U>> f);
}
