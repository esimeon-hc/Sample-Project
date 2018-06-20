package Vstest_XUnit

import Vstest_XUnit.buildTypes.*
import Vstest_XUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_XUnit")
    name = "xUnit"

    vcsRoot(Vstest_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)

    buildType(Vstest_XUnit_NormalLogging)
    buildType(Vstest_XUnit_MinimalLogging)
    buildType(Vstest_XUnit_DefaultLogging)
    buildType(Vstest_XUnit_DetailedLogging)
    buildType(Vstest_XUnit_QuietLogging)

    subProject(Vstest_XUnit_DotCover.Project)
})
