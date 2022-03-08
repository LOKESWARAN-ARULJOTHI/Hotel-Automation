import java.util.ArrayList;

public class Floor {
    private final int floorNumber;
    private int numberOfMainCorridors;
    private int numberOfSubCorridors;
    public final ArrayList<MainCorridor> mainCorridors;
    public final ArrayList<SubCorridor> subCorridors;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.numberOfMainCorridors = 0;
        this.numberOfSubCorridors = 0;
        this.mainCorridors = new ArrayList<>();
        this.subCorridors = new ArrayList<>();
        mainCorridors.add(new MainCorridor("ON", "ON", 0));
        subCorridors.add( new SubCorridor("OFF", "ON", 0));
    }

    public void createMainCorridor(int numberOfMainCorridor) {
        for (int i = 0; i < numberOfMainCorridor; i++) {
            numberOfMainCorridors++;
            MainCorridor mainCorridor =  new MainCorridor("ON", "ON", numberOfMainCorridors);
            mainCorridors.add(mainCorridor);
        }
    }

    public void createSubCorridor(int numberOfSubCorridor) {
        for (int i = 0; i < numberOfSubCorridor; i++) {
            numberOfSubCorridors++;
            SubCorridor subCorridor = new SubCorridor("OFF", "ON", numberOfSubCorridors);
            subCorridors.add(subCorridor);
        }
    }

    public void floorEquipmentStatus() {
        System.out.println("Floor " + floorNumber);
        for (int i = 1; i <= numberOfMainCorridors; i++) {
            mainCorridors.get(i).mainCorridorElectricEquipmentStatus();
        }
        for (int i = 1; i <= numberOfSubCorridors; i++) {
            subCorridors.get(i).subCorridorElectricEquipmentStatus();
        }
    }

    public void printCorridorCount() {
        System.out.println("Number Of Main Corridors: "+ numberOfMainCorridors);
        System.out.println("Number Of Sub Corridors: "+ numberOfSubCorridors +"\n");
    }

    public void motionDetector(int subCorridorNumber, boolean motion) {
        if(subCorridorNumber<=numberOfSubCorridors ){
            if (motion){
                for (int i = 1; i <= numberOfSubCorridors; i++) {
                    if (i != subCorridorNumber) {
                        subCorridors.get(i).airConditioner = "OFF";
                    }
                    else
                        subCorridors.get(i).light = "ON";
                }
            } else {
                for (int i = 1; i <= numberOfSubCorridors; i++) {
                    if (i != subCorridorNumber) {
                        subCorridors.get(i).airConditioner = "ON";
                    } else
                        subCorridors.get(i).light = "OFF";
                }
            }
        }
    }
}
