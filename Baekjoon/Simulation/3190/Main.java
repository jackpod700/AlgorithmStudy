import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int [][] direction= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int d=0; // snakes's current direction: 0: right, 1: down, 2: left, 3: up
    static int N; // size of the map

    public static void turnRight() {
        d = (d + 1) & 3;
    }

    public static void turnLeft() {
        d = (d + 3) & 3;
    }

    public static void moveSnake(ArrayList<int[]> snake, int[][] map) {
        int[] head = snake.get(0);
        int newX = head[0] + direction[d][0];
        int newY = head[1] + direction[d][1];

        // Check if the new position is within bounds and not colliding with the snake
        if (newX < 0 || newY < 0 || newX >= N || newY >= N || isColliding(snake, newX, newY)) {
            throw new RuntimeException("Snake has crashed!");
        }

        // Add the new head position to the snake
        snake.add(0, new int[]{newX, newY});

        // If there's no apple at the new position, remove the tail
        if (map[newX][newY] == 0) {
            snake.remove(snake.size() - 1);
        } else {
            map[newX][newY] = 0; // consume apple
        }
    }

    private static boolean isColliding(ArrayList<int[]> snake, int newX, int newY) {
        for (int[] segment : snake) {
            if (segment[0] == newX && segment[1] == newY) {
                return true; // Collision detected
            }
        }
        return false; // No collision
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int appleNum = Integer.parseInt(st.nextToken());

        int [][]map = new int[N][N];
        for (int i = 0; i < appleNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1; // place apple
        }

        st = new StringTokenizer(br.readLine());
        int turnNum = Integer.parseInt(st.nextToken());
        int []turns = new int[turnNum];
        char []turnDirections = new char[turnNum];
        for (int i = 0; i < turnNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            turns[i] = Integer.parseInt(st.nextToken());
            turnDirections[i] = st.nextToken().charAt(0);
        }

        ArrayList<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0}); // initial position of the snake

        int turnIndex = 0; // index for turns
        int time = 0;
        while(true){
            time++;
            try {
                // Move the snake
                moveSnake(snake, map);

                // Check for turns
                if (turnIndex<turnNum && time == turns[turnIndex]) {
                    if (turnDirections[turnIndex] == 'D') {
                        turnRight();
                    } else if (turnDirections[turnIndex] == 'L') {
                        turnLeft();
                    }
                    turnIndex++;
                }

            } catch (RuntimeException e) {
                System.out.println(time);
                break; // Snake has crashed, exit the loop
            }
        }
    }
}
