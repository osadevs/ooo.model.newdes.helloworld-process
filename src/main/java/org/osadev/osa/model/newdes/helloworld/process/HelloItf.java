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

import org.objectweb.fractal.fraclet.annotations.Interface;

@Interface(name = "hello")
public interface HelloItf {

	/**
	 * Waits for 10 seconds and wakes up one process sleeping on the "print"
	 * condition.
	 * 
	 * <p>
	 * This example also illustrates the channel mechanism of the wait-release
	 * mechanism: the waker passes the message string to wakee that will be
	 * printed. Both process synchronize on a common condition, hard coded in the
	 * model (different conditions can be used to implement different independent
	 * channels).
	 * 
	 * @param message 
	 * 		Message to be printed by the componment bound to the world interface
	 * 
	 */
	public void releaseWorld(String message);

	/**
	 * Waits for 10 seconds and wakes up all process sleeping on the "print"
	 * condition.
	 * 
	 * <p>
	 * This example also illustrates the channel mechanism of the wait-release
	 * mechanism: the waker passes the message string to wakee that will be
	 * printed. This version illustrates the use of the "releaseAll" variant that
	 * will wake up all process found blocked on a given channel/condition.
	 * 
	 * <p>
	 * In this method, the releaseAll primitive is called twice with two different
	 * conditions ("print1" and "print2") that correspond to two separate channels.
	 * 
	 * @param message 
	 * 		Message to be printed by the componment bound to the world interface
	 * 
	 */
	public void releaseAllWorld(String message);
}
