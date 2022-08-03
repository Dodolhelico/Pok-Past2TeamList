import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDF {

    ArrayList<SheetPokemon> sheetPokemons = new ArrayList<>();
    public static void main(String[] args) throws IOException, DocumentException {

        /* example inspired from "iText in action" (2006), chapter 2 */

        PdfReader reader = new PdfReader("C:\\Users\\d.lamarche\\Desktop\\play-pokemon-vg-team-list-2020.pdf"); // input PDF
        PdfStamper stamper = new PdfStamper(reader,
                new FileOutputStream("C:\\Users\\d.lamarche\\Desktop\\play-pokemon-vg-team-list-2020_modified.pdf")); // output PDF
        BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

        //loop on pages (1-based)


        // get object for writing over the existing content;
        // you can also use getUnderContent for writing in the bottom layer
        PdfContentByte over = stamper.getOverContent(1);

        // write text

        writeFirstName(over, bf, "Dorian");

        writeFamilyName(over, bf, "Lamarche");

        writePlayerID(over, bf, "1625457");

        writeDateOfBirth(over, bf, "08", "10", "1997");


        over.setRGBColorStroke(0x00, 0x00, 0x00);
        over.setLineWidth(5f);
        over.stroke();


        stamper.close();

    }

    private static void writeFirstName(PdfContentByte over, BaseFont bf, String name){
        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(87, 735);   // set x,y position (0,0 is at the bottom left)
        over.showText(name);  // set text
        over.endText();
    }

    private static void writeFamilyName(PdfContentByte over, BaseFont bf, String name){
        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(87, 713);   // set x,y position (0,0 is at the bottom left)
        over.showText(name);  // set text
        over.endText();
    }

    private static void writePlayerID(PdfContentByte over, BaseFont bf, String id){
        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(87, 690);   // set x,y position (0,0 is at the bottom left)
        over.showText(id);  // set text
        over.endText();
    }

    private static void writeDateOfBirth(PdfContentByte over, BaseFont bf, String day, String month, String year){
        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(105, 670);   // set x,y position (0,0 is at the bottom left)
        over.showText(day);  // set text
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(160, 670);   // set x,y position (0,0 is at the bottom left)
        over.showText(month);  // set text
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);    // set font and size
        over.setTextMatrix(205, 670);   // set x,y position (0,0 is at the bottom left)
        over.showText(year);  // set text
        over.endText();
    }

    private void setPoke(ArrayList<SheetPokemon> pokemons){
        sheetPokemons = pokemons;
    }
}
