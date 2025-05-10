import java.util.Scanner;

public class area_circumference_circle {

        public static void main(String args[])
        {
            Scanner sc=new Scanner (System.in);
            System.out.println ("Input R");
            int R1=45, R2=20,R;
            R=sc.nextInt();

            System.out.println ("Circumference=" +(2*Math.PI*R));
            System.out.println ("Area=" +(Math.PI*(R1*R1-R2*R2)));
        }
}
