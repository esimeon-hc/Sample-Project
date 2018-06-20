package Vstest_XUnit_DotCover

import Vstest_XUnit_DotCover.buildTypes.*
import Vstest_XUnit_DotCover.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_XUnit_DotCover")
    name = "xUnit + dotCover"

    vcsRoot(Vstest_XUnit_DotCover_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHea)

    buildType(Vstest_XUnit_DotCover_DiagnosticLogging)
    buildType(Vstest_XUnit_DotCover_SimpleXunitTestRun)
    buildType(Vstest_XUnit_DotCover_QuietLogging)
    buildType(Vstest_XUnit_DotCover_MinimalLogging)
    buildType(Vstest_XUnit_DotCover_DetailedLogging)
    buildType(Vstest_XUnit_DotCover_NormalLogging)
})
