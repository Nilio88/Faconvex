/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Daniele Porcelli
 * This class holds the conversations extracted from the "messages.html" file.
 */
public class ConversationsList {
    
    /** Opens the messages.html file and collects the information
     * inside it to populate the conversations list.
     * @param messagesFile: the messages.html file from which to collect the
     * information of the conversations.
     * @throws Exception if an error occurs.
     */
    public static void loadFile(File messagesFile) throws Exception {
        //Instantiate a new List in which conversations will be held
        LinkedList<Conversation> conversations = new LinkedList();
        
        //Creates the Document object from which extract the conversations
        Document docObject = Jsoup.parse(messagesFile, "UTF-8");
        
        //Starts the search process to find the conversations to extract
        Element body = docObject.body();
        Element contents = body.select("div.contents").first();
        Element mainDiv = contents.select("div").first();
        
        //Starts iterating the conversations (also known as threads)
        Elements threads = mainDiv.select("div.thread");
        for (Element thread: threads) {
           
            //Creates a new conversation and sets its header
            Conversation conversation = new Conversation();
            conversation.setHead(thread.ownText());
            
            //Iterates, extracts and stores the information on each message
            for (Element msg: thread.select("div.message")) {
               
                //Creates a new Message and sets its sender and date
                Message message = new Message();
                Element msgHeader = msg.select("div.message_header").first();
                
                //Sets the sender
                message.setSender(msgHeader.select("span.user").first().ownText());
                
                //Sets the date
                message.setDate(msgHeader.select("span.meta").first().ownText());
                
                //Sets the body of the message
                message.setMessage(msg.nextElementSibling().ownText());
                
                //Adds the message to the conversation
                conversation.addMessage(message);
            }
            
            //Adds the conversation extracted to the list
            conversations.add(conversation);
        }
        //Assigns the conversations list extracted to the static variable thus making it persistent
        conversationsList = conversations;
        
        //Find the owner of the messages file
        findOwner();
    }
    
    /** Return the conversations list extracted from the file.
     * @return A List instance containing the conversations extracted.
     */
    public static List<Conversation> getConversations() {
        return conversationsList;
    }
    
    /**
     * Scans the conversations list to find the owner of the
     * facebook account among the interlocutors found in the
     * messages file.
     */
    private static void findOwner() {
        HashMap<String, Integer> interlocutors = new HashMap();
        
        for(Conversation conversation: conversationsList) {
            String header = conversation.getHead();
            String convInterlocutors[] = header.split(",");
            
            //Trim the name of the interlocutors and add them to the HashMap
            for(String interlocutor: convInterlocutors) {
                interlocutor = interlocutor.trim();
                
                if(interlocutors.containsKey(interlocutor)) {
                    //Increment the associated value
                    int count = interlocutors.get(interlocutor);
                    count++;
                    interlocutors.put(interlocutor, count);
                }
                else {
                    //Add a new Key-Value pair
                    interlocutors.put(interlocutor, 0);
                }
            }
        }
        
        //Find the interlocutor's name whose count is the maximum in the hashmap
        int maxCount = 0;
        String keyToMaxCount = null;
        
        for(Map.Entry<String, Integer> entry : interlocutors.entrySet()) {
            int count = entry.getValue();
            
            if(count > maxCount) {
                keyToMaxCount = entry.getKey();
                maxCount = count;
            }
        }
        
        owner = keyToMaxCount;
    }
    
    /**
     * Returns the owner of the Facebook account.
     * @return The name of the owner of the Facebook account found among the
     * interlocutors of the conversations.
     */
    public static String getOwner() {
        return owner;
    }
    
    //Class variables
    private static List<Conversation> conversationsList = null;
    private static String owner;
}
