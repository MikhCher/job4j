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
        Address similarAddress = new Address("St.Petersburg", "Krasnoarmeyskaya street", 27, 2);
        Address secondAddress = new Address("St.Petersburg", "Gagarina street", 13, 176);
        Address thirdAddress = new Address("Moscow", "Voroshilova street", 3, 88);
        Address fourthAddress = new Address("Moscow", "Voroshilova street", 3, 93);
        List<Profile> list = new ArrayList<>(Arrays.asList(
                new Profile(firstAddress),
                new Profile(similarAddress),
                new Profile(secondAddress),
                new Profile(thirdAddress),
                new Profile(fourthAddress)
        ));
        List<Address> result = profiles.collect(list);
        List<Address> expect = Arrays.asList(thirdAddress, fourthAddress, secondAddress, firstAddress);
        assertThat(result, is(expect));
    }
}