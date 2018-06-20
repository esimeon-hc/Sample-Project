package Test_MSTest

import Test_MSTest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_MSTest")
    name = "MSTest"

    buildType(Test_MSTest_DefaultLogging)
    buildType(Test_MSTest_QuietLogging)
    buildType(Test_MSTest_DiagnosticLogging)
    buildType(Test_MSTest_NormalLogging)
    buildType(Test_MSTest_DetailedLogging)
    buildType(Test_MSTest_MinimalLogging)

    subProject(Test_MSTestDotCover.Project)
})
