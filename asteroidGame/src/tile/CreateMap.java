package tile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateMap {
    public static void cM() {

        Random rand = new Random();
        int r;
        int seed[] = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int seedLen = seed.length;

        File file = new File("/res/maps/world.txt");
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            for ( int col = 0; col < 50; col++ ) {
                for ( int row = 0; row < 50; row++ ) {
                    r = rand.nextInt(seedLen);
                    myWriter.write(seed[r] + " ");
                }
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
