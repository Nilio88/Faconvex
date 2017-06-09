/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.document;

import com.stringsandintegers.faconvex.model.Message;
import java.io.File;
import java.io.IOException;

/**
 * This interface is used by the controller for
 * compiling the output document with the messages
 * to export.
 * It's an abstraction about the actual document: it can
 * be a PDF, HTML, DOC (or other) file.
 * @author Daniele
 */
public interface Document {
    
    public void addTitle(String title) throws IOException;
    public void addRecipientMessage(Message message) throws IOException;
    public void addOwnerMessage(Message message) throws IOException;
    public void close(File outputFile) throws IOException;
}
