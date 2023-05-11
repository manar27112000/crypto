public class hill {


    public static  void keyMatrix(String key,int keymatrix[][]){
        int k=0;//المتغير اللى هيعدى على الاسترنج بتاع الkey
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keymatrix[i][j]=(key.charAt(k))%65;
                k++;
            }
        }
    }



    public static void main(String[] args) {

    }
}
