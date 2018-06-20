package Msbuild_NUnit

import Msbuild_NUnit.buildTypes.*
import Msbuild_NUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild_NUnit")
    name = "NUnit"

    vcsRoot(Msbuild_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)

    buildType(Msbuild_NUnit_RunTestsDiagnosticLogging)
    buildType(Msbuild_NUnit_RunTestsNormalLogging)
    buildType(Msbuild_NUnit_RunTestsDetailedLogging)
    buildType(Msbuild_NUnit_RunTestsQuietLogging)
    buildType(Msbuild_NUnit_RunTestsDefaultLoggingLevel)
    buildType(Msbuild_NUnit_NUnitTestsWithSleep)
    buildType(Msbuild_NUnit_RunTestsMinimalLogging)

    subProject(Msbuild_NUnitDotCover.Project)
})
