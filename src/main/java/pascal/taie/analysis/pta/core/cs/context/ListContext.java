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

package pascal.taie.analysis.pta.core.cs.context;

import pascal.taie.util.AnalysisException;

import java.util.List;

/**
 * List-based contexts. Each context is represented by a list of context elements.
 */
public class ListContext<T> implements Context {

    private final List<T> elements;

    private static final ListContext<?> EMPTY_CONTEXT = new ListContext<>(List.of());

    private ListContext(List<T> elements) {
        this.elements = elements;
    }

    public static Context make() {
        return EMPTY_CONTEXT;
    }

    public static <T> Context make(T e) {
        return new ListContext<>(List.of(e));
    }

    public static <T> Context make(T e1, T e2) {
        return new ListContext<>(List.of(e1, e2));
    }

    @SafeVarargs
    public static <T> Context make(T... elements) {
        if (elements.length == 0) {
            return make();
        } else {
            return new ListContext<>(List.of(elements));
        }
    }

    @Override
    public int getLength() {
        return elements.size();
    }

    @Override
    public Object getElementAt(int i) {
        if (i >= elements.size()) {
            throw new AnalysisException(
                    "Context " + this + " doesn't have " + i + "-th element");
        }
        return elements.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListContext<?> that = (ListContext<?>) o;
        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
