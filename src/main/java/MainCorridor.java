public class MainCorridor extends Corridor {

    public MainCorridor(String light, String airConditioner, int corridorNumber) {
        super(light, airConditioner, corridorNumber);
    }

    public void mainCorridorElectricEquipmentStatus(){
        System.out.println("\tMain corridor " + corridorNumber);
        super.corridorElectricEquipmentStatus();
    }
}
