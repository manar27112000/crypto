import java.util.Scanner;

public class playfair {

    private static char[][ ]matrix;
    private static  int [][] positions =new int[26][2];//26حرف و 2 ->x,y
    static String alpha="abcdefghijklmnopqrstuvwxyz";
   public static  char[][]getMatrix(String key){
      /*
      هنا انا بخزن ال key  فى string وبشيل الحروف المتكرره ف اول حاجه بضيف الحروف على الkey بس فى حرف ناقص فهحط انه بدلi حط j
      بعد كدا بعمل الkey2دا فاضي وهخزن فيه الحروف بس من غير التكرارات يعنى لو ch مش موجود ضيفه موجود متضيفوش
       */
       key=key+alpha;

       key=key.replace("j","i");
       String key2="";
       char ch ;
       for (int i = 0; i <key.length() ; i++) {
           ch=key.charAt(i);
           if (!key2.contains(ch+"")){
               key2+=ch;
           }}
       /*   بخزن الحروف فى الماتركس وبعد كدا بتاكد ان الحروف من 0ل 25مش اكبر ولا اقل*/
       matrix= new char[5][5];
       int x=0;//دا المتغير اللى هيمشي على الاسترينج لحد ما ال25 عنصر يخلصوا
       for (int i = 0; i < 5; i++) {
           for (int j = 0; j <5 ; j++) {
               matrix[i][j]=key2.charAt(x);
               positions[key2.charAt(x)-'a'][0]=i;
               positions[key2.charAt(x)-'a'][1]=j;
               x++;
           }}
return matrix;
   }

   public static String encrypt (String plain_text)
   {
       StringBuilder sp =new StringBuilder(plain_text);
       for (int i = 0; i <sp.length() ; i+=2) {
           if(sp.charAt(i)=='j'){ sp.setCharAt(i,'i');}
           if(i==sp.length()-1){sp.append(sp.length()%2==1?'X':"");}
           else if(sp.charAt(i)==sp.charAt(i+1)){sp.insert(i+1,'X');}
       }
       return code(sp,1);
   }
   public static String code(StringBuilder s,int sign){
       int len=s.length();
       for (int i = 0; i <len ; i+=2) {
           char a=s.charAt(i);
           char b=s.charAt(i+1);
           int row1= positions[a-'a'][0];
           int row2= positions[b-'a'][0];
           int col1= positions[a-'a'][1];
           int col2= positions[b-'a'][1];
        if(row2==row1){
                       col1=(col1+sign)%5;
                       col2=(col2+sign)%5;
        } else if (col1==col2) {

            row1=(row1+sign)%5;
            row2=(row2+sign)%5;
        }else {int tmp=col1;
        col1=col2;
        col2=tmp;}

       s.setCharAt(i,matrix[row1][col1]);
        s.setCharAt(i=1,matrix[row2][col2]);
   }
   return  s.toString();}

    public static String decrypt(String s){
       return code(new StringBuilder(s),4);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);


    }
}
