/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

/**
 *
 * @author Administrator
 */
public class VGBException extends Exception {

    /**
     * Creates a new instance of <code>VGBException</code> without detail
     * message.
     */
    public VGBException() {
    }

    /**
     * Constructs an instance of <code>VGBException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public VGBException(String msg) {
        super(msg);
    }

    public VGBException(String message, Throwable cause) {
        super(message, cause);
    }

    public VGBException(Throwable cause) {
        super(cause);
    }
    
    
}
