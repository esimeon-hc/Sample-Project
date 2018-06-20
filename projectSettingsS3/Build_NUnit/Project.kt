package Build_NUnit

import Build_NUnit.buildTypes.*
import Build_NUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Build_NUnit")
    name = "NUnit"

    vcsRoot(Build_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)

    buildType(Build_NUnit_RunTestsDefaultLoggingLevel)
    buildType(Build_NUnit_NUnitTestsWithSleep)
    buildType(Build_NUnit_RunTestsMinimalLogging)
    buildType(Build_NUnit_RunTestsDiagnosticLogging)
    buildType(Build_NUnit_RunTestsDetailedLogging)
    buildType(Build_NUnit_RunTestsNormalLogging)
    buildType(Build_NUnit_RunTestsQuietLogging)
})
