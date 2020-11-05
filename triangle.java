public class triangle {

    public static void main(String[] args) {

        stars();
    }

    public static void stars(){

        int level = 5 ;

        for (int i = 0 ; i <=level ; i++) { //這裡執行一次，後面迴圈執行一輪=>巢狀迴圈

            String nulls = "";

            for (int j = 1; j <= level  - i; j++) { //製造前面的'空格'
                ;

                nulls += " ";
            }

            for (int j = 1; j <= i * 2 - 1; j++) { //製造 後面的'*' i*2-1所以是單數
                ;

                nulls += "*";
            }
            for (int j = 1; j <= level  - i; j++) {
                ;

                nulls += " ";
            }

            System.out.println(nulls);
        }










    }



    }
