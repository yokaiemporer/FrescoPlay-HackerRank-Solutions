// package code.numbers;
import java.util.*;
public class NumberFinder
{
  public static ArrayList<Integer> getNumbers(String convo)
  {

    ArrayList<Integer> ar=new ArrayList<Integer>();
    StringTokenizer st=new StringTokenizer(convo," ");
    while(st.hasMoreTokens())
    {
      String s=st.nextToken();
      int flag=0;
      int i=0;
      for(i=0;i<s.length();i++)
      {
        char c=s.charAt(i);
        if(c=='.')
          flag=2;
        else if(!Character.isDigit(c))
        {
          flag=1;
          break;
        }
      }
      if(flag==0)
        ar.add(Integer.parseInt(s));
      if(flag==2)
      {
        s=s.substring(0,s.length()-1);
        ar.add(Integer.parseInt(s));

      }
      // System.out.println(s+" "+flag);
    }
    return ar;
  }
}