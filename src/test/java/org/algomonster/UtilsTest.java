package org.algomonster;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    void testCompare(){
        //String
        assertTrue(Utils.compare("Apple","Apple") == 0);
        assertTrue(Utils.compare("Orange","Apple") > 0);
        assertTrue(Utils.compare("Apple","Orange") < 0);
        assertTrue(Utils.compare(null,"Orange") < 0);
        assertTrue(Utils.compare("Orange",null) > 0);
        assertTrue(Utils.compare(null,null) == 0);

        //Integer
        assertTrue(Utils.compare(1,1) == 0);
        assertTrue(Utils.compare(10,1) > 0);
        assertTrue(Utils.compare(1,10) < 0);
        assertTrue(Utils.compare(null,10) < 0);
        assertTrue(Utils.compare(10,null) > 0);
        assertTrue(Utils.compare(null,null) == 0);
    }
}
