import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HotelTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Test
    void shouldBeInDefaultStateWhenNoMotionIsDetectedByTheSensorInTheSubCorridors() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Hotel hotel = new Hotel();
        Floor floorOne = new Floor(1);
        Floor floorTwo = new Floor(2);

        floorOne.createMainCorridor(1);
        floorOne.createSubCorridor(2);
        floorTwo.createMainCorridor(1);
        floorTwo.createSubCorridor(2);
        hotel.addFloor(floorOne);
        hotel.addFloor(floorTwo);

        hotel.electricityStatus();

        String expected = """
                Number Of Floors: 2
                Number Of Main Corridors: 1
                Number Of Sub Corridors: 2
                
                Floor 1
                \tMain corridor 1
                \t\tLight 1 : ON
                \t\tAC 1 : ON

                \tSub corridor 1
                \t\tLight 1 : OFF
                \t\tAC 1 : ON

                \tSub corridor 2
                \t\tLight 2 : OFF
                \t\tAC 2 : ON

                Floor 2
                \tMain corridor 1
                \t\tLight 1 : ON
                \t\tAC 1 : ON

                \tSub corridor 1
                \t\tLight 1 : OFF
                \t\tAC 1 : ON

                \tSub corridor 2
                \t\tLight 2 : OFF
                \t\tAC 2 : ON
                
                """;
        assertThat(expected, is(equalTo(outContent.toString())));
    }

    @Test
    void shouldTurnONLightInFloorOneSubCorridorTwoWhenSomeMotionIsDetected() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Hotel hotel = new Hotel();
        Floor floorOne = new Floor(1);
        Floor floorTwo = new Floor(2);

        floorOne.createMainCorridor(1);
        floorOne.createSubCorridor(2);
        floorTwo.createMainCorridor(1);
        floorTwo.createSubCorridor(2);
        hotel.addFloor(floorOne);
        hotel.addFloor(floorTwo);
        floorOne.motionDetector(2);
        hotel.electricityStatus();
        
        String expected = """
                Number Of Floors: 2
                Number Of Main Corridors: 1
                Number Of Sub Corridors: 2
                                
                Floor 1
                	Main corridor 1
                		Light 1 : ON
                		AC 1 : ON
                                
                	Sub corridor 1
                		Light 1 : OFF
                		AC 1 : OFF
                                
                	Sub corridor 2
                		Light 2 : ON
                		AC 2 : ON
                                
                Floor 2
                	Main corridor 1
                		Light 1 : ON
                		AC 1 : ON
                                
                	Sub corridor 1
                		Light 1 : OFF
                		AC 1 : ON
                                
                	Sub corridor 2
                		Light 2 : OFF
                		AC 2 : ON
                		
                """;
        assertThat(expected, is(equalTo(outContent.toString())));
    }
}
