package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SingletonTest {
    @Test
    public void whenEnumEager() {
        EnumEagerLoading tracker1 = EnumEagerLoading.INSTANCE;
        EnumEagerLoading tracker2 = EnumEagerLoading.INSTANCE;
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenStaticFieldLazy() {
        StaticFieldLazy tracker1 = StaticFieldLazy.getInstance();
        StaticFieldLazy tracker2 = StaticFieldLazy.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenStaticFinalFieldEager() {
        StaticFinalFieldEager tracker1  = StaticFinalFieldEager.getInstance();
        StaticFinalFieldEager tracker2  = StaticFinalFieldEager.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}