/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.annotations;

import com.pityubak.liberator.annotations.Register;
import com.pityubak.gamelibrary.misc.ColorType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.SwingConstants;

/**
 *
 * @author Pityubak
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Register
public @interface Label {

    String text();

    int x() default 0;

    int y() default 0;

    boolean doubleBuffered() default false;

    int width();

    int height();

    ColorType bgColor() default ColorType.WHITE;

    ColorType fgColor() default ColorType.BLACK;

    boolean opaque() default false;

    boolean visible() default true;

    float fontSize() default 12F;

    int horizontal() default SwingConstants.CENTER;

    int vertical() default SwingConstants.CENTER;
}
