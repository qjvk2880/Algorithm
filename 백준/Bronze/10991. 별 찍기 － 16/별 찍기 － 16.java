import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < n - 1 - i){
                        bufferedWriter.write(" ");
                    } else {
                        bufferedWriter.write("* ");
                    }
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
