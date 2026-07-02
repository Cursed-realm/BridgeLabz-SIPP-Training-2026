import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class GenericStack<T> {
    private List<T> elements;

    public GenericStack() {
        elements = new ArrayList<T>();
    }

    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item");
        }
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

class Repository<T> {
    private List<T> entities;

    public Repository() {
        entities = new ArrayList<T>();
    }

    public void add(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Cannot add null entity");
        }
        entities.add(entity);
    }

    public T getById(int index) {
        if (index < 0 || index >= entities.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return entities.get(index);
    }

    public boolean remove(T entity) {
        return entities.remove(entity);
    }

    public List<T> getAll() {
        return entities;
    }

    public int count() {
        return entities.size();
    }
}

public class GenericsBasicsDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printAll(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> studentAge = new Pair<String, Integer>("Aditya", 21);
        System.out.println(studentAge);

        GenericStack<Integer> intStack = new GenericStack<Integer>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Stack size: " + intStack.size());

        Integer[] numbers = {45, 12, 89, 33, 67};
        System.out.println("Max number: " + findMax(numbers));

        String[] names = {"Zara", "Aditya", "Manav", "Bhavya"};
        System.out.println("Max name: " + findMax(names));

        Repository<String> nameRepository = new Repository<String>();
        nameRepository.add("Aditya");
        nameRepository.add("Rohit");
        nameRepository.add("Simran");
        System.out.println("Repository count: " + nameRepository.count());
        System.out.println("Item at 1: " + nameRepository.getById(1));

        List<Integer> scores = new ArrayList<Integer>();
        scores.add(90);
        scores.add(85);
        scores.add(78);
        printAll(scores);
    }
}
