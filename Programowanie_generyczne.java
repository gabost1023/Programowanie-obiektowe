import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Box<String> box1 = new Box<>("slowo");
        Box<String> box2 = new Box<>("slowo2");
        Box<Integer> box3 = new Box<>(10);
        Box<Double> box4 = new Box<>(3.14);
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strings = {"one", "two", "three", "four", "five", "six"};

        Counter counter = new Counter();
        counter.add(box1);
        counter.add(box2);
//         System.out.println(counter.count());
        Triple triple = new Triple<>(box1, box4, box3);
        System.out.println(triple.getFirst() +  " " + triple.getSecond() + " " + triple.getThird());

        System.out.println(max(numbers));
        System.out.println(printArray(numbers));
        System.out.println(printArray(strings));

        Pair pair = new Pair<>(box1, box4);
        System.out.println(pair.getFirst() +  " " + pair.getSecond());

        swap(numbers, 2, 4);
        System.out.println(printArray(numbers));
        reverseArray(numbers);
        System.out.println(printArray(numbers));
        System.out.println(minValue(numbers));

        Person person1 = new Person("Adam", 15);
        Person person2 = new Person("Lucjan", 20);
        Person[] persons = {person1, person2};
        System.out.println(minValue(persons));

        Book book1 = new Book("Portret Doriana Graya", "Oscar Wilde");
        Book book2 = new Book ("Upadek", "Albert Camus");
        Book book3 = new Book("7 mezow Evelyn Hugo", "na");
        Book[] books = {book1, book2, book3};
        System.out.println(minValue(books));
        print__Array(books);
        System.out.println(sumElements(numbers));
        System.out.println(compareElements(book1, book2));

        printObjectinfo(book1);

        Dog dog1 = new Dog("Burek", 10,10);
        Dog dog2 = new Dog("Reksio", 8,8);
        Dog dog3 = new Dog("Reks", 12,12);
        Dog[] dogs = {dog1, dog2};
        findMax(dog1, dog2);

        Car car1 = new Car("Toyota", 1998);
        Car car2 = new Car("Nissan", 2005);
        System.out.println(compareObjects(car1, car2));

        Pair<Animal> pair1 = new Pair<>(dog1,dog2);
        System.out.println(findMax(pair1));

        PairDogs<Dog> pairDogs = new PairDogs<>(dog1, dog2);

        Eagle eagle1 = new Eagle("eagle1");
        Eagle eagle2 = new Eagle("eagle222");
        Triple1<Eagle> triple1 = new Triple1<>(eagle2,eagle1,eagle2);
        System.out.println(findMin(triple1));
        findMinMaxAge(dogs, pairDogs);
        System.out.println(pairDogs.getFirst().toString());
        System.out.println(pairDogs.getSecond().toString());

    }
    public static <T> boolean isEqual (T obj1, T obj2)
    {
        return obj1 == obj2;
    }
    public static <T extends Comparable<T>> T max(T[] array){
        if (array.length == 0) return null;
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) max = array[i];
        }
        return max;
    }

    public static <T> String printArray (T[] array){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i].toString()).append(" ");
        }
        return sb.toString();
    }

    public static <T> void swap (T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void reverseArray (T[] array){
        if (array.length == 0) return;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    public static <T extends Comparable<T>> T minValue(T[] array){
        if (array.length == 0) return null;
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) min = array[i];
        }
        return min;
    }

    public static <T extends Comparable<T>> T sortAndReturnFirst(T[] array){
        if (array.length == 0) return null;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-1; j++) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    swap(array, j, j-1);
                }
            }
        }
        return array[0];
    }

    public static <T> void print__Array(T[] array) {
        if (array == null) {
            System.out.println("Tablica jest null.");
            return;
        }

        for (T element : array) {
            System.out.print(element + " ");
        }
    }

    public static <T extends Number> double sumElements (T[] array) {
        if (array.length == 0) return 0;
        double sum = 0.0;
        for (int i = 1; i < array.length; i++) {
            sum += array[i].doubleValue();
        }
        return sum;
    }

    public static <T extends Comparable<T>> boolean compareElements (T obj1, T obj2) {
        return obj1.compareTo(obj2) == 0;
    }

    public static <T extends Object> void printObjectinfo (T obj){
        if (obj == null) return;

        System.out.println("Klasa obiektu: " + obj.getClass().getName());
        System.out.println("Hashcode" + obj.hashCode());
        System.out.println("ToString" + obj.toString());
    }

    public static <T extends Animal> T findMax (T obj1, T obj2) {
        if (obj1.compareTo(obj2) > 0) {
            System.out.println(obj1.toString());
            return obj1;
        }
        else {
            System.out.println(obj2.toString());
            return obj2;
        }
    }

    public static <T extends Car> boolean compareObjects (T obj1, T obj2) {
        if(obj1.getClass().equals(obj2.getClass())){
            return true;
        }
        else return false;
    }

    public static <T extends Animal> T findMax (Pair<? extends T> pair){
        T first = pair.getFirst();
        T second = pair.getSecond();

        if (first.compareTo(second) < 0) {
            return second;
        }
        else {
            return first;
        }
    }

    public static <T extends Bird> T findMin (Triple1<? extends T> triple){
        T a = triple.getFirst();
        T b = triple.getSecond();
        T c = triple.getThird();

        T min = a;

        if (a.compareTo(b) < 0) {
            if (a.compareTo(c) < 0) {
                min = a;
            }
        }
        else if (b.compareTo(c) < 0) {
            if (b.compareTo(a) < 0) {
                min = b;
            }
        }
        else {
            min = c;
        }
        return min;
    }

    public static void findMinMaxAge (Dog[] array, PairDogs<?super Dog> result){
        Dog min = array[0];
        Dog max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i].getWiek() < min.getWiek()) min = array[i];
            if (array[i].getWiek() > max.getWiek()) max = array[i];
        }

        result.setFirst(max);
        result.setSecond(min);
        System.out.println("Max: " + max.getWiek() + ", Min: " + min.getWiek());
    }
}

