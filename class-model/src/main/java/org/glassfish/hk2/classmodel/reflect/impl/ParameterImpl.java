/*
 * Copyright (c) 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package org.glassfish.hk2.classmodel.reflect.impl;

import java.util.ArrayList;
import java.util.List;
import org.glassfish.hk2.classmodel.reflect.MethodModel;
import org.glassfish.hk2.classmodel.reflect.Parameter;
import org.glassfish.hk2.classmodel.reflect.Type;
import org.glassfish.hk2.classmodel.reflect.ParameterizedType;

/**
 *
 * @author gaurav.gupta@payara.fish
 */
public class ParameterImpl extends AnnotatedElementImpl implements Parameter {

    private final MethodModel methodModel;

    private TypeProxy<?> type;

    private String typeName;

    private final int index;

    private final List<ParameterizedType> genericTypes = new ArrayList<>();

    public ParameterImpl(int index, String name, TypeProxy<?> type, MethodModel methodModel) {
        super(name);
        this.index = index;
        this.type = type;
        this.methodModel = methodModel;
    }

    public ParameterImpl(int index, String name, MethodModel methodModel) {
        super(name);
        this.index = index;
        this.methodModel = methodModel;
    }

    @Override
    public MethodModel getMethod() {
        return methodModel;
    }

    @Override
    public Type getType() {
        return type.get();
    }

    @Override
    public String getTypeName() {
        if (type == null) {
            return typeName;
        }
        return type.getName();
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public TypeProxy<?> getTypeProxy() {
        return type;
    }

    public void setTypeProxy(TypeProxy<?> type) {
        this.type = type;
    }

    @Override
    public List<ParameterizedType> getGenericTypes() {
        return genericTypes;
    }

    @Override
    protected void print(StringBuffer sb) {
        super.print(sb);
        sb.append(", type =").append(this.getTypeName());
    }

    @Override
    public int getIndex() {
        return index;
    }
}
