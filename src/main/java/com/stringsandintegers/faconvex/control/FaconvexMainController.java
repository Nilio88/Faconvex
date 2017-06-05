/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.control;

import com.stringsandintegers.faconvex.view.*;
import com.stringsandintegers.faconvex.model.Conversation;
import com.stringsandintegers.faconvex.model.ConversationsList;
import javax.swing.DefaultListModel;
import java.io.File;


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
     * an HTML file format or in a PDF file
     * format according the parameter given in input.
     * @param conversationIndex: the index of the conversation to export;
     * @param format: the format of the file to export. Possible values: <br />-Format_Costants.HTML as HTML file;<br />-Format_Costants.PDF as PDF file;
     * @throws Exception if an error occurs during the process.
     */
    public static void exportConversation(int conversationIndex, int format) throws Exception {
        
    }
}
