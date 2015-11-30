# OSA SimAPIs module

## What's OSA?

OSA stands for Open Simulation Architecture.

OSA is primarily intended to be a federating platform for the simulation community: it is designed to favour the integration of new or existing contributions at every level of its architecture.

The platform core supports discrete-event simulation engine(s) built on top of the ObjectWeb Consortium’s Fractal component model: In OSA, the systems to be simulated are modeled and instrumented using Fractal components.

Fractal components offer many advanced and original features, such as multi-programming language support and the ability to share sub-components. In OSA, the event handling is mostly hidden in the controller part of the components, which alleviates noticeably the modeling process, but also ease the replacement of any part of the simulation engine.

Apart the simulation engine, OSA aims at integrating useful tools for modeling, developing, experimenting and analysing simulations.

## OSA Project Modules

OSA is composed of multiples, possibly many, maven sub-projects. However to allow better flexibility, these projects are structurd following a flat structure.

## About this module

This module is a common root for the basic model examples. It does not contain any code.

## Usage

This module contains an OSA model. In order execute a model, you need to set-up an experiment. An experiment consists in assembling a simulation engine, a model, an execution scenario, a runtime configuration, and possibly an instrumentation. 
This model is implemented using [the **newdes** simulation API](http://www.osadev.org/maven-config/osa-simapis/osa-simapis-newdes/index.html) (see also [here, on github](https://github.com/osadevs/ooo.simapis.newdes)). Therefore it requires a **newdes** simulation engine (you may want to check [this engine](https://github.com/osadevs/ooo.engines.newdes) 
 that comes with the OSA distribution). However, the easy way is to start from an existing OSA experiment, such as [this one, that also comes as part of the OSA distribution.](https://github.com/osadevs/ooo.experiences.newdes.helloworld-process)