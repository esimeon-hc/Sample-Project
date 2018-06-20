package Msbuild_NUnitDotCover

import Msbuild_NUnitDotCover.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild_NUnitDotCover")
    name = "NUnit + dotCover"

    buildType(Msbuild_NUnitDotCover_RunTestsDefaultLoggingLevel)
    buildType(Msbuild_NUnitDotCover_RunTestsQuietLogging)
    buildType(Msbuild_NUnitDotCover_RunTestsNormalLogging)
    buildType(Msbuild_NUnitDotCover_RunTestsDetailedLogging)
    buildType(Msbuild_NUnitDotCover_RunTestsDiagnosticLogging)
    buildType(Msbuild_NUnitDotCover_RunTestsMinimalLogging)
})
