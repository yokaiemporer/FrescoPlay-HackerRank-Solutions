public class Main
{
    public static void main(String[] args) {
        SelfFinance self=new SelfFinance();
        Aided aided=new Aided();
        String expected="The Efficient Opener is Dhoni";
        String actual=th.getQuery("3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
        System.out.println(actual);
        System.out.print(actual.hashCode());


    }
}