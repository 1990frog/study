import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Passing behavior.
 */
public class PassingBehavior {

    /**
     * Process file string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    /**
     * The interface Buffered reader processor.
     */
    @FunctionalInterface
    public interface BufferedReaderProcessor{
        /**
         * Process string.
         *
         * @param b the b
         * @return the string
         * @throws IOException the io exception
         */
        String process(BufferedReader b) throws IOException;
    }

    /**
     * Process file string.
     *
     * @param p the p
     * @return the string
     * @throws IOException the io exception
     */
    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        String oneLine = processFile((BufferedReader br)->
                br.readLine());

        String twoLine = processFile((BufferedReader br)->
                br.readLine() + br.readLine());
    }
}
