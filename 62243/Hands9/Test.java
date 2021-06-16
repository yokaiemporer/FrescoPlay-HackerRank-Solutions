package com.fresco;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class HashmapHandsonTest{
    
    Library lib;
    public HashmapHandsonTest() {
    }
    
    @Before
    public void setUp() {
        lib=new Library();
    }
    
    
    @Test
    public void testGetQuery1() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("125,C programming,Brian W. Kernighan|564,C++ programming,Bjarne Stroustrup|546,Java programming,James Gosling|897,Data Structure,Adam Drozdek|785,System Programming,Johnson M|265,Data Structure,Adam Drozdek|469,Data Structure,Adam Drozdek|968,Advanced Java,James Gosling","125,101|564,102|546,103|897,104|785,101","1,546");
        String exp="No Stock\nIt is owned by 103\n";
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
        
    }
    @Test
    public void testGetQuery2() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("1001,Adventures of Sherlock Holmes,Sir Arthur Conan Doyle|1002,Adventures of Tom Sawyer,The Mark Twain|1003,Alice in the Wonderland,Lewis Carroll|1004,All’s Well that Ends well,William Shakespeare|1005,As you like it,William Shakespeare|1006,Anand Math,Bankim Chandra Chatterjee","1006,101|1003,102|1001,101","1,1005");
        String exp="It is available\nAuthor is William Shakespeare\n";
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
        
    }
    @Test
    public void testGetQuery3() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("125,C programming,Brian W. Kernighan|564,C++ programming,Bjarne Stroustrup|546,Java programming,James Gosling|897,Data Structure,Adam Drozdek|785,System Programming,Johnson M|265,Data Structure,Adam Drozdek|469,Data Structure,Adam Drozdek|968,Advanced Java,James Gosling","125,101|564,102|546,103|897,104|785,101","3,Data Structure");
        String exp="1 out\n2 in\n";
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery4() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("1001,Adventures of Sherlock Holmes,Sir Arthur Conan Doyle|1002,Adventures of Tom Sawyer,The Mark Twain|1003,Alice in the Wonderland,Lewis Carroll|1004,All’s Well that Ends well,William Shakespeare|1005,As you like it,William Shakespeare|1006,Anand Math,Bankim Chandra Chatterjee","1006,101|1003,102|1001,101","2,101");
        String exp="1001 Adventures of Sherlock Holmes\n1006 Anand Math\n";
        assertEquals(exp,actual);
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery5() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("1001,Adventures of Sherlock Holmes,Sir Arthur Conan Doyle|1002,Adventures of Tom Sawyer,The Mark Twain|1003,Alice in the Wonderland,Lewis Carroll|1004,All’s Well that Ends well,William Shakespeare|1005,As you like it,William Shakespeare|1006,Anand Math,Bankim Chandra Chatterjee","1006,101|1003,102|1001,101","4,William Shakespeare");
        String exp="All’s Well that Ends well\nAs you like it\n";
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery6() {
        if(testCheck() && testCheck1()){
        String actual=lib.getQuery("1001,Python Tricks,Dan Bader|1002,The Complete Software Developer's Career Guide,John Sonmez|1003,Mastering Deep Learning Fundamentals with Python,Richard Wilson|1004,Cracking the Coding Interview,Gayle Laakmann McDowell|1005,Python Programming,Joseph Mining|1006,Effective Java,Joshua Bloch|1007,Java,Nathan Clark|1008,JavaScript Programming,Brian Jenkins|1009,Functional-Light JavaScript,Kyle Simpson","1006,101|1009,102|1003,101","5,java");
        String exp="1008 JavaScript Programming\n1009 Functional-Light JavaScript\n1006 Effective Java\n1007 Java\n";
        assertEquals(exp,actual);
        }else{
            assertEquals(0,1);
        }
    }
    
    
    
    public boolean testCheck() {
        
        Library bs1=new Library("Python Tricks", "Dan Bader");
        Library bs2=new Library("The Complete Software Developer's Career Guide", "John Sonmez");
        Library bs3=new Library("Mastering Deep Learning Fundamentals with Python","Richard Wilson");
        HashMap<Integer,Library> exp=new HashMap<>();
        exp.put(1001,bs1);exp.put(1002,bs2);exp.put(1003,bs3);
        HashMap<Integer,Library> actual=lib.createLibraryMap("1001,Python Tricks,Dan Bader|1002,The Complete Software Developer's Career Guide,John Sonmez|1003,Mastering Deep Learning Fundamentals with Python,Richard Wilson");

        return exp.equals(actual);
    }
    public boolean testCheck1() {
        
        HashMap<Integer,Integer> exp=new HashMap<>();
        exp.put(125,101);exp.put(564,102);exp.put(546,103);exp.put(897,104);exp.put(785,101);
        HashMap<Integer,Integer> actual=lib.createUserMap("125,101|564,102|546,103|897,104|785,101");
        
        return exp.equals(actual);
    }
}
