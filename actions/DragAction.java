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
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pityubak
 */
public class DragAction extends MouseAdapter {

    private Point dragPoint;
    private final JPanel panel;
    private JFrame frame;
    private boolean isFirst = true;

    public DragAction(JPanel panel) {
        this.panel = panel;

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        if (this.frame != null) {
            int frameX = this.frame.getLocation().x;
            int frameY = this.frame.getLocation().y;

            if (this.dragPoint != null) {
                int newLocX = e.getX() - this.dragPoint.x;
                int newLocY = e.getY() - this.dragPoint.y;
                this.frame.setLocation(frameX + newLocX, frameY + newLocY);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        this.dragPoint = e.getPoint();

        if (isFirst) {
            Component parent = panel.getParent();

            while (!(parent instanceof JFrame)) {
                if (parent != null) {
                    parent = parent.getParent();
                }
            }
            this.frame = (JFrame) parent;
            isFirst = false;
        }
        panel.getComponentAt(this.dragPoint);
    }

}
