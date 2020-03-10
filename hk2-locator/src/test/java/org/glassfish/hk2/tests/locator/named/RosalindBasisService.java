/*
 * Copyright (c) 2016, 2018 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.hk2.tests.locator.named;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import org.junit.Assert;

/**
 * This is here to ensure the Rosalind service can be gotten by some
 * service
 * 
 * @author jwells
 *
 */
@Singleton
public class RosalindBasisService {
    @Inject
    public RosalindBasisService(Rosalind rosalind, @Named(NamedTest.ROMEO) CitizenOfVerona romeo) {
        Assert.assertEquals(NamedTest.ROSALIND, rosalind.getName());
        Assert.assertEquals(NamedTest.ROMEO, romeo.getName());
    }

}
