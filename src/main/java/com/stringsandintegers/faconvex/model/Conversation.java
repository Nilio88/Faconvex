/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.model;

import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Daniele Porcelli
 * This class holds the information of a specific conversation
 */
public class Conversation {
    /** Main constructor of the class, it just
     * istantiate a new list of messages.
     */
    public Conversation() {
        messages = new LinkedList<Message>();
    }
    /** Sets the header of the conversation that is the names
     * of the two interlocutors.
     * @param aHead: The head of the conversation.
     */
    public void setHead(String aHead) {
        head = aHead;
    }
    
    /** Returns the header of the conversation that is the names
     * of the two interlocutors.
     * @return The header of the conversation.
     */
    public String getHead() {
        return head;
    }
    
    /**Adds a new messages to this conversation
     * @param aMessage: a Message provided in input.
     */
    public void addMessage(Message aMessage) {
        messages.add(aMessage);
    }
    
    /**Returns the list of messages in this conversation.
     * @return the List of messages in this conversation.
     */
    public List getMessages() {
        return messages;
    }
    
    //Instance's variables
    private String head;               //The header of the conversation;
    private List<Message> messages;    //The list holding the messages;
}
