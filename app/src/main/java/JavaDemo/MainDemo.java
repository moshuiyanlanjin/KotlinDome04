package JavaDemo;

import java.io.ObjectOutputStream;

public class MainDemo {

    public static void main(String[] args) {
        int m=65,n=14;
        while (m!=n){
            while (m>n){
                m-=n;
                while (n>m){
                    n-=m;
                }
            }
        }
        System.out.println(m);


    }
}
