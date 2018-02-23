package com.github.java5wro.email;


import net.glxn.qrgen.QRCode;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;


import java.io.IOException;

public class PdfGenerator {
    public static void main(String[] args) throws IOException {
        PdfGenerator stefan = new PdfGenerator();
        stefan.createPdf();
    }

    public byte[] createPdf() throws IOException {


        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.HELVETICA_BOLD;

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"

        String eventTitle = "***Event name***";


// EVENT
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.moveTextPositionByAmount(100, 750);
        contentStream.drawString("Event:");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 24);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString(eventTitle);
        contentStream.endText();
//USER

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.moveTextPositionByAmount(100, 650);
        contentStream.drawString("Ticket holder:");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 16);
        contentStream.moveTextPositionByAmount(100, 610);
        contentStream.drawString("*** USER NAME ***");
        contentStream.endText();

        QRCodeGenerator qr = new QRCodeGenerator();

        PDImageXObject codeImage = PDImageXObject.createFromByteArray(document, qr.QrGenerator("UUID"), "ticket");

        contentStream.drawImage(codeImage,180, 50);
// Make sure that the content stream is closed:
        contentStream.close();

// Save the results and ensure that the document is properly closed:

        document.save("Ticket.pdf");
        ByteArrayOutputStream attachement = new ByteArrayOutputStream();
        document.save(attachement);
        document.close();
        return attachement.toByteArray();



    }
}
