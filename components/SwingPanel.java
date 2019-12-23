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
package com.pityubak.gamelibrary.components;

import com.pityubak.gamelibrary.service.ColorConvertService;
import com.pityubak.gamelibrary.service.DrawConvertService;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.JPanel;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 */
public class SwingPanel extends JPanel {

    private final List<SwingEntity> base ;
    private final  ObserverService observer;

    //For message drawing
    private TextComponent textComponent;

    public SwingPanel(ObserverService observer) {
        this.base= new ArrayList<>();
        this.observer = observer;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (textComponent != null) {
            textComponent.drawText(g2d);
        }

        Iterator<SwingEntity> it = base.iterator();
        while (it.hasNext()) {
            SwingEntity ent = it.next();
            if (!ent.isDestroyed()) {
                g2d.setColor(ColorConvertService.convert(ent.getColor()));

                DrawConvertService.convert(ent, g2d);
            } else {
                it.remove();
            }
        }

    }

    public void addSwingPanel(String panelName) {

        SwingPanel panel = observer.getObjectByName(panelName);
        if (panel == null) {
            throw new NoSuchElementException("This panel : " + panel + " does not exist!");
        }
        this.add(panel);

    }

    public void addEntity(SwingEntity e) {
        base.add(e);
    }

    public void removeEntity(SwingEntity e) {
        base.remove(e);
    }

    public void setComponent(TextComponent component) {
        this.textComponent = component;
    }

    public void removeTextComponent() {
        this.textComponent = null;
    }

    public void removeAllEntity() {
        this.base.clear();
    }

}
