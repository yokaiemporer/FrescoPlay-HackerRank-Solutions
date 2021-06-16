// package com.fresco;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
// import code.numbers.NumberFinder;
// import code.string.ExtractString;


public class KeithClass {
  boolean isKeith(int x) 
{ 
    ArrayList<Integer> terms=new ArrayList<Integer>(); 
    int temp = x, n = 0; 
    while (temp > 0) 
    { 
        terms.add(temp%10); 
        temp = temp/10; 
        n++; 
    } 
    Collections.reverse(terms); 
    int next_term = 0, i = n; 
    while (next_term < x) 
    { 
        next_term = 0; 
        for (int j=1; j<=n; j++) 
            next_term += terms.get(i-j); 
  
        terms.add(next_term); 
        i++; 
    } 
    return (next_term == x); 
} 
  boolean isComposite(int n) 
    { 
        
        if (n % 2 == 0 || n % 3 == 0) return true; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return true; 
  
        return false; 
    } 
    public String getInput(String conversation) {
    //Write your code
        ArrayList<Integer> ar=NumberFinder.getNumbers(conversation);
        String ans="";
        for(int i:ar)
          if(isKeith(i)&&isComposite(i))
            ans+=i;
        int sum=0;
        
        ArrayList<Integer> ar2=ExtractString.getNumbers(conversation);
        for(int i:ar2)
          sum+=i;
        
        return ans+sum;
    }
    public static void main(String[] args)
    {
      KeithClass keithObj=new KeithClass();
      String expected = "279085604";
        String actual = keithObj.getInput("A: Is Alice available? B: You're talking 2208 to her. A: I've called you a nine times today. B: I was busy doing something 2580. I apologize. A: No problem. B: Did you need 2345 something? A: Do you want to do something 48 tomorrow? B: Is there somewhere special you wanted 76 to go? A: How about a movie? B: A movie sounds good. A: Call me tomorrow three times then. B: I will see you tomorrow.");
        System.out.println(actual);
        System.out.println(actual.hashCode());
    }

}
