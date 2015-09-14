/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.roaster.model.source;

import java.util.List;

import org.jboss.forge.roaster.model.Method;
import org.jboss.forge.roaster.model.MethodHolder;
import org.jboss.forge.roaster.model.util.Methods;
import org.jboss.forge.roaster.model.util.Types;

/**
 * Represents a {@link JavaSource} that may declare methods.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public interface MethodHolderSource<O extends JavaSource<O>> extends MethodHolder<O>, MemberHolderSource<O>
{

   /**
    * Return the {@link MethodSource} with the given name and zero parameters; otherwise return null.
    */
   @Override
   MethodSource<O> getMethod(final String name);

   /**
    * Return the {@link MethodSource} with the given name and signature types; otherwise return null.
    */
   @Override
   MethodSource<O> getMethod(final String name, String... paramTypes);

   /**
    * Return the {@link MethodSource} with the given name and signature types; otherwise return null.
    */
   @Override
   MethodSource<O> getMethod(final String name, Class<?>... paramTypes);

   /**
    * Get a {@link List} of all {@link MethodSource}s declared by this {@link O} instance, if any; otherwise, return an
    * empty {@link List}
    */
   @Override
   List<MethodSource<O>> getMethods();

   /**
    * Add an uninitialized {@link MethodSource} declaration to this {@link O} instance. This {@link MethodSource} will
    * be a stub until further modified.
    */
   MethodSource<O> addMethod();

   /**
    * Add a new {@link MethodSource} declaration to this {@link O} instance, using the given {@link String} as the
    * method declaration.
    * <p/>
    * <strong>For example:</strong><br>
    * <code>Method m = javaClass.addMethod("public String method() {return \"hello!\";}")</code>
    */
   MethodSource<O> addMethod(final String method);

   /**
    * Add a new {@link MethodSource} declaration to this {@link O} instance, using the given
    * {@link java.lang.reflect.Method} as the method declaration.
    * 
    * Abstract {@link java.lang.reflect.Method} objects are implemented in this method.
    * 
    * @param method The {@link java.lang.reflect.Method} to be added
    * @return the method implementation based on the {@link java.lang.reflect.Method} parameter. The generated method
    *         body (unless the origin is an interface) returns the default value for the return type as defined in
    *         {@link Types#getDefaultValue(Class)}.
    * @see Methods#addInheritedAbstractMethods(Class, MethodHolderSource)
    * @see Types#getDefaultValue(Class)
    */
   MethodSource<O> addMethod(final java.lang.reflect.Method method);

   /**
    * Remove the given {@link MethodSource} declaration from this {@link O} instance, if it exists; otherwise, do
    * nothing.
    */
   O removeMethod(final Method<O, ?> method);

}