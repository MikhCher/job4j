package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Conventer
 *
 * @author Mikhail Cherednichenko (28explay@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Converter {
    /**
     * Converts internal iterators to a single iterator
     *
     * @param it Iterator of iterators of Integers
     * @return Iterator of Integers
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer>  currentInternalIterator = it.next();
            @Override
            public boolean hasNext() {
                boolean result = true;
                if (!currentInternalIterator.hasNext()) {
                    result = false;
                    while (it.hasNext()) {
                        currentInternalIterator = it.next();
                        if (currentInternalIterator.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!currentInternalIterator.hasNext() && !it.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (!currentInternalIterator.hasNext()) {
                    currentInternalIterator = it.next();
                }
                return currentInternalIterator.next();
            }
        };
    }
}