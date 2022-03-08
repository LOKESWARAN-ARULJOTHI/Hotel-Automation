public class SubCorridor extends Corridor {

    public SubCorridor(String light, String airConditioner, int corridorNumber) {
        super(light, airConditioner, corridorNumber);
    }

    public void subCorridorElectricEquipmentStatus() {
        System.out.println("\tSub corridor " + corridorNumber);
        super.corridorElectricEquipmentStatus();
    }
}
