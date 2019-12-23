/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.actions;

import com.pityubak.liberator.data.ObserverService;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 * @author Pityubak
 */
public class Exit extends AbstractAction{

    private final String targetFrame;
    
    private final  ObserverService observer;

    public Exit(String targetFrame, ObserverService observer) {
        this.targetFrame = targetFrame;
        this.observer = observer;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame=this.observer.getObjectByName(this.targetFrame);
        frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
    }
    
}
