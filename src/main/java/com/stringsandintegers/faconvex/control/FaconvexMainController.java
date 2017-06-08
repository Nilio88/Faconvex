/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.control;

import com.stringsandintegers.faconvex.view.*;
import com.stringsandintegers.faconvex.model.Conversation;
import com.stringsandintegers.faconvex.model.ConversationsList;
import com.stringsandintegers.faconvex.document.Document;
import com.stringsandintegers.faconvex.document.DocumentFactory;
import javax.swing.DefaultListModel;
import java.io.File;
import java.util.List;

/**
 *
 * @author Daniele Porcelli
 */
public class FaconvexMainController {
    
    /**Reads the contents of the input file,
     * creates the conversations entity and creates
     * a DefaultListModel with the conversations found
     * in the file.
     * @param conversationsFile: the conversations' file to open;
     * @return a DefaultListModel containing the conversations found;
     * @throws Exception if an error occurs.
     */
    public static DefaultListModel<String> openFile(File conversationsFile) throws Exception {
        //Sends to the ConversationsList entity the messagge for loading the conversations' file
        ConversationsList.loadFile(conversationsFile);
        
        //Retrieves the loaded conversations' list and populates the DefaultListModel
        DefaultListModel<String> conversations = new DefaultListModel();
        for(Conversation conv: ConversationsList.getConversations()) {
            conversations.addElement(conv.getHead());
        }
        return conversations;
    }
    
    /**Exports the selected conversation in
     * a file format according the parameter given in input.
     * @param conversationIndex: the index of the conversation to export;
     * @param format: the format of the file to export. The possible values are stored in the DocumentCostantTypes interface.
     * @throws Exception if an error occurs during the process.
     */
    public static void exportConversation(int conversationIndex, int format) throws Exception {
        //Create a blank output document using the DocumentFactory
        DocumentFactory documentFactory = DocumentFactory.getDocumentFactory();
        Document outputDocument = documentFactory.newDocument(format);
        
        //Get the conversation to export
        List<Conversation> conversations = ConversationsList.getConversations();
        Conversation conversationToExport = conversations.get(conversationIndex);
        
        //Add a title to the output document (in this case it's the header of the conversation)
        outputDocument.addTitle(conversationToExport.getHead());
    }
}
