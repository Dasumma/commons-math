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
package org.apache.commons.math4.legacy.stat.descriptive;

import org.apache.commons.math4.legacy.exception.MathIllegalStateException;
import org.apache.commons.math4.legacy.exception.NullArgumentException;

/**
 * Implementation of
 * {@link org.apache.commons.math4.legacy.stat.descriptive.SummaryStatistics} that
 * is safe to use in a multithreaded environment.  Multiple threads can safely
 * operate on a single instance without causing runtime exceptions due to race
 * conditions.  In effect, this implementation makes modification and access
 * methods atomic operations for a single instance.  That is to say, as one
 * thread is computing a statistic from the instance, no other thread can modify
 * the instance nor compute another statistic.
 *
 * @since 1.2
 */
public class SynchronizedSummaryStatistics extends SummaryStatistics {
    /**
     * Construct a SynchronizedSummaryStatistics instance.
     */
    public SynchronizedSummaryStatistics() {
        super();
    }

    /**
     * A copy constructor. Creates a deep-copy of the {@code original}.
     *
     * @param original the {@code SynchronizedSummaryStatistics} instance to copy
     * @throws NullArgumentException if original is null
     */
    public SynchronizedSummaryStatistics(SynchronizedSummaryStatistics original)
    throws NullArgumentException {
        copy(original, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StatisticalSummary getSummary() {
        return super.getSummary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void addValue(double value) {
        super.addValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized long getN() {
        return super.getN();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getSum() {
        return super.getSum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getMean() {
        return super.getMean();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getStandardDeviation() {
        return super.getStandardDeviation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getVariance() {
        return super.getVariance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getMax() {
        return super.getMax();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized double getMin() {
        return super.getMin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized String toString() {
        return super.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void clear() {
        super.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StorelessUnivariateStatistic getSumImpl() {
        return super.getSumImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setSumImpl(StorelessUnivariateStatistic sumImpl)
    throws MathIllegalStateException {
        super.setSumImpl(sumImpl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StorelessUnivariateStatistic getMinImpl() {
        return super.getMinImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setMinImpl(StorelessUnivariateStatistic minImpl)
    throws MathIllegalStateException {
        super.setMinImpl(minImpl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StorelessUnivariateStatistic getMaxImpl() {
        return super.getMaxImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setMaxImpl(StorelessUnivariateStatistic maxImpl)
    throws MathIllegalStateException {
        super.setMaxImpl(maxImpl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StorelessUnivariateStatistic getMeanImpl() {
        return super.getMeanImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setMeanImpl(StorelessUnivariateStatistic meanImpl)
    throws MathIllegalStateException {
        super.setMeanImpl(meanImpl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized StorelessUnivariateStatistic getVarianceImpl() {
        return super.getVarianceImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setVarianceImpl(StorelessUnivariateStatistic varianceImpl)
    throws MathIllegalStateException {
        super.setVarianceImpl(varianceImpl);
    }

    /**
     * Returns a copy of this SynchronizedSummaryStatistics instance with the
     * same internal state.
     *
     * @return a copy of this
     */
    @Override
    public synchronized SynchronizedSummaryStatistics copy() {
        SynchronizedSummaryStatistics result =
            new SynchronizedSummaryStatistics();
        // No try-catch or advertised exception because arguments are guaranteed non-null
        copy(this, result);
        return result;
    }

    /**
     * Copies source to dest.
     * <p>Neither source nor dest can be null.</p>
     * <p>Acquires synchronization lock on source, then dest before copying.</p>
     *
     * @param source SynchronizedSummaryStatistics to copy
     * @param dest SynchronizedSummaryStatistics to copy to
     * @throws NullArgumentException if either source or dest is null
     */
    public static void copy(SynchronizedSummaryStatistics source,
                            SynchronizedSummaryStatistics dest)
        throws NullArgumentException {
        NullArgumentException.check(source);
        NullArgumentException.check(dest);
        synchronized (source) {
            synchronized (dest) {
                SummaryStatistics.copy(source, dest);
            }
        }
    }
}
