package com.fresco;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegExTest {
    RegEx re;
    public RegExTest() {
    }
    
    @Before
    public void setUp() {
        re = new RegEx();
    }
    
    
    @Test
    public void testFindCardTypeNumbers1() {
        String passage="Manager : Good morning sir, How can i help for you? Customer : Sir, actually the card names in my cards got scratched by and i am unable to find their types. I am only having the card numbers. Manager : What are all the types of cards you are having sir. Customer : I am having visa cards, american express cards, Discover cards and JCB cards. Manager : Ok sir, can you tell me your account number and your mobile number. Customer : My account number is 1356798988878 and my mobile number is 8765465743. Manager : And now tell me the number of the cards sir. Customer : The card numbers are 4769856453217, 340987687654689, 213189796876789, 6011675489757876 and 3589797987979879. Manager : Please wait a minute sir. Customer : Sorry and i forget another number its 4654465765767878 and 6589456879087568. Manager : Please give me a minute sir.";
        String cardType="JCB";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(1295505422, actual.hashCode());
    }
    
    @Test
    public void testFindCardTypeNumbers2() {
        String passage="Manager : Good morning sir, How can i help for you? Customer : Sir, actually the card names in my cards got scratched by and i am unable to find their types. I am only having the card numbers. Manager : What are all the types of cards you are having sir. Customer : I am having visa cards, american express cards, Discover cards and JCB cards. Manager : Ok sir, can you tell me your account number and your mobile number. Customer : My account number is 1356798988878 and my mobile number is 8765465743. Manager : And now tell me the number of the cards sir. Customer : The card numbers are 4769856453217, 340987687654689, 213189796876789, 6011675489757876 and 3589797987979879. Manager : Please wait a minute sir. Customer : Sorry and i forget another number its 4654465765767878, 374567868809898 and 6589456879087568. Manager : Please give me a minute sir.";
        String cardType="Visa";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(2047559244, actual.hashCode());
    }
    
    @Test
    public void testFindCardTypeNumbers3() {
        String passage="Customer : Hello sir, I need a small help. Manager : Yes sir, What can i do for you? Customer : I am using a card number of 4979879798798798 and 6589479578978935. Manager : Ok sir what is the problem and what is your token number? Customer : My token number is 180078, I have lost those two cards and i want to block those cards. Manager : Please note this number sir, 180098475938742. Customer : Sholud i tell this number to make my request done!!. Manager : Yes, sir.";
        String cardType="American Express";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(0, actual.hashCode());
    }
    
    @Test
    public void testFindCardTypeNumbers4() {
        String passage="Manager : Good morning sir, How can i help for you? Customer : Sir, actually the card names in my cards got scratched by and i am unable to find their types. I am only having the card numbers. Manager : What are all the types of cards you are having sir. Customer : I am having visa cards, american express cards, Discover cards and JCB cards. Manager : Ok sir, can you tell me your account number and your mobile number. Customer : My account number is 1356798988878 and my mobile number is 8765465743. Manager : And now tell me the number of the cards sir. Customer : The card numbers are 4769856453217, 340987687654689, 213189796876789, 6011675489757876 and 3589797987979879. Manager : Please wait a minute sir. Customer : Sorry and i forget another number its 4654465765767878 and 6589456879087568. Manager : Please give me a minute sir.";
        String cardType="American Express";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(16878510, actual.hashCode());
    }
    
    @Test
    public void testFindCardTypeNumbers5() {
        String passage="Manager : Hello sir, I am talking from xxxx bank, We received a request to change your account with account number 6011325689653578 from minor to major can you please tell me the reference id that has been messaged to you at the time you apply for this. Customer : Yes sir, It is 6589490384208830 Manager : Sir i need your mobile number and card number Customer : My mobile number is 8654329865 and card number is 60116560116578. Manager : Please note down the processed reference number, 4879328702659268. Customer : The number is 3579328702659268 right. Manager : No the first two numbers were 48 and not 35. Customer : ok sir, Thank you.";
        String cardType="Discover";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(-1884105022, actual.hashCode());
    }
    
    @Test
    public void testFindCardTypeNumbers6() {
        String passage="Manager : Hello sir, I am talking from xxxx bank, We received a request to change your account with account number 6011325689653578 from minor to major can you please tell me the reference id that has been messaged to you at the time you apply for this. Customer : Yes sir, It is 6589490384208830 Manager : Sir i need your mobile number and card number Customer : My mobile number is 8654329865 and card number is 60116560116578. Manager : Please note down the processed reference number, 4879328702659268. Customer : The number is 3579328702659268 right. Manager : No the first two numbers were 48 and not 35. Customer : ok sir, Thank you.";
        String cardType="Credict";
        String actual=re.findCardTypeNumbers(passage, cardType);
        assertEquals(865173818, actual.hashCode());
    }

}
