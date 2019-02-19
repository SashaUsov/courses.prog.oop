package homework.lessonTwo.task;

import java.math.BigDecimal;

public class Board {

    private Shape[] board = new Shape[4];

    public Board(Shape[] board) {
        this.board = board;
    }

    public Board() {
    }

    public boolean insertShape(Shape shape) {

        for (int i = 0; i < board.length; i++) {

            if (board[i] == null) {

            board[i] = shape;

            return true;

            }
        }

        return false;
    }

    public boolean removeShape(int i) {

        if (board[i - 1] != null) {

            board[i - 1] = null;

            return true;
        }

        return false;

    }

    public String getShapeInfo() {

        StringBuilder info = new StringBuilder("");

        for (int i = 0; i < board.length; i++) {

            info.append(board[i] != null ? "On plot number " + (i + 1) + " is a shape: " + board[i].toString() + ".\n":
                    "There is no shape on plot number " + (i + 1) + ".\n");
        }

        return info.toString();
    }

    public String getTheTotalArea() {

        double totalArea = 0;

        for (Shape partOfTheBoard : board) {

            if (partOfTheBoard != null) {

                totalArea = totalArea + partOfTheBoard.getArea();
            }
        }

        totalArea = new BigDecimal(totalArea)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return "The total area of the shapes on the board is " + totalArea + " square meters.";
    }

    public String getTheTotalPerimetr() {

        double totalPerimetr = 0;

        for (Shape partOfTheBoard : board) {

            if (partOfTheBoard != null) {

                totalPerimetr = totalPerimetr + partOfTheBoard.getPerimetr();
            }
        }

        totalPerimetr = new BigDecimal(totalPerimetr)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return "The total perimetr of the shapes on the board is " + totalPerimetr + " meters.";
    }
}
