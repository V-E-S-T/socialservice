package com.socialserv.model.tests;

public class MainTest {

    public static void main(String[] args) {

        Maybe<Integer> maybe = new Maybe<>(5);
        Monad<Integer> monad = maybe.bind(varInt -> new Maybe<>(varInt+1)).
                                        bind(varInt -> new Maybe<>(varInt*2));
        System.out.println(((Maybe<Integer>)monad).getVal());


    }
}
