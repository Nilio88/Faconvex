/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.document;

import com.stringsandintegers.faconvex.model.Message;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * This class creates a PDF file
 * @author Daniele
 */
class DocumentPDF implements Document {
    
    /**
     * Default constructor. It creates a new blank
     * PDF document with a blank page and initializes
     * the page content stream.
     * @throws IOException if an error occured during the initialization of the stream. 
     */
    DocumentPDF() throws IOException {
        pdfDocument = new PDDocument();
        PDPage firstPage = new PDPage();
        pdfDocument.addPage(firstPage);
        content = new PDPageContentStream(pdfDocument, firstPage);
    }
    
    public void addTitle(String title) throws IOException {
        //Get the interlocutors of the conversation
        String interlocutors[] = title.split(",");
        
        //Create the title to be printed on the document to export
        String outTitle = null;
        
        if (interlocutors.length == 2)
            outTitle = "Conversation between " + interlocutors[0] + " and " + interlocutors[1];
        else {
            outTitle = "Conversation among " + interlocutors[0];
            for(int i = 1; i <interlocutors.length; i++) {
                outTitle += "," + interlocutors[i];
            }
        }
        
        //Print the title in the PDF document
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 25);
        content.showText(outTitle);
        content.newLine();
        
    }
    
    public void addOwnerMessage(Message message) throws IOException {
        
    }
    
    public void addRecipientMessage(Message message) throws IOException {
        
    }
    
    public void close(File outputFile) throws IOException {
        content.close();
        pdfDocument.save(outputFile);
        pdfDocument.close();
    }
    
    //Instance variables
    private PDDocument pdfDocument;
    private PDPageContentStream content;
}
