package Build_MSTest

import Build_MSTest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Build_MSTest")
    name = "MSTest"

    buildType(Build_MSTest_DetailedLogging)
    buildType(Build_MSTest_DefaultLogging)
    buildType(Build_MSTest_QuietLogging)
    buildType(Build_MSTest_NormalLogging)
    buildType(Build_MSTest_MinimalLogging)
    buildType(Build_MSTest_DiagnosticLogging)
})
