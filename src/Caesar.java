import java.util.Scanner;

public class Caesar{
//StringBuffer عشان بدل ما الاراى تكون  مثلا
// a,b,c
// abc تكون
    public static StringBuffer en(String text, int k) {
        StringBuffer result= new StringBuffer();
        for(int i=0;i<text.length();i++){

            if (Character.isUpperCase(text.charAt(i))){
            char c=(char) (((int) text.charAt(i)+k-65)%26+65);
           result.append(c);
        }else{
          char c =(char) (((int)text.charAt(i)+k-97)%26+97);
           char x=Character.toUpperCase(c);
          result.append(x);
//        }
                System.out.print(text.charAt(i));
        }
    }
        return result;
    }
    public static  char alphabet[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static StringBuffer de(String c_text, int k) {
        StringBuffer result=new StringBuffer();
         for (int i=0; i<c_text.length();i++){
              for (int j=0;j<26;j++){
                  if(c_text.charAt(i)==alphabet[j]){
                    if(j>=0){
                        char c= alphabet[j-k];
                        char x=Character.toLowerCase(c);
                        result.append(x);

                  }else {
                      char c= alphabet[(j-k)+26];
                      char x=Character.toLowerCase(c);
                      result.append(x);
                  }

             }}
         }
         return result;
    }


    public static void main(String[] args) {
        Scanner object=new Scanner(System.in);
        System.out.println("Enter Plain Text");
        String plain_text= object.next();
        System.out.println("Enter Key");
        int key= object.nextInt();
        StringBuffer cipher_text= en(plain_text,key);
        System.out.print("\n");
        System.out.println(" encrypt :"+cipher_text);
        String x=cipher_text.toString();
        System.out.println(" decrypt :"+de(x,key));

    }



}












//public class Caesar {
//public static StringBuffer encrept(String text,int s){
//StringBuffer result= new StringBuffer();
//    for (int i=0;i<text.length();i++){
//
//        if (Character.isUpperCase(text.charAt(i))){
//            char ch=(char) (((int) text.charAt(i)+s-65)%26+65);
//            result.append(ch);
//        }else{
//           char ch =(char) (((int)text.charAt(i)+k-97)%26+97);
//           char x=Character.toUpperCase(ch);
//           result.append(x);
//        }
//    }
//    return result;
//}
//public static  char c[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//  public static  StringBuffer decrept(String text,int s){
//      StringBuffer result = new StringBuffer();
//      for (int i=0;i<text.length();i++){
//          for (int j=0;j<26;j++){
//              if (c[j]==text.charAt(i)){
//                  if(j-s>0){
//                      char ch=c[j-s];
//                      char x=Character.toLowerCase(ch);
//                      result.append(x);
//                  }else {
//                      char ch=c[26+(j-s)];
//                      char x =Character.toLowerCase(ch);
//                      result.append(x);
//                  }
//              }
//          }
//      }
//      return result;
//
//  }
//}
