/*
 * The MIT License
 *
 * Copyright 2019 Pityubak.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.pityubak.gamelibrary.actions;

import com.pityubak.gamelibrary.components.SwingPanel;
import com.pityubak.liberator.data.RuntimeObject;
import java.awt.event.ActionEvent;
import java.util.NoSuchElementException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 */
public class Level extends AbstractAction {

    private final String target;
    private final String parent;
    private final String targetVar;

    private final ObserverService observer;

    public Level(String target, String parent, String targetVar, ObserverService observer) {
        this.target = target;
        this.parent = parent;
        this.targetVar = targetVar;
        this.observer = observer;
    }

  

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            SwingPanel targetPanel =  observer.getObjectByName(this.target);
            JFrame parentFrame =  observer.getObjectByName(this.parent);
            if (!"".equals(this.targetVar)) {
               
                RuntimeObject object =  observer.getObjectByName(this.targetVar);
                object.set(!(boolean) object.get());
            }
            if (targetPanel == null || parentFrame == null) {
                throw new NoSuchElementException("This field(s) : " + targetPanel + " " + parentFrame + " doesn't/dont exist!");
            }

            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().invalidate();
            parentFrame.getContentPane().add(targetPanel);
            parentFrame.getContentPane().revalidate();
            parentFrame.getContentPane().repaint();

        } catch (NullPointerException ex) {
            System.err.println("Observer is null or field/variable name  is wrong");
        }

    }

 

}
