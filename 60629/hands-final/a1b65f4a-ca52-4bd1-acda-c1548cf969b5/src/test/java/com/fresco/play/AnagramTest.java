package com.fresco.play;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class AnagramTest 
{
    
    @Test
    public void testAnagram_sentence1()
    {
    	Anagram ang = new Anagram();
        String str1 = "Two plus eleven";
        String str2 = "One plus twelve";
        assertTrue(Anagram.isAnagram(str1,str2));
    }

    @Test
    public void testAnagram_sentence2()
    {
    	Anagram ang = new Anagram();
        String str1 = "The eyes";
        String str2 = "They See";
        assertTrue(Anagram.isAnagram(str1,str2));
    }

    @Test
    public void testAnagram_words()
    {
    	Anagram ang = new Anagram();
        String str1 = "listen";
        String str2 = "silent";
        assertTrue(Anagram.isAnagram(str1,str2));
    }

    @Test
    public void testAnagram_wordnsentence()
    {
    	Anagram ang = new Anagram();
        String str1 = "dormitory";
        String str2 = "Dirty Room";
        assertTrue(Anagram.isAnagram(str1,str2));
    }

    @Test
    public void testAnagram_negative1()
    {
    	Anagram ang = new Anagram();
        String str1 = "I am an Anagram";
        String str2 = "I am a Anagram";
        assertFalse(Anagram.isAnagram(str1,str2));
    }

     @Test
    public void testAnagram_negative2()
    {
    	Anagram ang = new Anagram();
        String str1 = "Hero";
        String str2 = "Zero";
        assertFalse(Anagram.isAnagram(str1,str2));
    }
}
