import java.util.Scanner;

public class Chandrayaan3Controller {
    // Default position (x, y, z)
    private int[] currentPosition = new int[3];
    // Default direction (N, S, E, W, U, D)
    private char currentDirection;

    public Chandrayaan3Controller(int x, int y, int z, char direction) {
        currentPosition[0] = x;
        currentPosition[1] = y;
        currentPosition[2] = z;
        currentDirection = direction;
    }

    //move the chandrayan3 forward or backward
    public void move(char command) {
        switch (command) {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            default:
                System.out.println("Invalid command for movement: " + command);
        }
    }

    // move the chandrayan3 left or right
    public void turn(char command) {
        switch (command) {
            case 'l':
                turnLeft();
                break;
            case 'r':
                turnRight();
                break;
            default:
                System.out.println("Invalid command for turning: " + command);
        }
    }

    // move the chandrayan3 up or down
    public void changeAngle(char command) {
        switch (command) {
            case 'u':
                turnUp();
                break;
            case 'd':
                turnDown();
                break;
            default:
                System.out.println("Invalid command for changing angle: " + command);
        }
    }

    // move the chandrayan3 forward based on current direction
    private void moveForward() {
        switch (currentDirection) {
            case 'N':
                currentPosition[1]++;
                break;
            case 'S':
                currentPosition[1]--;
                break;
            case 'E':
                currentPosition[0]++;
                break;
            case 'W':
                currentPosition[0]--;
                break;
            case 'U':
                currentPosition[2]++;
                break;
            case 'D':
                currentPosition[2]--;
                break;
        }
    }

    //  move backward based on current direction
    private void moveBackward() {
        switch (currentDirection) {
            case 'N':
                currentPosition[1]--;
                break;
            case 'S':
                currentPosition[1]++;
                break;
            case 'E':
                currentPosition[0]--;
                break;
            case 'W':
                currentPosition[0]++;
                break;
            case 'U':
                currentPosition[2]--;
                break;
            case 'D':
                currentPosition[2]++;
                break;
        }
    }

    // move the chandrayan3 to turn left
    private void turnLeft() {
        switch (currentDirection) {
            case 'N':
                currentDirection = 'W';
                break;
            case 'S':
                currentDirection = 'E';
                break;
            case 'E':
                currentDirection = 'N';
                break;
            case 'W':
                currentDirection = 'S';
                break;
            default:
                System.out.println("Cannot turn left from this angle: " + currentDirection);
        }
    }

    // move the chandrayan3 turn right
    private void turnRight() {
        switch (currentDirection) {
            case 'N':
                currentDirection = 'E';
                break;
            case 'S':
                currentDirection = 'W';
                break;
            case 'E':
                currentDirection = 'S';
                break;
            case 'W':
                currentDirection = 'N';
                break;
            default:
                System.out.println("Cannot turn right from this angle: " + currentDirection);
        }
    }

    // move the chandrayan3 turn up
    private void turnUp() {
        if (currentDirection == 'N' || currentDirection == 'S' || currentDirection == 'E' || currentDirection == 'W') {
            currentDirection = 'U';
        } else {
            System.out.println("Cannot turn up from this angle: " + currentDirection);
        }
    }

    // move the chandrayan3 turn down
    private void turnDown() {
        if (currentDirection == 'N' || currentDirection == 'S' || currentDirection == 'E' || currentDirection == 'W') {
            currentDirection = 'D';
        } else {
            System.out.println("Cannot turn down from this angle: " + currentDirection);
        }
    }

    // check current position of the chandrayan3
    public int[] getCurrentPosition() {
        return currentPosition;
    }

    // check current direction of the chandrayan3
    public char getCurrentDirection() {
        return currentDirection;
    }

    public static void main(String[] args) {
        Chandrayaan3Controller controller = new Chandrayaan3Controller(0, 0, 0, 'N');
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Position.. N " );
        System.out.println("Initial Direction.. 0,0,0 " );

        while (true) {
            System.out.println("Enter command (f/b/l/r/u/d) or 'q' to quit:");
            String command = scanner.nextLine();

            if (command.equals("q")) {
                System.out.println("Exit program.");
                break;
            }

            switch (command) {
                case "f":
                case "b":
                    controller.move(command.charAt(0));
                    break;
                case "l":
                case "r":
                    controller.turn(command.charAt(0));
                    break;
                case "u":
                case "d":
                    controller.changeAngle(command.charAt(0));
                    break;
                default:
                    System.out.println("Invalid command.");
                    continue;
            }

            System.out.println("Current position: " + controller.getCurrentPosition()[0] + ", " +
                    controller.getCurrentPosition()[1] + ", " + controller.getCurrentPosition()[2]);
            System.out.println("Current direction: " + controller.getCurrentDirection());
        }

        scanner.close();
    }
}
