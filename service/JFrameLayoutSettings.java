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
package com.pityubak.gamelibrary.service;

import com.pityubak.liberator.annotations.MethodBox;
import com.pityubak.liberator.annotations.MethodElement;
import com.pityubak.liberator.misc.MethodFlag;
import com.pityubak.gamelibrary.actions.DragAction;
import com.pityubak.gamelibrary.annotations.Button;
import com.pityubak.gamelibrary.annotations.ComboBox;
import com.pityubak.gamelibrary.annotations.Entity;
import com.pityubak.gamelibrary.annotations.Label;
import com.pityubak.gamelibrary.annotations.Message;
import com.pityubak.gamelibrary.annotations.Panel;
import com.pityubak.gamelibrary.annotations.Window;
import com.pityubak.gamelibrary.components.SwingEntity;
import com.pityubak.gamelibrary.components.SwingFrame;
import com.pityubak.gamelibrary.components.SwingPanel;
import com.pityubak.gamelibrary.components.SwingText;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 */
@MethodBox
public final class JFrameLayoutSettings {

    @MethodElement(MethodFlag.WITH_OBSERVER)
    public SwingFrame generateWindow(Window window, ObserverService observer) {
        SwingFrame frame = new SwingFrame(observer);
        frame.setBackground(ColorConvertService.convert(window.backGroundColor()));
        frame.setForeground(ColorConvertService.convert(window.foreGroundColor()));
        frame.setTitle(window.title());
        frame.setDefaultCloseOperation(window.defaultCloseOperation());

        frame.setPreferredSize(new Dimension(window.width(), window.height()));
        frame.setUndecorated(window.undecorated());
        

        return frame;
    }

    @MethodElement
    public JButton makeButton(Button btn) {
        JButton button = new JButton();
        
        button.setText(btn.text());
        
        button.setDoubleBuffered(true);
        button.setBackground(ColorConvertService.convert(btn.bgColor()));
        button.setSize(btn.width(), btn.height());
        if (!btn.toolTipText().equals("Tooltip1")) {
            button.setToolTipText(btn.toolTipText());
        }
        button.setLocation(btn.x(), btn.y());
        button.setForeground(ColorConvertService.convert(btn.fgColor()));

        return button;
    }

    @MethodElement
    public SwingText getText(Message m) {
        SwingText text = new SwingText();
        text.setMessage(m.message());
        text.setWidth(m.width());
        text.setHeight(m.height());
        text.setColor(ColorConvertService.convert(m.color()));
        return text;
    }

    @MethodElement
    public JLabel makeLabel(Label label) {
        JLabel lbl = new JLabel();
        lbl.setText(label.text());
        lbl.setVerticalAlignment(label.vertical());
        lbl.setHorizontalAlignment(label.horizontal());
        lbl.setSize(label.width(), label.height());
        lbl.setLocation(label.x(), label.y());
        
        lbl.setFont(lbl.getFont().deriveFont(label.fontSize()));
        lbl.setOpaque(label.opaque());
        lbl.setBackground(ColorConvertService.convert(label.bgColor()));
        lbl.setForeground(ColorConvertService.convert(label.fgColor()));
        return lbl;
    }

    @MethodElement(MethodFlag.WITH_OBSERVER)
    public SwingPanel makePanel(Panel p, ObserverService observer) {
        SwingPanel panel = new SwingPanel(observer);
        if (p.width() != -1 || p.height() != -1) {
            panel.setPreferredSize(new Dimension(p.width(), p.height()));
            panel.setMaximumSize(new Dimension(p.width(), p.height()));
        }
        panel.setBackground(ColorConvertService.convert(p.bgColor()));
        panel.setForeground(ColorConvertService.convert(p.fgColor()));
        if (p.draggable()) {
    
            DragAction action = new DragAction(panel);
            panel.addMouseListener(action);
            panel.addMouseMotionListener(action);

        }
        panel.setDoubleBuffered(true);
        panel.setLayout(null);
        return panel;
    }

    @MethodElement
    public SwingEntity makeEntity(Entity e) {
        SwingEntity base = new SwingEntity();
        base.setX(e.x());
        base.setY(e.y());
        base.setxDir(e.xDir());
        base.setyDir(e.yDir());
        base.setColor(e.color());
        base.setDrawingType(e.draw());
        base.setHeight(e.height());
        base.setWidth(e.width());
        try {
            ImageIcon icon = new ImageIcon(this.getClass().getResource(e.image()));

            base.setImage(icon.getImage());
            base.setImageName(e.image());
        } catch (Exception ex) {
            System.err.println(ex);
        }

        return base;
    }

    @MethodElement(MethodFlag.WITH_NAME)
    public JComboBox makeCombo(ComboBox combo, String name) {
        JComboBox box = new JComboBox();
        box.setLocation(combo.x(), combo.y());
        box.setSize(combo.width(), combo.height());
        box.setOpaque(combo.opaque());
        box.setFont(box.getFont().deriveFont(combo.fontSize()));
        box.setForeground(ColorConvertService.convert(combo.fgColor()));
        box.setBackground(ColorConvertService.convert(combo.bgColor()));
        box.setName(name);
        return box;
    }

}
