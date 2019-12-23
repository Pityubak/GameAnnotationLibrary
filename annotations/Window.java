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
import javax.swing.JFrame;



/**
 *
 * @author Pityubak

 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Register
public @interface Window {

    String title() default "Main Window";
    int width() default 0;
    int height() default 0;
    int defaultCloseOperation() default JFrame.DO_NOTHING_ON_CLOSE;
    ColorType backGroundColor() default ColorType.BLUE;
    ColorType foreGroundColor() default ColorType.BLACK;
    boolean undecorated() default false;
}
