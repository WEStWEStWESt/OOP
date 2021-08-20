package com.oop.examples.scope;

import com.oop.examples.PrintUtils;
import com.oop.examples.scope.impl.ExtendedClass;

public class Scopes {

    public static void main(String[] args) {
        PrintUtils.print(ScopeClass.PUBLIC_CONST, ScopeClass.class);
        PrintUtils.print(ScopeClass.PROTECTED_CONST, ScopeClass.class);
        PrintUtils.print(ScopeClass.PACKAGE_CONST, ScopeClass.class);
        PrintUtils.printStaticPrivate("PRIVATE_CONST", ScopeClass.class);

        ScopeClass scopeClass = new ScopeClass();
        scopeClass.print();

        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.printProtected();

        scopeClass.printPackagePrivate();
    }
}
