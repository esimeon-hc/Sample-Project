package Test_XUnit

import Test_XUnit.buildTypes.*
import Test_XUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_XUnit")
    name = "xUnit"

    vcsRoot(Test_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)

    buildType(Test_XUnit_DetailedLogging)
    buildType(Test_XUnit_NormalLogging)
    buildType(Test_XUnit_SimpleXunitTestRun)
    buildType(Test_XUnit_QuietLogging)
    buildType(Test_XUnit_MinimalLogging)
    buildType(Test_XUnit_DiagnosticLogging)

    subProject(Test_XUnitDotCover.Project)
})
