package Vstest_NUnit_2DotCover

import Vstest_NUnit_2DotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_NUnit_2DotCover")
    name = "NUnit + dotCover"

    buildType(Vstest_NUnit_2DotCover_RunTestsDetailedLogging)
    buildType(Vstest_NUnit_2DotCover_RunTestsDiagnosticLogging)
    buildType(Vstest_NUnit_2DotCover_RunTestsNormalLogging)
    buildType(Vstest_NUnit_2DotCover_RunTestsQuietLogging)
    buildType(Vstest_NUnit_2DotCover_RunTestsDefaultLoggingLevel)
    buildType(Vstest_NUnit_2DotCover_RunTestsMinimalLogging)
})
