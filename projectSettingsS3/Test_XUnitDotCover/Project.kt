package Test_XUnitDotCover

import Test_XUnitDotCover.buildTypes.*
import Test_XUnitDotCover.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_XUnitDotCover")
    name = "xUnit + dotCover"

    vcsRoot(Test_XUnitDotCover_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMa)

    buildType(Test_XUnitDotCover_DiagnosticLogging)
    buildType(Test_XUnitDotCover_QuietLogging)
    buildType(Test_XUnitDotCover_NormalLogging)
    buildType(Test_XUnitDotCover_DetailedLogging)
    buildType(Test_XUnitDotCover_SimpleXunitTestRun)
    buildType(Test_XUnitDotCover_MinimalLogging)
})
