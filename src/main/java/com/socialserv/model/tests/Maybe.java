package com.socialserv.model.tests;

import java.util.function.Function;

public class Maybe<T> implements Monad<T>{

    private T val;

    public Maybe(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    @Override
    public <U> Monad<U> bind(Function<T, Monad<U>> f) {
        if(val == null){
            return new Maybe(null);
        }
        return f.apply(val);
    }
}
