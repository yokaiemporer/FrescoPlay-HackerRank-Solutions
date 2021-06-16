
package com.fresco;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ram
 */
public class StudentClassTest {
    
    StudentClass stud;
    
    public StudentClassTest() {
    }
    
    @Before
    public void setUp() {
        stud = new StudentClass();
    }
    
    
    @Test
    public void testGeneric1() {
        Method[] methods = StudentList.class.getMethods();
        int count=0;
        for (Method method : methods) {
            if(method.getName().equals("addElement"))
                count++;
            else if(method.getName().equals("removeElement"))
                count++;
            else if(method.getName().equals("getElement"))
                count++;
            else if(method.getName().equals("beginsWith"))
                count++;
            else if(method.getName().equals("bloodGroupOf"))
                count++;
            else if(method.getName().equals("thresholdScore"))
                count++;
                
        }
       if(count==6)
           assertEquals(0,0);
       else
           assertEquals(0,1);
       
    }
    
    @Test
    public void testGeneric2() {
        Method[] methods = ScoreList.class.getMethods();
        int count=0;
        for (Method method : methods) {
            if(method.getName().equals("addElement"))
                count++;
            else if(method.getName().equals("removeElement"))
                count++;
            else if(method.getName().equals("getElement"))
                count++;
            else if(method.getName().equals("averageValues"))
                count++;
            
                
        }
       if(count==4)
           assertEquals(0,0);
       else
           assertEquals(0,1);
       
    }
    
    
    public boolean testGeneric3(){
        Field[] fields1 = StudentList.class.getDeclaredFields(); 
        Field[] fields2 = ScoreList.class.getDeclaredFields(); 
        int flag=0;
        for(Field field : fields1){
            if(field.getType().toString().equals("class java.util.ArrayList")){
                flag++;
            }
        }
        for(Field field : fields2){
            if(field.getType().toString().equals("class java.util.ArrayList")){
                flag++;
            }
        }
        if(flag>=2)
            return true;
        else
            return false;
    }
    
    
    public boolean testGeneric4(){
        TypeVariable<Class<StudentList>>[] parameter1=StudentList.class.getTypeParameters();
        TypeVariable<Class<ScoreList>>[] parameter2=ScoreList.class.getTypeParameters();
        if(parameter1.length==1 && parameter2.length==1)
            return true;
        else
            return false;
    }

            
    @Test
    public void testGetQuery11() {
        if(testGeneric3() && testGeneric4() ){
        String expected = "Ram\nRahul\n";
        String actual = stud.getQuery("Ram Vijay Vinay Rahul Arun", "1,r");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
            
    }
    
    @Test
    public void testGetQuery12() {
        if(testGeneric3() && testGeneric4() ){
        String expected = "Vijay\nVinay\n";
        String actual = stud.getQuery("Ram Vijay Vinay Rahul Arun", "1,v");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
            
    }
    
    @Test
    public void testGetQuery21() {
        if(testGeneric3() && testGeneric4()){
        String expected = "Ram\nVinay\nArun\n";
        String actual = stud.getQuery("Ram Vijay Vinay Rahul Arun", "2,B- AB- B- O+ B-,B-");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery22() {
        if(testGeneric3() && testGeneric4()){
        String expected = "Vijay\nVinay\n";
        String actual = stud.getQuery("Ram Vijay Vinay Rahul Arun", "2,B- AB- AB- O+ B-,AB-");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery31() {
        if(testGeneric3() && testGeneric4()){
        String expected = "3 students scored 70 above";
        String actual = stud.getQuery("90 78 69 45 90 42 69", "3,70");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery32() {
        if(testGeneric3() && testGeneric4()){
        String expected = "2 students scored 90 above";
        String actual = stud.getQuery("90 78 69 45 90", "3,90");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    
    @Test
    public void testGetQuery41() {
        if(testGeneric3() && testGeneric4()){
        String expected = "69.00";
        String actual = stud.getQuery("90 78 69 45 90 42 69", "4");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
        
    }
    @Test
    public void testGetQuery42() {
        if(testGeneric3() && testGeneric4()){
        String expected = "73.29";
        String actual = stud.getQuery("96 78 93 45 90 42 69", "4");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
        
    }
    
    @Test
    public void testGetQuery51() {
        if(testGeneric3() && testGeneric4()){
        String expected = "6.23";
        String actual = stud.getQuery("6.9 7.3 4.5", "5");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testGetQuery52() {
        if(testGeneric3() && testGeneric4()){
        String expected = "6.32";
        String actual = stud.getQuery("6.4 7.9 7.4 3.4 6.5", "5");
        assertEquals(expected,actual);
        }
        else{
            assertEquals(0,1);
        }
    }
    
}
