package Round_909.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a, sum;
    static List<Integer> list;

    static void solve()  {
       n = Reader.nextInt();
       a = new int[n + 10];
       for (int i = 1; i <= n; i++) {
           a[i] = Reader.nextInt();
       //    mi = Math.min(mi, a[i]);
       }

       long cnt = 0;
       for (int i = n - 1; i >= 1; i--) {
           if (a[i] > a[i+1]) {

               int ma = 0, k1 = 0, k2 = 0, fk1 = 0, fk2 = 0;
               /*for(int j = a[i+1], num = 0; num <= 100 && j - num > 0;  num++) {
                   k1 = j - num;
                   k2 = a[i] % k1 == 0 ? k1 : a[i] % k1;
                   //System.out.printf("i = %d a[i] = %d  k1 = %d k2 = %d\n",i, a[i], k1, k2);
                   if (Math.min(k1, k2) > ma) {
                       ma = Math.max(ma, Math.min(k1, k2));
                       fk1 = k1;
                       fk2 = k2;
                   }
               }*/
               int blockSize = a[i] / (a[i] / a[i+1] + 1) == 0 ? 1 : a[i] / (a[i] / a[i+1] + 1); // block size
               int num =  a[i] % a[i+1] == 0 ? a[i] / a[i+1]  :  a[i] / a[i+1] + 1;
              // System.out.printf("i=%d X=%d Y=%d\n", i, blockSize, num);


               cnt += num - 1;


               //System.out.printf("i = %d  Beat X = %d 余 = %d 贡献 = %d\n", i,  fk1, fk2, (a[i] - fk2) / fk1 );

                a[i] = blockSize;

               /*long target1 = a[i] % a[i+1] == 0 ? a[i+1] : a[i] % a[i+1];
               long target2 = a[i] / 2;
               //System.out.println(target1 + " vs " + target2);

               if (target2 < a[i+1] && target2 >= target1) {
                   cnt += 1;
                   a[i] = a[i] / 2;
                   System.out.println("i="+i  + "贡献 = " + (1) );
               }else {
                   long tmp = (a[i] - a[i+1]) / a[i+1];
                   cnt += tmp == 0 ? 1 : tmp;
                   a[i] = a[i] % a[i + 1] == 0 ? a[i + 1] : a[i] % a[i + 1];
                  System.out.println("i="+i  + "贡献 = " + (tmp == 0 ? 1 : tmp) );
               }*/

           }
       }
      /* for (int i = 1; i <= n; i++) {
           System.out.printf("%s%s", a[i], i == n ? "\n" : " ");
       }*/

       System.out.println(cnt);

    }
    public static void main(String[] args)  {
        Reader.init();
        int T = Reader.nextInt();
        while(T-- > 0) {
            solve();
        }
    }



    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * 初始化 从字节流到字符流，初始化分词器
         */
        static void init() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next()  {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    // ignore
                }
            }
            return tokenizer.nextToken();
        }

        static int nextInt()  {
            return Integer.parseInt(next());
        }

        static double nextDouble()  {
            return Double.parseDouble(next());
        }
    }
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        static Pair MakePair(int x, int y) {
            return new Pair(x, y);
        }

    }
}
/***

80
3
3 99001 1000
3
3 100000000 10000001


 *
 *
 */