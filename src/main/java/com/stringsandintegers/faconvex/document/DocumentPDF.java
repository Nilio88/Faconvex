/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.document;

import com.stringsandintegers.faconvex.model.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.text.Alignment;
import rst.pdfbox.layout.text.Constants;
import rst.pdfbox.layout.text.BaseFont;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;

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
        pdfDocument = new rst.pdfbox.layout.elements.Document(Constants.A4, LEFT_MARGIN, RIGHT_MARGIN, TOP_MARGIN, BOTTOM_MARGIN);
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
        Paragraph titleParagraph = new Paragraph();
        titleParagraph.addText(outTitle + "\n\n", TITLE_FONT_SIZE, PDType1Font.HELVETICA_BOLD);
        titleParagraph.setAlignment(Alignment.Center);
        pdfDocument.add(titleParagraph);
    }
    
    public void addOwnerMessage(Message message) throws IOException {
        //Convert the message into a string to be printed on the PDF document
        String outHeader = message.getSender() + " at _" + message.getDate() + "_\n";
        
        //Initialize the font size for the message
        int messageFontSize = 12;
        
        //Print the header on the PDF document
        Paragraph headerParagraph = new Paragraph();
        headerParagraph.addMarkup(outHeader, messageFontSize, BaseFont.Helvetica);
        headerParagraph.setMaxWidth(MESSAGE_BOX_SIZE);   //Set the message box size
        headerParagraph.setAlignment(Alignment.Right);
        pdfDocument.add(headerParagraph, VerticalLayoutHint.RIGHT);
        
        //Print the message on the PDF document
        String outMessage = message.getMessage();
        
        Paragraph ownerParagraph = new Paragraph();
        ownerParagraph.addText(removeNonPrintableChars(outMessage) + "\n\n", messageFontSize, PDType1Font.TIMES_ROMAN);
        ownerParagraph.setMaxWidth(MESSAGE_BOX_SIZE);   //Set the message box size
        ownerParagraph.setAlignment(Alignment.Right);
        pdfDocument.add(ownerParagraph, VerticalLayoutHint.RIGHT);
    }
    
    public void addRecipientMessage(Message message) throws IOException {
        //Convert the message into a string to be printed on the PDF document
        String outHeader = message.getSender() + " at _" + message.getDate() + "_\n";
        
        //Initialize the font size and type for the message
        int messageFontSize = 12;
        
        //Print the header on the PDF document
        Paragraph headerParagraph = new Paragraph();
        headerParagraph.addMarkup(outHeader, messageFontSize, BaseFont.Helvetica);
        headerParagraph.setMaxWidth(MESSAGE_BOX_SIZE);   //Set the message box size
        headerParagraph.setAlignment(Alignment.Left);
        pdfDocument.add(headerParagraph, VerticalLayoutHint.LEFT);
        
        //Print the message on the PDF document (left-aligned)
        String outMessage = message.getMessage();
        
        Paragraph recipientParagraph = new Paragraph();
        recipientParagraph.addMarkup(removeNonPrintableChars(outMessage) + "\n\n", messageFontSize, BaseFont.Times);
        recipientParagraph.setMaxWidth(MESSAGE_BOX_SIZE);   //Set the message box size
        recipientParagraph.setAlignment(Alignment.Left);
        pdfDocument.add(recipientParagraph, VerticalLayoutHint.LEFT);
    }
    
    public void close(File outputFile) throws IOException {
        pdfDocument.save(new FileOutputStream(outputFile));
    }
    
    /**
     * Converts the message in a UTF-8 charset string.
     * @param messageToConvert The message to convert.
     * @return The message converted in UTF-8 charset.
     */
    private String removeNonPrintableChars(String messageToConvert) {
        return messageToConvert.replaceAll("\\p{C}", "?");
    }
    
    //Instance variables
    private rst.pdfbox.layout.elements.Document pdfDocument;
    
    //Class constants
    //Document margins
    private static final int LEFT_MARGIN = 40;
    private static final int RIGHT_MARGIN = 40;
    private static final int TOP_MARGIN = 40;
    private static final int BOTTOM_MARGIN = 40;
    
    //Font sizes
    private static final int TITLE_FONT_SIZE = 20;
    
    //Messsages box size
    private static final int MESSAGE_BOX_SIZE = 250;
}
