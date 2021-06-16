package com.fresco.play;

import java.util.*;
public class Anagram
{
    public static void main(String a[]){

        String str1=null;
        String str2=null;
        Scanner sc=new Scanner(System.in);
        // Write code to get 2 strings/sentences from command line and check if they are Anagrams
        System.out.println("Wanna check if your strings are anagrams???");
        System.out.print("Enter String1 : ");
        //Get user input in str1
        // str1=sc.next();
        str1=sc.nextLine();

        System.out.print("Enter String2 : ");
        //Get user input in str2
        str2=sc.nextLine();
        // str2=a[1];
        boolean status = isAnagram(str1,str2);

         if (status) {
            System.out.println("Whoa!!!! "+str1 + " is a perfect ANAGRAM of " + str2 );

        } else {
            System.out.println("Oh no!!! "+str1 + " and " + str2 + " do not match up to be Anagrams...");

        }
        sc.close();

    }


     static boolean isAnagram(String in1, String in2) {

        /*Compare if in1 and in2 are Anagrams and return true or false.
        This method should satisfy all the tests in AnagramTest.java*/
        int[] arr1=new int[10001];
        int[] arr2=new int[10001];
        for(int i=0;i<in1.length();i++)
        {
          arr1[in1.toLowerCase().charAt(i)]++;
        }
        for(int i=0;i<in2.length();i++)
        {
          arr2[in2.toLowerCase().charAt(i)]++;
        }
        for(int i=0;i<10001;i++)
        {
          if(i==32)
          continue;
          if(arr1[i]!=arr2[i])
          return false;
        }
        return true;


    }

}
