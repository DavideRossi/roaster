/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.test.roaster.model;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.Import;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.test.roaster.model.common.NestedInterface;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedInterfaceTest
{
   @Test
   public void testImportNestedInterface()
   {
      JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
      Import imprt = javaClass.addImport(NestedInterface.Callback.class);

      assertEquals(NestedInterface.Callback.class.getCanonicalName(), imprt.getQualifiedName());
   }

   @Test
   public void testImplementNestedInterface()
   {
      JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
      javaClass.addInterface(NestedInterface.Callback.class);

      assertThat(javaClass.getInterfaces()).contains(NestedInterface.Callback.class.getCanonicalName());
   }

}
