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

import com.pityubak.gamelibrary.misc.ColorType;
import com.pityubak.gamelibrary.misc.DrawingType;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Pityubak
 */
public class SwingEntity {

    private int x;
    private int y;
    private int width;
    private int height;
    private ColorType color;
    private DrawingType drawingType;
    private int xDir;
    private int yDir;
    private Image image;
    private boolean destroyed ;
    private String imageName;

    public SwingEntity() {
    }

    
    public SwingEntity(SwingEntity entity) {
        this.x = entity.x;
        this.y = entity.y;
        this.width = entity.width;
        this.height = entity.height;
        this.color = entity.color;
        this.drawingType = entity.drawingType;
        this.xDir = entity.xDir;
        this.yDir = entity.yDir;
        this.image = entity.image;
        this.destroyed = entity.destroyed;
        this.imageName = entity.imageName;
    }

    

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    

    public int getX() {
        return x;
    }
    
    
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public DrawingType getDrawingType() {
        return drawingType;
    }

    public void setDrawingType(DrawingType drawingType) {
        this.drawingType = drawingType;
    }

    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public void destroy() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

}
