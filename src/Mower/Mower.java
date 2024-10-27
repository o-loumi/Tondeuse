package Mower;



public class Mower {
    private int x;
    private int y;
    private char direction;
    private final int maxX;
    private final int maxY;

    // Directions correspondantes pour N, E, S, W
    private static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};
    private static final int[][] MOVEMENTS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N, E, S, W

    public Mower(int x, int y, char direction, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void executeInstructions(String instructions) {
        for (char command : instructions.toCharArray()) {
            switch (command) {
                case 'G':
                    turnLeft();
                    break;
                case 'D':
                    turnRight();
                    break;
                case 'A':
                    moveForward();
                    break;
            }
        }
    }

    private void turnLeft() {
        int index = (indexOfDirection(direction) + 3) % 4; // Tourner à gauche
        direction = DIRECTIONS[index];
    }

    private void turnRight() {
        int index = (indexOfDirection(direction) + 1) % 4; // Tourner à droite
        direction = DIRECTIONS[index];
    }

    private void moveForward() {
        int index = indexOfDirection(direction);
        int newX = x + MOVEMENTS[index][0];
        int newY = y + MOVEMENTS[index][1];

        // Vérifier si le nouveau position est dans les limites
        if (newX >= 0 && newX <= maxX && newY >= 0 && newY <= maxY) {
            x = newX;
            y = newY;
        }
    }

    private int indexOfDirection(char direction) {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (DIRECTIONS[i] == direction) {
                return i;
            }
        }
        return -1; // Direction invalide
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
