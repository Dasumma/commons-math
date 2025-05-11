package org.apache.commons.math4.examples.sofm.tsp.test;

import org.apache.commons.math4.examples.sofm.tsp.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThrows;

class ISPTSPTest {
    private Set<City> cities;
    private City city1;
    private City city2;
    private double x;
    private double y;

    //Base Case
    @BeforeEach
    public void baseTest(){
        cities = new HashSet<City>();
        city1 = new City("test1", 7, 30);
        city2 = new City("test2", 5,10);
        cities.add(city1);
        cities.add(city2);
        x = 10;
        y =  20;
    }

    @Test
    public void ispTest1(){
        assert(City.closest(x,y,cities).equals(city1));
    }

    @Test
    public void ispTest2(){
        city2 = new City("test2", 7, 30);
        cities = new HashSet<City>();
        cities.add(city1);
        cities.add(city2);
        assert(City.closest(x,y,cities).equals(city1));
    }

    @Test
    public void ispTest3(){
        cities = new HashSet<City>();
        cities.add(city1);
        assert(City.closest(x,y,cities).equals(city1));
    }

    @Test
    public void ispTest4(){
        cities = new HashSet<City>();
        assert(City.closest(x,y,cities) == (null));
    }

    @Test
    public void ispTest5(){
        cities = null;
        assertThrows(NullPointerException.class, () -> {City.closest(x,y,cities);});
    }

    @Test
    public void ispTest6(){
        y=0;
        assert(City.closest(x,y,cities).equals(city2));
    }

    @Test
    public void ispTest7(){
        y=-5;
        assert(City.closest(x,y,cities).equals(city2));
    }

    @Test
    public void ispTest8(){
        x=0;
        assert(City.closest(x,y,cities).equals(city2));
    }

    @Test
    public void ispTest9(){
        x=-5;
        assert(City.closest(x,y,cities).equals(city2));
    }
}
