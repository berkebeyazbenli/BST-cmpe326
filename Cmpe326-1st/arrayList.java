public class arrayList<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public arrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public arrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            ensureCapacity(size * 2);
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int size() {
        return size;
    }

}
