package org.apache.commons.math4.examples.sofm.tsp.test;

import org.apache.commons.math4.examples.sofm.tsp.City;
import org.apache.commons.math4.examples.sofm.tsp.TravellingSalesmanSolver;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.core.BaseProvider;
import org.apache.commons.rng.core.RandomProviderDefaultState;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class GCTSPTest {
    City city1;
    City city2;
    City city3;
    City[] cities;

    @BeforeEach
    public void setup(){
        city1 = new City("city1",2,4);
        city2 = new City("city2",2,4);
        city3 = new City("city3",5,8);
        cities = new City[]{
                city1, city2, city3
        };
    }

    /**
     * Test for 1,3,4,6,7,8,7,8,7,9,12,10,11,10,11,10,15!
     */
    @Test
    public void test5() {
        City[] cityList = TravellingSalesmanSolver.solve(cities, 1000, 1000,2, RandomSource.KISS.create());
        assert(cityList.length > 0);
    }
    /**
     * Test for 1,3,4,6,7,8,7,9,12,13,14!
     * @throws InterruptedException
     */
    @Test
    public void test6() throws InterruptedException {
        Thread solvingThread = new Thread(() -> {
            assertThrows(InterruptedException.class, () -> {
                TravellingSalesmanSolver.solve(cities, 1000, 1000,1, RandomSource.KISS.create());
            });
        });
        solvingThread.start();
        Thread.sleep(1000);
        solvingThread.interrupt();
    }

    /**
     * Test for 8,7,9,12,14!
     *  It is possible by changing the Random Number Generator to change after some time (pretty strange thing to do lol, but it works)
     */
    @Test
    public void test7(){
        double curTime = System.currentTimeMillis();
        assertThrows(RuntimeException.class, () -> {
            TravellingSalesmanSolver.solve(cities, 10000, 10000, 1, new UniformRandomProvider() {
                @Override
                public long nextLong() {
                    if(System.currentTimeMillis() > curTime+10000){
                        throw new RuntimeException();
                    }else return 0;
                }
            });
        });
    }

    /**
     * Test for 1,3,4,5!
     * Just have to set neuronsPerCity to less than 1
     */
    @Test
    public void test8(){
        assertThrows(IllegalArgumentException.class, () -> {
            TravellingSalesmanSolver.solve(cities, .5, 1000,2, RandomSource.KISS.create());
        });
    }

    /**
     * Test for 1,2!
     * Just have to have less than 3 elements in the city array
     */
    @Test
    public void test9(){
        cities = new City[]{city1,city2};
        City[] cities2 = TravellingSalesmanSolver.solve(cities, .5, 1000,2, RandomSource.KISS.create());
        assert(cities == cities2);
    }

}
