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

import com.pityubak.liberator.data.RuntimeObject;

import com.pityubak.liberator.annotations.MethodBox;
import com.pityubak.liberator.annotations.MethodElement;
import com.pityubak.liberator.misc.MethodFlag;
import com.pityubak.liberator.misc.ModificationFlag;
import com.pityubak.gamelibrary.actions.DownMove;
import com.pityubak.gamelibrary.actions.Exit;
import com.pityubak.gamelibrary.actions.KeyRebinding;
import com.pityubak.gamelibrary.actions.LeftMove;
import com.pityubak.gamelibrary.actions.Level;
import com.pityubak.gamelibrary.actions.Reset;
import com.pityubak.gamelibrary.actions.RightMove;
import com.pityubak.gamelibrary.actions.UpMove;
import com.pityubak.gamelibrary.annotations.Action;
import com.pityubak.gamelibrary.annotations.Actions;

import com.pityubak.gamelibrary.components.SwingEntity;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import com.pityubak.gamelibrary.annotations.Binding;
import com.pityubak.gamelibrary.annotations.Bindings;
import com.pityubak.gamelibrary.misc.PredefinedAction;
import java.util.HashMap;
import java.util.Map;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 *
 */
@MethodBox
public final class ActionBinding {

    private final ActionService handler = new SwingActionService();

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_VALUE, flag = ModificationFlag.PRIORITY_NORMAL)
    public void registerAction(Actions actions, ObserverService observer, JComponent c) {

        Map<String, KeyStroke> keys = new HashMap<>();
        for (Action a : actions.value()) {
            System.out.println(a);
            try {
                InputMap iMap = c.getInputMap(a.condition());
                ActionMap aMap = c.getActionMap();
                iMap.put(KeyStroke.getKeyStroke(a.key(), 0), a.actionName());
                aMap.put(a.actionName(), handler.getAction(a.action()));
                keys.put(a.actionName(), KeyStroke.getKeyStroke(a.key(), 0));
            } catch (NullPointerException ex) {
                //Missing Logger!!
                System.err.println(ex);
            }
        }
        observer.registration("keys", RuntimeObject.class, new RuntimeObject(keys));
    }

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_VALUE, flag = ModificationFlag.PRIORITY_NORMAL)
    public void registerAction(Action action, ObserverService observer, JComponent c) {

        Map<String, KeyStroke> keys = new HashMap<>();

        try {
            InputMap iMap = c.getInputMap(action.condition());
            ActionMap aMap = c.getActionMap();
            iMap.put(KeyStroke.getKeyStroke(action.key(), 0), action.actionName());
            aMap.put(action.actionName(), handler.getAction(action.action()));
            keys.put(action.actionName(), KeyStroke.getKeyStroke(action.key(), 0));
        } catch (NullPointerException ex) {
            //Missing Logger!!
            System.err.println(ex);
        }

        observer.registration("keys", RuntimeObject.class, new RuntimeObject(keys));
    }

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_NAME, flag = ModificationFlag.PRIORITY_HIGH)
    public void finalizeActionBinding(Bindings targets, ObserverService observer, String targetName) {
        Object component = observer.getObjectByName(targetName);
        for (Binding target : targets.value()) {
            System.out.println(target);
            switchByActionType(component, target, targetName, observer);

        }

    }

    private void switchByActionType(Object component, Binding target, String targetName, ObserverService observer) {
        if (component instanceof AbstractButton) {

            bindAbstractBtn(target, targetName, observer, component);

        } else {
            AbstractAction concreteAction = null;
            if (component instanceof SwingEntity) {
                concreteAction = bindSwingEntity(target, component);
            } else if (component instanceof JComponent) {

                if (target.actionType().equals(PredefinedAction.LEVEL)) {
                    Level menu = new Level(target.targetName() != null
                            ? target.targetName() : targetName, target.parent(),
                            target.targetVar(), observer);

                    concreteAction = menu;
                }

            }

            handler.addAction(target.actionName(), concreteAction);

        }
    }

    private AbstractAction bindSwingEntity(Binding target, Object component) {
        AbstractAction concreteAction;
        switch (target.actionType()) {
            case DOWN_MOVE:
                concreteAction = new DownMove((SwingEntity) component, target.speed());
                break;
            case UP_MOVE:
                concreteAction = new UpMove((SwingEntity) component, target.speed());
                break;
            case LEFT_MOVE:
                concreteAction = new LeftMove((SwingEntity) component, target.speed());
                break;
            case RIGHT_MOVE:
                concreteAction = new RightMove((SwingEntity) component, target.speed());
                break;

            default:
                concreteAction = null;
                break;
        }
        return concreteAction;
    }

    private void bindAbstractBtn(Binding target, String targetName, ObserverService observer, Object component) {
        System.out.println(target.actionType());
        switch (target.actionType()) {

            case LEVEL:
                Level menu = new Level(target.targetName() != null
                        ? target.targetName() : targetName, target.parent(),
                        target.targetVar(), observer);

                ((AbstractButton) component).addActionListener(menu);
                break;
            case EXIT:
                ((AbstractButton) component).addActionListener(new Exit(target.targetName(), observer));
                break;
            case KEY_REBINDER:
                KeyRebinding binder = new KeyRebinding(target.targetName(), target.parent(),
                        target.filter(), observer);

                ((AbstractButton) component).addActionListener(binder);
                break;
            case RESET:
                Reset reset = new Reset(target.resetComponents(), observer);

                ((AbstractButton) component).addActionListener(reset);
                break;
            default:
                break;

        }
    }

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_NAME, flag = ModificationFlag.PRIORITY_HIGH)
    public void finalizeActionBinding(Binding targets, ObserverService observer, String targetName) {
        Object component = observer.getObjectByName(targetName);

        System.out.println(targets);
        switchByActionType(component, targets, targetName, observer);

    }

}
