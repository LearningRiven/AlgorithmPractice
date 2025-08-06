package org.algomonster;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void testCompare(){
        //String
        assertEquals(0,Utils.compare("Apple","Apple"));
        assertTrue(Utils.compare("Orange","Apple") > 0);
        assertTrue(Utils.compare("Apple","Orange") < 0);
        assertTrue(Utils.compare(null,"Orange") < 0);
        assertTrue(Utils.compare("Orange",null) > 0);
        assertEquals(0,Utils.compare(null,null));

        //Integer
        assertEquals(0,Utils.compare(1,1));
        assertTrue(Utils.compare(10,1) > 0);
        assertTrue(Utils.compare(1,10) < 0);
        assertTrue(Utils.compare(null,10) < 0);
        assertTrue(Utils.compare(10,null) > 0);
        assertEquals(0,Utils.compare(null,null));
    }
}
