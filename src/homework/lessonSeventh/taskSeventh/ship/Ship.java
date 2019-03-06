package homework.lessonSeventh.taskSeventh.ship;

public class Ship implements Runnable {
    private String shipName;
    private int box = 10;

    public Ship(String shipName) {
        this.shipName = shipName;
    }

    @Override
    public void run() {
        while (box > 0) {
            box = box - 1;
            System.out.println("Ship " + shipName + " has unloaded box. " + box + " boxes left.");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ship " + shipName + " finished unloading. \n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (box != ship.box) return false;
        return shipName.equals(ship.shipName);
    }

    @Override
    public int hashCode() {
        int result = shipName.hashCode();
        result = 31 * result + box;
        return result;
    }
}
