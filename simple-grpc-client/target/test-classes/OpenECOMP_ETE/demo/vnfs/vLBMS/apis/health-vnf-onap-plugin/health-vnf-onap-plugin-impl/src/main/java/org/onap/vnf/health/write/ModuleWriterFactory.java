/*
 * Copyright (c) 2016 Cisco and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onap.vnf.health.write;

import static org.onap.vnf.health.ModuleConfiguration.ELEMENT_SERVICE_NAME;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.onap.vnf.health.CrudService;
import io.fd.honeycomb.translate.impl.write.GenericWriter;
import io.fd.honeycomb.translate.write.WriterFactory;
import io.fd.honeycomb.translate.write.registry.ModifiableWriterRegistryBuilder;
import javax.annotation.Nonnull;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.health.vnf.onap.plugin.rev160918.HealthVnfOnapPlugin;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.health.vnf.onap.plugin.rev160918.health.vnf.onap.plugin.params.HealthCheck;

import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

/**
 * Factory producing writers for health-vnf-onap-plugin plugin's data.
 */
public final class ModuleWriterFactory implements WriterFactory {

    private static final InstanceIdentifier<HealthVnfOnapPlugin> ROOT_CONTAINER_ID = InstanceIdentifier.create(HealthVnfOnapPlugin.class);

    /**
     * Injected crud service to be passed to customizers instantiated in this factory.
     */
    @Inject
    @Named(ELEMENT_SERVICE_NAME)
    private CrudService<HealthCheck> crudService;

    @Override
    public void init(@Nonnull final ModifiableWriterRegistryBuilder registry) {

        //adds writer for child node
        //no need to add writers for empty nodes
    	registry.add(new GenericWriter<>(ROOT_CONTAINER_ID.child(HealthCheck.class), new ElementCustomizer(crudService)));
    }
}
