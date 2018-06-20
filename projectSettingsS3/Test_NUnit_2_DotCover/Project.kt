package Test_NUnit_2_DotCover

import Test_NUnit_2_DotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_NUnit_2_DotCover")
    name = "NUnit + dotCover"

    buildType(Test_NUnit_2_DotCover_RunTestsMinimalLogging)
    buildType(Test_NUnit_2_DotCover_RunTestsDetailedLogging)
    buildType(Test_NUnit_2_DotCover_RunTestsNormalLogging)
    buildType(Test_NUnit_2_DotCover_RunTestsQuietLogging)
    buildType(Test_NUnit_2_DotCover_RunTestsDefaultLoggingLevel)
    buildType(Test_NUnit_2_DotCover_RunTestsDiagnosticLogging)
})
