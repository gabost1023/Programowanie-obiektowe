import static java.util.Collections.swap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        House house = new House(10,"zielony",5);
        System.out.println(house.getHeight());
        System.out.println();

        Storage<Integer> number = new Storage<>();
        Storage<Integer> number1 = new Storage<>();
        Storage<Integer> number2 = new Storage<>();
        Storage<Integer> number3 = new Storage<>();
        Storage<Integer> number4 = new Storage<>();

        Integer[] numbers = {5,10,20,3,1,1,1,10};
        sortDescending(numbers);
        printArray(numbers);
    }

    public static <T extends Comparable<T>> void sortDescending(T[] array){
        if (array.length == 0) return;

        T temp = null;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j+1]) < 0) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static <T> void printArray (T[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }
}

class Building{
    private int height;
    private String color;

    public Building(int height, String color){
        setHeight(height);
        setColor(color);
    }
    public int getHeight(){
        return height;
    }
    public String getColor(){
        return color;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setColor(String color){
        this.color = color;
    }
}

class House extends Building{
    private int numberOfRooms;

    public House(int height, String color, int numberOfRooms){
        super(height,color);
        setNumberOfRooms(numberOfRooms);
    }
    public int getNumberOfRooms(){
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms){
        this.numberOfRooms = numberOfRooms;
    }
}

abstract class ComputerGraphic{
    private int width;
    private int height;
    private String fileName;

    public ComputerGraphic(int width, int height, String fileName){
        this.width = width;
        this.height = height;
        this.fileName = fileName;
    }
    public abstract void loadFile();
    public abstract void saveFile();
}

class Bitmap extends ComputerGraphic{
    public Bitmap(int width, int height, String fileName){
        super(width, height, fileName);
    }

    @Override
    public void loadFile(){
        System.out.println("Bitmap loaded");
    }

    @Override
    public void saveFile(){
        System.out.println("Bitmap saved");
    }
}

class Vector extends ComputerGraphic{
    public Vector(int width, int height, String fileName){
        super(width, height, fileName);
    }

    @Override
    public void loadFile(){
        System.out.println("Vector loaded");
    }

    @Override
    public void saveFile(){
        System.out.println("Vector saved");
    }
}

interface MediaPlayer{
    void play(String trackName);
    void pause();
    String getCurrentTrack();
}

class AudioPlayer implements MediaPlayer{

    @Override
    public void play(String trackName) {
        System.out.println("Your track is playing");
    }

    @Override
    public void pause() {
        System.out.println("Your track is paused");
    }

    @Override
    public String getCurrentTrack() {
        return "Track 1";
    }
}

class VideoPlayer implements MediaPlayer{

    @Override
    public void play(String trackName) {
        System.out.println("Your video is playing");
    }

    @Override
    public void pause() {
        System.out.println("Your video is paused");
    }

    @Override
    public String getCurrentTrack() {
        return "Video 1";
    }
}

class Storage <T>{
    T item;
    public void store(T item){
        this.item = item;
    }
    public T retrieve(){
        return item;
    }
}

interface Authentication{
    boolean login(String username, String password);
    void  logout();
    boolean resetPassword(String username, String oldPassword, String newPassword);
}

class UserAuthentication implements Authentication{

    @Override
    public boolean login(String username, String password) {
        if (username.length() > 3 || password.length() > 5) return true;
        else return false;
    }
    @Override
    public void logout() {
        System.out.println("You have logged out");
    }
    @Override
    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if(oldPassword.trim() != newPassword.trim()) return true;
        else return false;
    }
}

class AdminAuthentication implements Authentication{

    @Override
    public boolean login(String username, String password) {
        if (username.length() > 3 || password.length() > 5) return true;
        else return false;
    }
    @Override
    public void logout() {
        System.out.println("You have logged out");
    }
    @Override
    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if(oldPassword.trim() != newPassword.trim()) return true;
        else return false;
    }
}
