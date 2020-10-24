import java.util.LinkedList;

public class TrainComposition {
    LinkedList<Integer>  trains = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        trains.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        trains.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        Integer wid = trains.pollFirst();
        return wid == null ? 0 :wid.intValue();
    }

    public int detachWagonFromRight() {
        Integer wid = trains.pollLast();
        return wid == null ? 0 :wid.intValue();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
