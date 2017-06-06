/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.document;

import com.stringsandintegers.faconvex.model.Message;

/**
 * This interface is used by the controller for
 * compiling the output document with the messages
 * to export.
 * It's an abstraction about the actual document: it can
 * be a PDF, HTML, DOC (or other) file.
 * @author Daniele
 */
public interface Document {
    
    public void addTitle(String title);
    public void addRecipientMessage(Message message);
    public void addOwnerMessage(Message message);
}
