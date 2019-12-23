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
import com.pityubak.gamelibrary.annotations.Observeable;

import com.pityubak.liberator.data.StoredData;
import com.pityubak.liberator.misc.MethodFlag;
import com.pityubak.liberator.misc.ModificationFlag;
import com.pityubak.gamelibrary.annotations.Get;
import com.pityubak.liberator.data.ObserverService;

/**
 *
 * @author Pityubak
 */
@MethodBox
public class ObservingService {

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_VALUE, flag = ModificationFlag.PRIORITY_HIGH)
    public <T> void addObserver(Observeable obs, ObserverService observer, T object) {
        StoredData data = new StoredData(object.getClass(), object);
        observer.registrationWithStoredData(obs.value(), data);
    }

    @MethodElement(value = MethodFlag.WITH_OBSERVER_AND_NAME, flag = ModificationFlag.PRIORITY_LOW)
    public RuntimeObject getValue(Get get, ObserverService observer, String name) {
        RuntimeObject object = observer.getObjectByName(get.value());
        object.setName(name);
        object.setObserver(observer);
        return object;
    }
}
