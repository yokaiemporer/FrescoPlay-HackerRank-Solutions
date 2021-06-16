import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
    // Write your code here
            Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
            for(Integer id:ids)
            {
                hm.put(id, hm.getOrDefault(id, 0)+1); 
            }
            // for (Map.Entry<Integer, Integer> me : hm.entrySet()) { 
            // System.out.print(me.getKey() + ":"); 
            // System.out.println(me.getValue()); 
             List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
            }); 
            int cnt=0;
            for (Map.Entry<Integer, Integer> aa : list) { 
            // temp.put(aa.getKey(), aa.getValue()); 
            if(aa.getValue()<=m){
            m-=aa.getValue();
            cnt++;
            }
            else{
                break;
            }
            } 
         
        return list.size()-cnt;
            
    

    }

}

public class Solution {