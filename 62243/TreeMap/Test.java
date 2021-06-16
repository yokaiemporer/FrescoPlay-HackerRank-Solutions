package com.fresco;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TreemapHandsonTest {
    TreemapHandson th;
    
    public TreemapHandsonTest() {
    }
    
    @Before
    public void setUp() {
        th=new TreemapHandson();
    }
    
        
    public boolean testCheck() {
        TreeMap<Integer,String> exp=new TreeMap<>();
        exp.put(3, "Dhoni");
        exp.put(1, "Virat");
        exp.put(5, "Jadeja");
        exp.put(2, "Rohit");
        exp.put(4, "Pandya");
        TreeMap<Integer,String> actual=th.createPlayerPositionMap("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30");
        
        return exp.equals(actual);
        
        
    }
    
    public boolean testCheck2() {
        TreeMap<String,Integer> exp=new TreeMap<>();
        exp.put("Dhoni",100);
        exp.put("Virat",50);
        exp.put("Jadeja",90);
        exp.put("Rohit",70);
        exp.put("Pandya",30);
        TreeMap<String,Integer> actual=th.createPlayerScoreMap("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30");
        
        return exp.equals(actual);
        
        
    }
    
    
    public boolean testCheck3() {
        
        Object actual=th.createMatchesMap("3,Rohit,69|2,Virat,56|1,Dhoni,150\n1,Rahul,90|2,Virat,100|3,Rohit,59|4,Dhoni,59\n1,Rahul,99|2,Virat,64|3,Rohit,78");
        TreeMap<?,?> exp=new TreeMap<>() ;
        Object expected=exp;
        return expected.getClass().equals(actual.getClass());
    }
    
    @Test
    public void testGetQuery() {
        
        if(testCheck()){
        String expected="2 Rohit\n3 Dhoni\n4 Pandya\n";
        String actual=th.getQuery("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "1 2 4");
        assertEquals(expected,actual);
        
        String expected2="3 Dhoni\n4 Pandya\n5 Jadeja\n";
        String actual2=th.getQuery("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "1 3 5");
        assertEquals(expected2,actual2);
        }
        else
            assertEquals(0,1);
        
    }
    @Test
    public void testGetQuery1() {
        
        if(testCheck()){
        String expected2="4 Pandya\n5 Jadeja\n6 Rahul\n";
        String actual2=th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150", "1 4 6");
        assertEquals(expected2,actual2);
        }
        else
            assertEquals(0,1);
        
    }
    
    @Test
    public void testGetQuery2() {
        
        if(testCheck2()){
        String expected="2 Rohit\n3 Dhoni\n5 Jadeja\n";
        String actual=th.getQuery("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "2 50");
        assertEquals(expected,actual);
        }
        else
            assertEquals(0,1);
        
    }
    @Test
    public void testGetQuery3() {
        
        if(testCheck2()){        
        String expected="1 Virat\n3 Dhoni\n6 Rahul\n";
        String actual=th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150", "2 100");
        assertEquals(expected,actual);
        }
        else
            assertEquals(0,1);
    }
    @Test
    public void testGetQuery4() {
        
       if(testCheck3()){
        String expected="The Efficient Opener is Rohit";
        String actual=th.getQuery("1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
        assertEquals(expected,actual);
        }
        else
            assertEquals(0,1);
        
    }
    @Test
    public void testGetQuery5() {
        
        if(testCheck3()){
        String expected="The Efficient Opener is Dhoni";
        String actual=th.getQuery("3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
        assertEquals(expected,actual);
        }
        else
            assertEquals(0,1);
        
    }
}

