import java.util.ArrayList;

public class Hotel {
    private int numberOfFloors;
    private final ArrayList<Floor> floors;

    public Hotel() {
        this.numberOfFloors = 0;
        this.floors = new ArrayList<>();
        floors.add(new Floor(0));
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
        numberOfFloors++;
    }

    public void electricityStatus() {
        System.out.println("Number Of Floors: " + numberOfFloors);
        floors.get(1).printCorridorCount();
        for (int i = 1; i <= numberOfFloors; i++) {
            floors.get(i).floorEquipmentStatus();
        }
    }
}
