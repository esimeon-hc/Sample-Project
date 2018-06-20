package Vstest_MSTest

import Vstest_MSTest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_MSTest")
    name = "MSTest"

    buildType(Vstest_MSTest_MinimalLogging)
    buildType(Vstest_MSTest_DetailedLogging)
    buildType(Vstest_MSTest_NormalLogging)
    buildType(Vstest_MSTest_DiagnosticLogging)
    buildType(Vstest_MSTest_QuietLogging)
    buildType(Vstest_MSTest_DefaultLogging)

    subProject(Vstest_MSTest_DotCover.Project)
})
