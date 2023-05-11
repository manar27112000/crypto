import java.util.Scanner;

public class railfence {

     public static String en(String text,int key){
       String cipher_text="";

       boolean check=false;
       int j=0;
       int row=key;
       int col=text.length();
       char[][] a=new char[row][col];

         for (int i = 0; i <col ; i++) {
             if(j==0||j==key-1) check=!check;
                 a[j][i]=text.charAt(i);
                 if(check){j++;}else {j--;}
             }


         for (int k = 0; k <row ; k++) {
             for (int l = 0; l <col ; l++) {
                     if(a[k][l]!=0) cipher_text +=a[k][l];
             }
             System.out.println();
         }
             for (int k = 0; k <row ; k++) {
                 for (int l = 0; l <col ; l++) {
                     System.out.print(a[k][l]+" ");
                 }
                 System.out.println();
             }

         return cipher_text;
     }
    public static String de(String text,int key){
        String plain_text="";

        boolean check=false;
        int j=0;
        int row=key;
        int col=text.length();
        char[][] a=new char[row][col];

        for (int i = 0; i <col ; i++) {
            if(j==0||j==key-1) check=!check;
            a[j][i]='*';
            if(check){j++;}else {j--;}
        }

        int index=0;
        check=false;
        for (int i = 0; i <row ; i++) {
            for (int k = 0; k <col ; k++) {
                if(a[i][k]=='*'&& index<col){
                    a[i][k]=text.charAt(index++);
                }

            }

        }
          j=0;
        for (int i = 0; i <col ; i++) {
            if(j==0||j==key-1) check=!check;
            plain_text +=a[j][i];
            if(check){j++;}else {j--;}
        }
        return plain_text;
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter text:");
        String plain_text= in.nextLine();
        System.out.println("Enter the key");
        int key=in.nextInt();
        String en =en(plain_text,key);
        System.out.println( "encrypted : "+en);
        System.out.println( "decrypted : "+de(en,key));
        de(en,key);
    }
}
