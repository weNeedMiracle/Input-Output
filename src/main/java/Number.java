import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Number {
    public Number(String out, String in) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(out));
        XSSFSheet one = wb.getSheetAt(0);
        Pattern p = Pattern.compile("^(\\d{1}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{2}[\\s.-]?\\d{2}$");
        FileWriter n = new FileWriter(in);
        for(int i = 0; i<one.getLastRowNum(); i++){
            String b = String.valueOf(one.getRow(i).getCell(0));
            if(b.matches(String.valueOf(p))){
                n.write(b+"\n");
                n.flush();
            }
        }
    }
}
