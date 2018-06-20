package Msbuild_MSTest_DotCover

import Msbuild_MSTest_DotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild_MSTest_DotCover")
    name = "MSTest + dotCover"

    buildType(Msbuild_MSTest_DotCover_DefaultLogging)
    buildType(Msbuild_MSTest_DotCover_NormalLogging)
    buildType(Msbuild_MSTest_DotCover_MinimalLogging)
    buildType(Msbuild_MSTest_DotCover_QuietLogging)
    buildType(Msbuild_MSTest_DotCover_DiagnosticLogging)
    buildType(Msbuild_MSTest_DotCover_DetailedLogging)
})
