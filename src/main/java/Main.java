import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            Number n = new Number("E:\\try\\1.xlsx", "E:\\try\\1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

