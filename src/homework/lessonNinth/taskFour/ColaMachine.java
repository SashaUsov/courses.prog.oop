package homework.lessonNinth.taskFour;

import homework.lessonNinth.taskFour.CharactersOfTheBigBangTheory.Personage;

import java.util.Deque;

public class ColaMachine {
    private Deque<Personage> queue;

    public ColaMachine(Deque<Personage> queue) {
        this.queue = queue;
    }

    public void giveCola(int glasses) {

        for (int i = 0; i <= glasses; i++) {
            Personage personage = queue.poll();
            queue.add(personage);
            queue.add(personage);
        }
        System.out.println(queue);
    }


    @Override
    public String toString() {
        return "ColaMachine{" +
                "queue=" + queue +
                '}';
    }
}
