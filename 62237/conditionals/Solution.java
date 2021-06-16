import java.io.*;
import java.math.*;
import java.util.*;


class Result {

    /*
     * Complete the 'calculateGrade' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY students_marks as parameter.
     */

    public static String[] calculateGrade(int[][] students_marks) {
        String[] ans=new String[students_marks.length];
        for(int i=0;i<students_marks.length;i++)
        {
            int sum=0;
            for(int j=0;j<students_marks[0].length;j++)
                sum+=students_marks[i][j];
            Double avg=sum/(students_marks[0].length*1.0);
            if(avg>=90)
                ans[i]="A+";
            else if(avg>=80)
                ans[i]="A";
            else if(avg>=70)
                ans[i]="B";
            else if(avg>=60)
                ans[i]="C";
            else if(avg>=50)
                ans[i]="D";
            else
                ans[i]="F";
        }
        return ans;

    }

}

public class Solution {