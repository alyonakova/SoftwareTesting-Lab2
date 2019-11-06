import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public void write(String file, double x, double result) {
        try {
            FileWriter fwriter = new FileWriter(file, true);
            String text = x + ";" + result + "\n";
            fwriter.write(text);
            fwriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