class Box<T>{
    T object;

    public Box(T object){
        setObject(object);
    }
    public void setObject(T object){
        this.object = object;
    }
    public T getObject(){
        return object;
    }
}

class Counter<T>{
    List<T> list;
    public Counter(){
        list = new ArrayList<T>();
    }
    public void add(T object){
        list.add(object);
    }
    public int count(){
        return list.size();
    }
}

class Triple<T, U, V>{
    T first;
    U second;
    V third;

    public Triple(T first, U second, V third){
        setFirst(first);
        setSecond(second);
        setThird(third);
    }

    public void setFirst(T first) {
        this.first = first;
    }
    public T getFirst() {
        return first;
    }
    public void setSecond(U second) {
        this.second = second;
    }
    public U getSecond() {
        return second;
    }
    public void setThird(V third) {
        this.third = third;
    }
    public V getThird() {
        return third;
    }
}

interface Stack <T>{
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}

class Stack1<T> implements Stack<T>{
    private List<T> stack;

    public Stack1(){
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        return stack.remove(stack.size()-1);
    }

    @Override
    public T peek() {
        return stack.get(stack.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class Storage <T> {
    T object;

    public Storage(T object){
        this.object = object;
    }

    public void store(T object){
        this.object = object;
    }

    public T retrieve(){
        return object;
    }
}

class Pair <T> {
    T first;
    T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }
}

class GenericQueue <T> {
    private LinkedList<T> queue;
    private T element;

    public GenericQueue(){
        queue = new LinkedList<>();
    }

    public void enqueue(T element){
        queue.addLast(element);
    }
    public T dequeue(){
        queue.removeFirst();
        return queue.getFirst();
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {

        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class Book implements Comparable<Book>{
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.title.length(), other.title.length());
    }

    @Override
    public String toString() {
        return title + " " + author;
    }
}

class Animal implements Comparable<Animal>{
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class Dog extends Animal{
    private int wiek;
    public Dog(String name, int age, int wiek){
        super(name, age);
        this.wiek = wiek;
    }
    public int getWiek() {
        return wiek;
    }
}

class Car{
    private String model;
    private int year;

    public Car(String model, int year){
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return model + " " + year;
    }
}

class ElectricCar extends Car{
    public ElectricCar(String name, int year){
        super(name,year);
    }
}

class Pair1 <T>{
    private T first;
    private T second;

    public Pair1(T first, T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }
    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(T second){
        this.second = second;
    }
}

class Triple1 <T>{
    private T first;
    private T second;
    private T third;

    public Triple1(T first, T second, T third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }
    public T getThird(){
        return third;
    }
    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(T second){
        this.second = second;
    }
    public void setThird(T third){
        this.third = third;
    }
}

class Bird implements Comparable<Bird>{
    private String name;

    public Bird(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Bird bird) {
        return Integer.compare(this.name.length(), bird.name.length());
    }

    @Override
    public String toString() {
        return name;
    }
}

class Eagle extends Bird{
    public Eagle(String name){
        super(name);
    }
}

class PairDogs <T> {
    T first;
    T second;

    public PairDogs(T first, T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }
    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(T second){
        this.second = second;
    }
}




