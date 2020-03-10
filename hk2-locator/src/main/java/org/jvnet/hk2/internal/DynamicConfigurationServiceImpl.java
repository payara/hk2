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

package org.jvnet.hk2.internal;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.Populator;
import org.glassfish.hk2.api.ServiceLocator;

/**
 * @author jwells
 *
 */
@Singleton
public class DynamicConfigurationServiceImpl implements
        DynamicConfigurationService {
    private final ServiceLocatorImpl locator;
    private final Populator populator;
    
    @Inject
    private DynamicConfigurationServiceImpl(ServiceLocator locator) {
        this.locator = (ServiceLocatorImpl) locator;
        populator = new PopulatorImpl(locator, this);
    }

    /* (non-Javadoc)
     * @see org.glassfish.hk2.api.DynamicConfigurationService#createDynamicConfiguration()
     */
    @Override
    public DynamicConfiguration createDynamicConfiguration() {
        return new DynamicConfigurationImpl(locator);
    }

    @Override
    public Populator getPopulator() {
        return populator;
    }

}
