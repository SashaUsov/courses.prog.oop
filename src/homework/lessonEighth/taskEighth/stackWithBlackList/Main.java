package homework.lessonEighth.taskEighth.stackWithBlackList;


import homework.lessonEighth.taskEighth.stackWithBlackList.entity.*;
import homework.lessonEighth.taskEighth.stackWithBlackList.exc.BlackListOverflowException;
import homework.lessonEighth.taskEighth.stackWithBlackList.exc.MyStackOverflowException;
import homework.lessonEighth.taskEighth.stackWithBlackList.exc.ObjectMismatchException;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 2);
        Dog dog = new Dog("Rex", 3);

        /*
        * Create a blacklist and put the class Cat in it
        * */
        BlackList blackList = new BlackList();
        try {
            blackList.addToBlackList(cat);
        } catch (BlackListOverflowException e) {
            System.out.println(e.getMessage());
        }

        Birdie birdie = new Birdie("Twitty", 1);
        Hamster hamster = new Hamster("Hams", 2);
        Mouse mouse = new Mouse("Jerry", 3);
        Squirrel squirrel = new Squirrel("Tintin", 2);

        /*
        * Create a stack and place two objects of the Birdie and Mouse class into it.
        * Mouse class object lies on top of the stack
        * */
        MyStack stack = new MyStack(blackList);

        try {
            stack.add(birdie);
            stack.add(mouse);
        } catch (MyStackOverflowException | ObjectMismatchException e) {
            System.out.println(e.getMessage());
        }

        /*
        * Get the object from the top of the stack without deleting. Expected result: Mouse class object
        * */
        System.out.println(stack.peek() + "\n");
        /*
        * Get the object from the top of the stack with the removal of the object. Expected result: same object of class Mouse.
        * */
        System.out.println(stack.pool() + "\n");
        /*
        * Get the object from the top of the stack without deleting the object. Expected result Birdie class object
        * */
        System.out.println(stack.peek() + "\n");

        /*
        * Put two objects of Hamster and Squirrel class on the stack.
        * Squirrel class object lies on top of the stack
        * */
        try {
            stack.add(hamster);
            stack.add(squirrel);
        } catch (MyStackOverflowException | ObjectMismatchException e) {
            e.printStackTrace();
        }
        /*
        * Get the object from the top of the stack with the removal of the object. Expected result: same object of class Squirrel.
        * */
        System.out.println(stack.pool() + "\n");
        /*
        * Get the object from the top of the stack without deleting the object. Expected result Hamster class object
        * */
        System.out.println(stack.peek() + "\n");

        /*
        * Put a Cat object on the stack. Expected result ObjectMismatchException
        * */
        try {
            stack.add(cat);
        } catch (MyStackOverflowException | ObjectMismatchException e) {
            System.out.println(e.getMessage() + "\n");
        }

        /*
        * We put the class Dog in the black list
        * */
        try {
            blackList.addToBlackList(dog);
        } catch (BlackListOverflowException e) {
            System.out.println(e.getMessage() + "\n");
        }

        /*
        * Put a Dog object on the stack. Expected result ObjectMismatchException
        * */
        try {
            stack.add(dog);
        } catch (MyStackOverflowException | ObjectMismatchException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
}
