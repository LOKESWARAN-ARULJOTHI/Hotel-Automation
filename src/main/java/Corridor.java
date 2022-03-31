public class Corridor {
    protected final int corridorNumber;
    protected String airConditioner;
    protected String light;
    
    public Corridor(String light, String airConditioner, int corridorNumber) {
        this.light = light;
        this.airConditioner = airConditioner;
        this.corridorNumber = corridorNumber;
    }

    public void corridorElectricEquipmentStatus(){
        System.out.println("\t\tLight "+ corridorNumber + " : " + light + "\n\t\t" +
                           "AC "+ corridorNumber + " : " + airConditioner + "\n");
    }

}
