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

import com.pityubak.gamelibrary.components.SwingEntity;
import static com.pityubak.gamelibrary.misc.DrawingType.*;
import java.awt.Graphics;

/**
 *
 * @author Pityubak
 */
public class DrawConvertService {

    private DrawConvertService() {
    }

    public static void convert(SwingEntity entity, Graphics g) {

        switch (entity.getDrawingType()) {
            case FILL_RECT:
                g.fillRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
                break;
            case FILL_3DRECT:
                g.fill3DRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), true);
                break;
            case FILL_OVAL:
                g.fillOval(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
                break;
            case FILL_ARC:
                g.fillArc(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), 0, 0);
                break;
            case DRAW_RECT:
                g.drawRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
                break;
            case DRAW_3DRECT:
                g.draw3DRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), true);
                break;
            case DRAW_OVAL:
                g.drawOval(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
                break;
            case DRAW_ARC:
                g.drawArc(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), 0, 0);
                break;
            case DRAW_IMAGE:
                //Image img=entity.getImage().getScaledInstance(entity.getWIDTH(), entity.getHEIGHT(), Image.SCALE_DEFAULT);

                g.drawImage(entity.getImage(), entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), null);
                break;
            default:
                break;
        }
    }
}
