import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegEx
{

    public String findCardTypeNumbers(String conversation, String cardType)
    {
        //Write your code here
        String ans="";
        Pattern pattern;
        Matcher matcher;
        if(cardType.equals("Visa")){
            pattern = Pattern.compile(" 4[0-9]{15}| 4[0-9]{12}", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(conversation);
            while(matcher.find()) {
                ans+=matcher.group().substring(1)+" ";
            }

        }
        else if(cardType.equals("American Express"))
        {
            pattern = Pattern.compile(" 34[0-9]{13}", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(conversation);
            while(matcher.find()) {
                ans+=matcher.group().substring(1)+" ";
            }

        }
        else if(cardType.equals("Discover"))
        {
            pattern = Pattern.compile(" 6011[0-9]{12}| 65[0-9]{14}", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(conversation);
            
            while(matcher.find()) {
                System.out.println("Match found");
                ans+=matcher.group().substring(1)+" ";
            }
        }
        else if(cardType.equals("JCB"))
        {
            pattern = Pattern.compile("((( 2131| 1800)[0-9]{11})| 35[0-9]{14})", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(conversation);
            while(matcher.find()) {
                System.out.println("Match found");
                ans+=matcher.group().substring(1)+" ";
            }
        }
        else
        {
            ans="Not a valid card type";
        }
        if(ans.length()>0&&ans.charAt(0)!='N')
            ans=ans.substring(0, ans.length()-1);

        
         
        

        return ans;
    }
    public static void main(String[] args) {
        RegEx re=new RegEx();
        String passage="Manager : Good morning sir, How can i help for you? Customer : Sir, actually the card names in my cards got scratched by and i am unable to find their types. I am only having the card numbers. Manager : What are all the types of cards you are having sir. Customer : I am having visa cards, american express cards, Discover cards and JCB cards. Manager : Ok sir, can you tell me your account number and your mobile number. Customer : My account number is 1356798988878 and my mobile number is 8765465743. Manager : And now tell me the number of the cards sir. Customer : The card numbers are 4769856453217, 340987687654689, 213189796876789, 6011675489757876 and 3589797987979879. Manager : Please wait a minute sir. Customer : Sorry and i forget another number its 4654465765767878 and 6589456879087568. Manager : Please give me a minute sir.";
        String cardType="JCB";
        String actual=re.findCardTypeNumbers(passage, cardType);
        System.out.println(actual);
        System.out.println(actual.hashCode());

    }

}