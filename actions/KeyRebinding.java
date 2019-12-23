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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 */
public class KeyRebinding extends AbstractAction {

    private final String targetName;
    private final String target;
    private final Class<?> filter;

    private final  ObserverService observer;

    public KeyRebinding(String targetName, String target, Class<?> filter, ObserverService observer) {
        this.targetName = targetName;
        this.target = target;
        this.filter = filter;
        this.observer = observer;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = this.observer.getObjectByName(this.targetName);

        JComponent object = this.observer.getObjectByName(this.target);

        Map<String, KeyStroke> newKey = new HashMap<>();
        for (Component component : object.getComponents()) {
            if (filter.isInstance(component)) {

                newKey.put(component.getName(), KeyStroke.getKeyStroke((String) ((JComboBox)component).getSelectedItem()));
            }
        }

        InputMap iMap = ((JComponent) obj).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        iMap.clear();
        newKey.keySet().forEach(el -> 
            iMap.put(newKey.get(el), el)
        );

    }

}
