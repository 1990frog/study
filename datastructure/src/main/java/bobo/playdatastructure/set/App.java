package bobo.playdatastructure.set;

import java.util.ArrayList;

public class App {

    private static final String PRIDE_AND_PREJUDICE = "/home/cai/Code/Java/study/datastructure/src/main/java/bobo/playdatastructure/set/resource/pride-and-prejudice.txt";
    private static final String A_TALE_OF_TWO_CITIES = "/home/cai/Code/Java/study/datastructure/src/main/java/bobo/playdatastructure/set/resource/a-tale-of-two-cities.txt";
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile(PRIDE_AND_PREJUDICE, words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile(A_TALE_OF_TWO_CITIES, words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
