/*
 *
 *  * Copyright 2013 Jive Software
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package com.jivesoftware.addon.example;

import com.jivesoftware.addon.example.service.health.HealthService;
import com.jivesoftware.addon.example.storage.file.services.StorageService;
import com.jivesoftware.sdk.JiveAddOnApplication;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@Component
@Singleton
@ApplicationPath("example")
public class MyExampleAddOn extends JiveAddOnApplication {

    /****************************************************************
     *  see: applicationContext.xml for Configuration Instructions
     ****************************************************************/
    public MyExampleAddOn() {
        super();
        
        this.register(MultiPartFeature.class);

        /*** SCAN PACKAGES FOR SERVICES TO AUTO-WIRE, USING CLASS INSTEAD OF STRING FOR REFACTOR SIMPLICITY ***/
        packages(true,HealthService.class.getPackage().getName());
        packages(true,StorageService.class.getPackage().getName());
    } // end constructor

} // end class