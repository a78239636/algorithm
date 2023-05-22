package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 尝试
 */

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** 初始化 从字节流到字符流，初始化分词器  */
    static void init() {
        reader = new BufferedReader( new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    public static void main(String[] args) throws IOException {
        Reader.init();
        String s;
        while( (s = Reader.next()) != null) {
            System.out.println("输入的是：" + s);
        }
    }
}