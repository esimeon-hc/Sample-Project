package Msbuild_MSTest

import Msbuild_MSTest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild_MSTest")
    name = "MSTest"

    buildType(Msbuild_MSTest_DefaultLogging)
    buildType(Msbuild_MSTest_DiagnosticLogging)
    buildType(Msbuild_MSTest_MinimalLogging)
    buildType(Msbuild_MSTest_DetailedLogging)
    buildType(Msbuild_MSTest_NormalLogging)
    buildType(Msbuild_MSTest_QuietLogging)

    subProject(Msbuild_MSTest_DotCover.Project)
})
