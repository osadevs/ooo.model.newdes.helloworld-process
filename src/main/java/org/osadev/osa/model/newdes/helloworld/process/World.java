/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--> 
<!--                Open Simulation Architecture (OSA)                  -->
<!--                                                                    -->
<!--      This software is distributed under the terms of the           -->
<!--           CECILL-C FREE SOFTWARE LICENSE AGREEMENT                 -->
<!--  (see http://www.cecill.info/licences/Licence_CeCILL-C_V1-en.html) -->
<!--                                                                    -->
<!--  Copyright © 2006-2015 Université Nice Sophia Antipolis            -->
<!--  Contact author: Olivier Dalle (olivier.dalle@unice.fr)            -->
<!--                                                                    -->
<!--  Parts of this software development were supported and hosted by   -->
<!--  INRIA from 2006 to 2015, in the context of the common research    -->
<!--  teams of INRIA and I3S, UMR CNRS 7172 (MASCOTTE, COATI, OASIS and -->
<!--  SCALE).                                                           -->
<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**/
package org.osadev.osa.model.newdes.helloworld.process;

import org.objectweb.fractal.fraclet.annotations.Component;
import org.objectweb.fractal.fraclet.extensions.Membrane;

import org.osadev.osa.logger.newdes.SimulationLogger;
import org.osadev.osa.simapis.modeling.ModelingTimeAPI;
import org.osadev.osa.simapis.wrappers.llong.ModelingTime;
import org.osadev.osa.simapis.wrappers.llong.ProcessModel;

@Component
@Membrane(controller = "simPrimitive")
public class World extends ProcessModel implements WorldItf {

	public World() {
		super(new SimulationLogger<Long>(World.class));
	}

	
	public void waitHello(String cond) {
		ModelingTimeAPI<Long> start = getSimulationTime();
		logger_.debug("Before waiting at t={} on cond={}", start,cond);
		String msg = waitOnConditionForDelayNoE(cond, ModelingTime.getFactory().create(10L));
		if (msg == null) 
			logger_.debug("Wait on condition={} expired!",cond);
		else 
			logger_.info(msg);

		ModelingTimeAPI<Long> end = getSimulationTime();
		logger_.debug("World(start={}): finished work at t={}", start, end);
	}

}

// Before = 8 + wait =18
// Before = 10 + wait = 20
// Before = 12 + wait = 22
// Before = 12 + wait = 22
// World = 18 (was 8)
// Finished = 18 (was 8)
// Before = 20 + wait = 30
// World = 20 (was 10)
// Finished = 20 (was 10)
// Before = 22 + wait = 32
// World = 22 (was 12)
// World = 22 (was 12)
// Finished = 22 (was 12)
// Finished = 22 (was 12)
// World = 30 (was 20)
// Finished = 30 (was 20)
// World = 32 (was 22)
// Finished = 32 (was 22)
