/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.annotations;

import com.pityubak.liberator.annotations.Register;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.JComponent;

/**
 *
 * @author Pityubak
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Actions.class)
@Register
public @interface Action {
    int key();
    String actionName();
    String action();
    int condition() default JComponent.WHEN_IN_FOCUSED_WINDOW;
}
