import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {
   @Test
   void allBranches (){
       RuntimeException e1= assertThrows(RuntimeException.class,()->SILab2.checkCart( null,9));
       assertEquals("allItems list can't be null!",e1.getMessage());

       RuntimeException e2= assertThrows(RuntimeException.class,()->SILab2.checkCart(List.of(new Item("", null, 8, 9)),7));
       assertEquals("No barcode!",e2.getMessage());

       RuntimeException e3= assertThrows(RuntimeException.class,()->SILab2.checkCart(List.of(new Item("","a",6,5)),4));
       assertEquals("Invalid character in item barcode!",e3.getMessage());

       assertTrue(SILab2.checkCart (List.of(new Item("w","0",301,5)),1555));

        assertFalse(SILab2.checkCart(List.of(new Item("e","2",6,0)),4));

    }
    @Test
    void multipleConditions(){
        assertFalse(SILab2.checkCart(List.of(new Item("v","1",298,0)),250 ));
        assertFalse(SILab2.checkCart(List.of(new Item("t","1",302,0)),250 ));
        assertFalse(SILab2.checkCart(List.of(new Item("u","1",303,0.85f)),250 ));
        assertTrue(SILab2.checkCart(List.of(new Item("m","0",304,0.08f)),250 ));
    }

}
