package ru.job4j.generic;

import java.util.NoSuchElementException;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    SimpleArray<T> array;

    public AbstractStore(final int size) {
        array = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) throws ArrayIndexOutOfBoundsException {
        int index = getIndexById(id);
        if (index != -1) {
            this.array.set(index, model);
        }
        return index != -1;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndexById(id);
        if (index != -1) {
            this.array.remove(getIndexById(id));
        }
        return index != -1;
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return this.array.get(index);
    }



    private int getIndexById(String id) {
        int index = 0;
        boolean exist = false;
        for (T model : array) {
            if (model.getId().equals(id)) {
                exist = true;
                break;
            }
            index++;
        }
        if (!exist) {
            index = -1;
        }
        return index;
    }
}
