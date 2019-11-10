package ru.job4j.lambda.collect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void collectAddress() {
        Profiles profiles = new Profiles();
        Address firstAddress = new Address("St.Petersburg", "Krasnoarmeyskaya street", 27, 2);
        Address secondAddress = new Address("Bryansk", "Gagarina street", 13, 176);
        Address thirdAddress = new Address("Moscow", "Voroshilova street", 3, 97);
        List<Profile> list = new ArrayList<>(Arrays.asList(
                new Profile(firstAddress),
                new Profile(secondAddress),
                new Profile(thirdAddress)
        ));
        List<Address> result = profiles.collect(list);
        List<Address> expect = Arrays.asList(firstAddress, secondAddress, thirdAddress);
        assertThat(result, is(expect));
    }
}