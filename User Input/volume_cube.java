import java.util.Scanner;

public class volume_cube {
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        System.out.println ("Enter l,w,h");
        int l,w,h;
        l=sc.nextInt();
        w=sc.nextInt();
        h=sc.nextInt();
        System.out.println ("Volume=" +(l*w*h));
    }
}
