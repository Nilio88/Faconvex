/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.model;

/** This class represents the message sent
 * by an interlocutor of the conversation. They can
 * be the owner of the account or their friend.
 * @author Daniele Porcelli
 */
public class Message {
    /** The main constructor of the message
     * 
     */
    public Message() {
        
    }
    
    /**Returns the name of the interlocutor who
     * wrote and sent the message.
     * @return The name of the interlocutor who sent the message.
     */
    public String getSender() {
        return sender;
    }
    
    /**Returns the date when the message was sent.
     * @return The date when the message was sent (string).
     */
    public String getDate() {
        return date;
    }
    
    /**Returns the body of the message.
     * @return The body of the message.
     */
    public String getMessage() {
        return message;
    }
    
    /**Sets the name of the interlocutor who wrote and sent
     * the message.
     * @param aSender: The name of the interlocutor who sent the message.
     */
    public void setSender(String aSender) {
        sender = aSender;
    }
    
    /**Sets the date when the message was sent.
     * @param aDate: The date when the message was sent.
     */
    public void setDate(String aDate) {
        date = aDate;
    }
    
    /**Sets the message sent by the interlocutor.
     * @param aMessage: The message sent.
     */
    public void setMessage(String aMessage) {
        message = aMessage;
    }
    
    //Instance's variables
    private String sender;      //The name of the interlocutor who wrote and sent the message;
    private String date;        //The date when the message was sent;
    private String message;     //The body of the message sent;
}
