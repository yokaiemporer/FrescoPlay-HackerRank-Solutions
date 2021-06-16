import java.io.*;
import java.util.*;
class Register {
    
    private static Register register = null;
    /*
     * Complete the 'getTotalBill' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts MAP itemDetails as parameter.
     */
    public static Register getInstance()
    {
        return new Register();
    }
    public String getTotalBill(Map<String,Integer> itemDetails) {

        // Write your code here
        
        HashMap<String,Double> f=new HashMap<String,Double>();
        f.put("apple",2.0);
        f.put("orange",1.5);
        f.put("mango",1.2);
        f.put("grapes",1.0);
        Double ans=0.0;
        for(String key:itemDetails.keySet())
        {
            ans+=itemDetails.get(key)*f.getOrDefault(key,1.0);
        }
        return ans.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        
        Scanner readInput = new Scanner(System.in);        
        String[] input=readInput.nextLine().split(" ");                
        Map<String,Integer> myItems=new HashMap<String,Integer>();
        for(int i=0;i<input.length;i+=2){
          myItems.put(input[i],Integer.parseInt(input[i+1]));	
        }
        Register regObj = Register.getInstance();        
        System.out.println(regObj.getTotalBill(myItems));
        readInput.close();
        
    }
}