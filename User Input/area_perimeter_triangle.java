import java.util.Scanner;

public class area_perimeter_triangle {

        public static void main(String args[])
        {
            Scanner sc=new Scanner (System.in);
            System.out.println ("Enter a,b,c,h");
            int h,a,b,c;
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            h=sc.nextInt();
            System.out.println ("area=" +(h*b/2)+ " " +"perimeter=" +(a+b+c));

        }
}
