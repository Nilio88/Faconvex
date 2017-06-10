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
import org.apache.pdfbox.pdmodel.font.PDFont;
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
        page = new PDPage();
        pdfDocument.addPage(page);
        content = new PDPageContentStream(pdfDocument, page);
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
        
        //Get information for centering the title
        int marginTop = 20;
        PDFont titleFont = PDType1Font.HELVETICA_BOLD;
        int titleFontSize = 25;
        float titleWidth = titleFont.getStringWidth(outTitle) / 1000 * titleFontSize;
        float titleHeight = titleFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * titleFontSize;
        
        //Print the title in the PDF document
        content.beginText();
        content.setFont(titleFont, titleFontSize);
        content.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
        content.showText(outTitle);
        content.newLine();
        content.newLine();
        content.endText();
    }
    
    public void addOwnerMessage(Message message) throws IOException {
        //Convert the message into a string to be printed on the PDF document
        String outMessage = message.getSender() + " at " + message.getDate() + "\n" + message.getMessage();
        
        //Initialize the font size and type for the message
        PDFont messageFont = PDType1Font.TIMES_ROMAN;
        int messageFontSize = 16;
        
        //Initialize information for right-aligning the message
        float messageWidth = (messageFont.getStringWidth(outMessage) / 1000.0f) * messageFontSize;
        
        //Print the message on the PDF document
        content.beginText();
        content.setFont(messageFont, messageFontSize);
        content.moveTextPositionByAmount(-messageWidth, 0);
        content.showText(outMessage);
        content.moveTextPositionByAmount(messageWidth, 0);
        content.newLine();
        content.newLine();
        content.endText();
    }
    
    public void addRecipientMessage(Message message) throws IOException {
        //Convert the message into a string to be printed on the PDF document
        String outMessage = message.getSender() + " at " + message.getDate() + "\n" + message.getMessage();
        
        //Initialize the font size and type for the message
        PDFont messageFont = PDType1Font.TIMES_ROMAN;
        int messageFontSize = 16;
        
        //Print the message on the PDF document (left-aligned)
        content.beginText();
        content.setFont(messageFont, messageFontSize);
        content.showText(outMessage);
        content.newLine();
        content.newLine();
        content.endText();
    }
    
    public void close(File outputFile) throws IOException {
        content.close();
        pdfDocument.save(outputFile);
        pdfDocument.close();
    }
    
    //Instance variables
    private PDDocument pdfDocument;
    private PDPageContentStream content;
    private PDPage page;
}
