package Build_XUnit

import Build_XUnit.buildTypes.*
import Build_XUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Build_XUnit")
    name = "xUnit"

    vcsRoot(Build_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)

    buildType(Build_XUnit_DetailedLogging)
    buildType(Build_XUnit_NormalLogging)
    buildType(Build_XUnit_MinimalLogging)
    buildType(Build_XUnit_SimpleXunitTestRun)
    buildType(Build_XUnit_DiagnosticLogging)
    buildType(Build_XUnit_QuietLogging)
})
