package Test_MSTestDotCover

import Test_MSTestDotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_MSTestDotCover")
    name = "MSTest + dotCover"

    buildType(Test_MSTestDotCover_NormalLogging)
    buildType(Test_MSTestDotCover_DetailedLogging)
    buildType(Test_MSTestDotCover_DiagnosticLogging)
    buildType(Test_MSTestDotCover_MinimalLogging)
    buildType(Test_MSTestDotCover_DefaultLogging)
    buildType(Test_MSTestDotCover_QuietLogging)
})
