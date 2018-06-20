package Vstest_MSTest_DotCover

import Vstest_MSTest_DotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_MSTest_DotCover")
    name = "MSTest + dotCover"

    buildType(Vstest_MSTest_DotCover_MinimalLogging)
    buildType(Vstest_MSTest_DotCover_DefaultLogging)
    buildType(Vstest_MSTest_DotCover_DiagnosticLogging)
    buildType(Vstest_MSTest_DotCover_QuietLogging)
    buildType(Vstest_MSTest_DotCover_NormalLogging)
    buildType(Vstest_MSTest_DotCover_DetailedLogging)
})
