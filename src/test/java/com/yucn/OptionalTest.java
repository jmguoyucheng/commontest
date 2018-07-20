package com.yucn;

import com.yucn.entity.Customer;
import com.yucn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2018/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<Customer> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user=null;
        Optional<User> opt = Optional.of(user);
    }

    @Test
    public void whenCreateOfEmptyOptional() {
        User user=null;
        Optional<User> opt = Optional.ofNullable(user);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        assertEquals("John", opt.get());
    }

    @Test
    public void optionalTest(){
        //Optional<String> user=Optional.ofNullable("yucn");
        //user.ifPresent(System.out::println);

        //Optional<User> user=Optional.of(new User(1L,null));
        //System.out.println(user.map(u->u.getName())
        //        .map(n->n.toUpperCase())
        //        .orElse("no"));

        Optional<String> name=Optional.ofNullable(null);
        Optional<String> upperName=name.flatMap(value->Optional.ofNullable(value.toUpperCase()));
        upperName.ifPresent(System.out::println);

    }

    @Test
    public void streamTest(){
        //IntStream.of(new int[]{1,2,3}).forEach(System.out::println);
        //IntStream.range(1,10).forEach(System.out::println);
        //IntStream.rangeClosed(1,10).forEach(System.out::println);

        List<Integer> ints= Arrays.asList(1,2,3,4,5,6);
        ints.stream().map(e->e+1).collect(Collectors.toList()).forEach(System.out::println);
    }
}
