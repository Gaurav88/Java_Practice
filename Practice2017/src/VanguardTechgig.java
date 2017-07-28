import java.util.Scanner;

/**
 * Created by Gaurav-PC on 26-05-2017.
 */

//Given a number, return the count of numbers having non-repeating digits till that number starting from 1?
public class VanguardTechgig {

    public static void main(String[] args) {

        System.out.println(playingWithDigits(500000055));
    }

    public static int playingWithDigits(int no)
    {
        //Write code here
        int count = 0;
        for(int i=1;i<=no;i++)
        {
            String a = Integer.toString(i);
            char[] b =a.toCharArray();
            int flag = 0;
            if(a.length()>1)
            {
                for(int j=1;j<a.length();j++)
                {
                    //System.out.println(b[j-1]+"=="+b[j]);
                    if( (b[j-1]==b[j]))
                    {
                        flag =1;
                        //  System.out.println("Has Repeated Numbers!");
                        break;
                    }
                }
            }
            if(flag == 0)
            {
                count++;
                //System.out.println("count:"+count+" --> "+"No:"+a);
            }
        }
        return count;
    }
}
