package homework.lessonNinth.taskFour;

import homework.lessonNinth.taskFour.CharactersOfTheBigBangTheory.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Kutrapali kutrapali = new Kutrapali();
        Leonard leonard = new Leonard();
        Penny penny = new Penny();
        Sheldon sheldon = new Sheldon();
        Wolowitz wolowitz = new Wolowitz();

        Deque<Personage> personageDeque = new ArrayDeque<>();

        personageDeque.addFirst(penny);
        personageDeque.addFirst(kutrapali);
        personageDeque.addFirst(wolowitz);
        personageDeque.addFirst(leonard);
        personageDeque.addFirst(sheldon);

        System.out.println(personageDeque);

        ColaMachine colaMachine = new ColaMachine(personageDeque);

        colaMachine.giveCola(14);


    }
}
