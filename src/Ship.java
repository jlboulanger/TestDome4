import java.util.function.Function;
import java.util.stream.IntStream;

public class Ship {
    int[] containers;

    public Ship(int containerCount, Function<Integer, Integer> fillContainer) {
       // this.containers = new Hashtable<Integer, Integer>(containerCount);
        containers = IntStream.range(0, containerCount).map(i -> fillContainer.apply(i)).toArray();

        /*for (int i = 0; i < containerCount; i++) {
            this.containers.put(i, fillContainer.apply(i));
        }*/
    }

    public int peekContainer(int containerIndex) {
        if(containerIndex < containers.length) {
            return this.containers[containerIndex];
        }        else return 0;
    }

    public static void main(String[] args) {
        Ship ship = new Ship(10, containerIndex -> containerIndex);

        for (int i = 0; i < 5000; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }
}
