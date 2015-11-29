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
import org.objectweb.fractal.fraclet.annotations.Requires;
import org.objectweb.fractal.fraclet.extensions.Membrane;

import org.osadev.osa.logger.newdes.SimulationLogger;
import org.osadev.osa.simapis.wrappers.llong.ModelingTime;
import org.osadev.osa.simapis.wrappers.llong.ProcessModel;

/**
 * Hello part of the hello-world example.
 * 
 * <p> Implements the business part of the Hello component. The
 * control part is generated automatically using AOP techniques 
 * such as AspectJ or Spoon visitors.
 * 
 * <p>This hello world version illustrates the process-oriented API 
 * of OSA. A Process can use primitives to wait for a given delay
 * and synchronize with other processes on "conditions". A condition
 * is an arbitrary name that is used to distinguish wait queues.
 * 
 * @author odalle
 *
 */
@Component
@Membrane(controller = "simPrimitive")
public class Hello extends ProcessModel implements HelloItf{
	
	
	public Hello() {
		super(new SimulationLogger<Long>(Hello.class));
	}

	@Requires(name = "world")
	private WorldItf addWorld;

	
	public void releaseWorld(String message) {
		logger_.debug("Waiting for 10 seconds...");
		waitForDelay(ModelingTime.getFactory().create(10L));
		logger_.debug("Waking up. Running releaseWorld()...");
		releaseOneOnCondition("print", message);
	}

	
	public void releaseAllWorld(String message) {
		logger_.debug("Running releaseAllOnCond(print1)...");
		releaseAllOnCondition("print1", message);
		logger_.debug("Waiting for 10 seconds...");
		waitForDelay(ModelingTime.getFactory().create(5L));
		logger_.debug("Running releaseAllOnCond(print2)...");
		releaseAllOnCondition("print2", message);
	}
	
}
