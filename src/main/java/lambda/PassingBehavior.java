package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PassingBehavior {

    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {

        String oneLine = processFile((BufferedReader br)->
                br.readLine());

        String twoLine = processFile((BufferedReader br)->
                br.readLine() + br.readLine());
    }
}
