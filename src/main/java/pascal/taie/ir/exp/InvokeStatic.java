/*
 * Tai-e: A Static Analysis Framework for Java
 *
 * Copyright (C) 2020-- Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020-- Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * Tai-e is only for educational and academic purposes,
 * and any form of commercial use is disallowed.
 * Distribution of Tai-e is disallowed without the approval.
 */

package pascal.taie.ir.exp;

import pascal.taie.ir.proginfo.MethodRef;

import java.util.List;

/**
 * Representation of invokestatic expression, e.g., T.m(...).
 */
public class InvokeStatic extends InvokeExp {

    public InvokeStatic(MethodRef methodRef, List<Var> args) {
        super(methodRef, args);
    }

    @Override
    public String toString() {
        return String.format("%s %s.%s%s", getInvokeString(),
                methodRef.getDeclaringClass(), methodRef.getName(),
                getArgsString());
    }

    @Override
    public String getInvokeString() {
        return "invokestatic";
    }

    @Override
    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
