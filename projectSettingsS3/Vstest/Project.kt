package Vstest

import Vstest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest")
    name = "vstest"

    buildType(Vstest_DoNotFailBuildWithExitCode1)
    buildType(Vstest_Wildcards)
    buildType(Vstest_OutsideOfWorkingDirectory)
    buildType(Vstest_RunVstestFomNetCli)

    subProject(Vstest_MSTest.Project)
    subProject(Vstest_XUnit.Project)
    subProject(Vstest_NUnit.Project)
})
