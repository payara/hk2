/*
 * Copyright (c) 2012, 2018 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.hk2.tests.locator.proxiable;

import jakarta.inject.Inject;

/**
 * @author jwells
 *
 */
@SeasonScope @SeasonIndicator(ProxiableTest.SPRING)
public class Spring implements Season {
    @Inject
    private @SeasonIndicator(ProxiableTest.SUMMER) Season nextSeason;

    /* (non-Javadoc)
     * @see org.glassfish.hk2.tests.locator.proxiable.Season#getName()
     */
    @Override
    public String getName() {
        return ProxiableTest.SPRING;
    }

    /* (non-Javadoc)
     * @see org.glassfish.hk2.tests.locator.proxiable.Season#getNextSeason()
     */
    @Override
    public Season getNextSeason() {
        return nextSeason;
    }

}
