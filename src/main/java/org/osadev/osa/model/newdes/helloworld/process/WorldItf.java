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


@Interface(name = "world")
public interface WorldItf {

	/**
	 * World server with print action delayed by a wait on a condition. 
	 * 
	 * <p> The message received from hello is not passed as a parameter but received from the
	 * wait call, to illustrate the channel mechanism between the releaser and
	 * the releasee(s). 
	 * 
	 * @param
	 * 		The condition (channel name) used to wait.
	 */
	void waitHello(String cond);
}
