/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.document;

/**
 * Factory class used to create the instance of the output document.
 * 
 * @author Daniele
 */
public class DocumentFactory {
    
    /**
     * Defualt constructor (this is meant to be
     * a singleton class).
     */
    private DocumentFactory() {}
    
    /**
     * Returns the instance of DocumentFactory stored in df
     * if it isn't null.
     * @return The istance of DocumentFactory.
     */
    public DocumentFactory getDocumentFactory(){
        if (df == null)
            df = new DocumentFactory();
        return df;
    }
    
    /**
     * Creates and returns an instance of Document to be compiled.
     * 
     * @param type Type of the output document (see DocumentCostantTypes interface).
     * @return An instance of Document (a class that implements the Document interface).
     */
    public Document newDocument(int type) {
        
        switch(type) {
            case DocumentCostantTypes.PDF_DOCUMENT:
                return new DocumentPDF();
            
            //Others to come...
                
            default:
                return null;
        }
    }
    
    //Instance variables
    private DocumentFactory df;
}
