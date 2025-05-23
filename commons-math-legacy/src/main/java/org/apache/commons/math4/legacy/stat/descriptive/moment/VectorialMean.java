/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math4.legacy.stat.descriptive.moment;

import org.apache.commons.math4.legacy.exception.DimensionMismatchException;

/**
 * Returns the arithmetic mean of the available vectors.
 * @since 1.2
 */
public class VectorialMean {
    /** Means for each component. */
    private final org.apache.commons.statistics.descriptive.Mean[] means;
    /** Sample count. */
    private long n;

    /** Constructs a VectorialMean.
     * @param dimension vectors dimension
     */
    public VectorialMean(int dimension) {
        means = new org.apache.commons.statistics.descriptive.Mean[dimension];
        for (int i = 0; i < dimension; ++i) {
            means[i] = org.apache.commons.statistics.descriptive.Mean.create();
        }
    }

    /**
     * Add a new vector to the sample.
     * @param v vector to add
     * @throws DimensionMismatchException if the vector does not have the right dimension
     */
    public void increment(double[] v) throws DimensionMismatchException {
        if (v.length != means.length) {
            throw new DimensionMismatchException(v.length, means.length);
        }
        for (int i = 0; i < v.length; ++i) {
            means[i].accept(v[i]);
        }
        n++;
    }

    /**
     * Get the mean vector.
     * @return mean vector
     */
    public double[] getResult() {
        double[] result = new double[means.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = means[i].getAsDouble();
        }
        return result;
    }

    /**
     * Get the number of vectors in the sample.
     * @return number of vectors in the sample
     */
    public long getN() {
        return (means.length == 0) ? 0 : n;
    }
}
