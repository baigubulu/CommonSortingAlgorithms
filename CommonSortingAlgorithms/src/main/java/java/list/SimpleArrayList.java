package java.list;

import java.io.Serializable;
import java.util.Arrays;
import java.util.RandomAccess;

/**
 * 手动实现一个ArrayList
 * https://www.cnblogs.com/qifengshi/p/6377614.html
 * 主要的几个函数：
 * 1. add
 * 2. explicitCapacity: 扩容相关的操作
 * 3. isCapacityEnough： 容量是否足够，如果足够则不需要扩容，如果不够的话，则需要扩容
 */
public class SimpleArrayList<E> implements RandomAccess,Cloneable,Serializable {

    private final static int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private final static int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    private Object[] elementData;

    public SimpleArrayList() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    public SimpleArrayList(int size) throws Exception {
        if (size < 0) {
            throw new Exception("默认的大小" + size);
        } else {
            elementData = new Object[size];
        }
    }

    public void add(E e) {
        isCapacityEnough(size + 1);
        elementData[size++] = e;
    }

    /**
     * 在指定位置插入数据
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkRangeForAdd(index);
        isCapacityEnough(size + 1);
        // 完成数据的拷贝功能
        System.arraycopy(elementData, index, elementData,index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    private void isCapacityEnough(int size) {
        // 从新申请空间，进行扩容操作
        if (size > DEFAULT_CAPACITY) {
            explicitCapacity(size);
        }
        if (size < 0) {
            throw new OutOfMemoryError();
        }
    }

    /**
     * 这个函数里面的判断至关重要的
     * @param capacity
     */
    private void explicitCapacity(int capacity) {
        int newLength = elementData.length * 2;
        if (newLength - capacity < 0) {
            newLength = capacity;
        }
        if (newLength > MAX_ARRAY_LENGTH) {
            newLength = (capacity > MAX_ARRAY_LENGTH ? Integer.MAX_VALUE : MAX_ARRAY_LENGTH);
        }
        elementData = Arrays.copyOf(elementData, newLength);
    }

    public E get(int index) {
        checkoutRange(index);
        return (E) elementData[index];
    }

    public int indexOf(Object object) {
        if (object != null) {
            for (int i = 0; i < size; i++) {
                if (object.equals(elementData[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object o){
        return indexOf(0) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E remove(int index) {
        E value = get(index);
        int moveSize = size - index -1;
        if (moveSize > 0) {
            // 因为删除一个，所以需要减1；
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        }
        // 将原来的最后一个位置置空
        elementData[--size] = null;
        return value;
    }

    public boolean remove(Object o) {
        if (contains(o)) {
            remove(indexOf(o));
            return true;
        } else {
            return false;
        }
    }

    private void checkRangeForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("指定的index超过界限");
        }
    }

    private void checkoutRange(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("指定的index超过了界限");
        }
    }
}
