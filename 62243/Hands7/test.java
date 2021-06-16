package com.fresco;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class BusProbTest {
    BusProb bp;
    ALPresent alp;
    public BusProbTest() {
    }
    
    @Before
    public void setUp() {
        bp=new BusProb();
        alp=new ALPresent();
    }
    int capacity;
    int stops;
    List<String> listOfInputs=new ArrayList<>();
    
    @Test
    public void testOutput11() throws IOException {
        if(alp.isALPresent())
        {
            capacity=8;
            stops=5;
            listOfInputs.add("+1001 +1002 +1003 +1004 +1005 +1015");
            listOfInputs.add("-1001 -1003 -1005 +1006 +1007 -1015");
            listOfInputs.add("+1008 -1004 -1002 +1009 -1006 +1001");
            listOfInputs.add("-1008 +1010 -1009 +1005 -1007");
            listOfInputs.add("+1011 -1010 -1005");
            String query="1";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(1106934417, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput12() throws IOException {
        if(alp.isALPresent())
        {
            capacity=18;
            stops=8;
            listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
            listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
            listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
            listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
            listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
            listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
            listOfInputs.add("+65446 +10412 +12412 +68723 -532");
            listOfInputs.add("+7545 +8651 -4131 -562");
            String query="2";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(-1020571650, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput13() throws IOException {
        if(alp.isALPresent())
        {
            capacity=30;
            stops=12;
            listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
            listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
            listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
            listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
            listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
            listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
            listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
            listOfInputs.add("+141 +142");
            listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
            listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
            listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
            listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
            String query="2";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(98797057, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
        
    }
    
    @Test
    public void testOutput14() throws IOException {
        if(alp.isALPresent())
        {
            capacity=8;
            stops=5;
            listOfInputs.add("+1001 +1002 +1003 +1004 +1005 +1015");
            listOfInputs.add("-1001 -1003 -1005 +1006 +1007 -1015");
            listOfInputs.add("+1008 -1004 -1002 +1009 -1006 +1001");
            listOfInputs.add("-1008 +1010 -1009 +1005 -1007");
            listOfInputs.add("+1011 -1010 -1005");
            String query="5, 1001";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(542502334, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput15() throws IOException {
        if(alp.isALPresent())
        {
            capacity=18;
            stops=8;
            listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
            listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
            listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
            listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
            listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
            listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
            listOfInputs.add("+65446 +10412 +12412 +68723 -532");
            listOfInputs.add("+7545 +8651 -4131 -562");
            String query="5, 28466";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(503829939, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput16() throws IOException {
        if(alp.isALPresent())
        {
            capacity=30;
            stops=12;
            listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
            listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
            listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
            listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
            listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
            listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
            listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
            listOfInputs.add("+141 +142");
            listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
            listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
            listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
            listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
            String query="3, 101";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(1609639898, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput17() throws IOException {
        if(alp.isALPresent())
        {
            capacity=18;
            stops=8;
            listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
            listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
            listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
            listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
            listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
            listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
            listOfInputs.add("+65446 +10412 +12412 +68723 -532");
            listOfInputs.add("+7545 +8651 -4131 -562");
            String query="3, 12412";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(1325126904, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
    @Test
    public void testOutput18() throws IOException {
        if(alp.isALPresent())
        {
            capacity=30;
            stops=12;
            listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
            listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
            listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
            listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
            listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
            listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
            listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
            listOfInputs.add("+141 +142");
            listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
            listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
            listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
            listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
            String query="4, 104";
            String actual=bp.output(capacity, stops, listOfInputs, query);
            assertEquals(1910926845, actual.hashCode());
        }
        else
        {
            assertEquals(-1911513968, -185797987);
        }
    }
    
}
