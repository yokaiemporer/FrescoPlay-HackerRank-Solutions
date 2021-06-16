// package code.string;
import java.util.*;
public class ExtractString
{
  public static ArrayList<Integer> getNumbers(String convo)
  {
    
    ArrayList<Integer> ar=new ArrayList<Integer>();
    StringTokenizer st=new StringTokenizer(convo," ");
    HashMap<String,Integer> hashu=new HashMap<String,Integer>();
    while(st.hasMoreTokens()){
      String s=st.nextToken().toLowerCase();
      String x;
      // System.out.println(s);
      if(s.compareTo("one")==0)
        ar.add(1);
      if(s.compareTo("two")==0)
        ar.add(2);
      if(s.compareTo("three")==0)
        ar.add(3);
      if(s.compareTo("four")==0)
        ar.add(4);
      if(s.compareTo("five")==0)
        ar.add(5);
      if(s.compareTo("six")==0)
        ar.add(6);
      if(s.compareTo("seven")==0)
        ar.add(7);
      if(s.compareTo("eight")==0)
        ar.add(8);
      if(s.compareTo("nine")==0)
        ar.add(9);
    }
    return ar;
  }
}