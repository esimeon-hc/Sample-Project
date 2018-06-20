package Msbuild_XUnit

import Msbuild_XUnit.buildTypes.*
import Msbuild_XUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild_XUnit")
    name = "xUnit"

    vcsRoot(Msbuild_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)

    buildType(Msbuild_XUnit_NormalLogging)
    buildType(Msbuild_XUnit_DiagnosticLogging)
    buildType(Msbuild_XUnit_QuietLogging)
    buildType(Msbuild_XUnit_DetailedLogging)
    buildType(Msbuild_XUnit_MinimalLogging)
    buildType(Msbuild_XUnit_SimpleXunitTestRun)
})
