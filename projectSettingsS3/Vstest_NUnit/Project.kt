package Vstest_NUnit

import Vstest_NUnit.buildTypes.*
import Vstest_NUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Vstest_NUnit")
    name = "NUnit"

    vcsRoot(Vstest_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)

    buildType(Vstest_NUnit_2RunTestsDiagnosticLogging)
    buildType(Vstest_NUnit_2RunTestsMinimalLogging)
    buildType(Vstest_NUnit_2RunTestsNormalLogging)
    buildType(Vstest_NUnit_2RunTestsDetailedLogging)
    buildType(Vstest_NUnit_2RunTestsDefaultLoggingLevel)
    buildType(Vstest_NUnit_2RunTestsQuietLogging)
    buildType(Vstest_NUnit_NUnitTestsWithSleep)

    subProject(Vstest_NUnit_2DotCover.Project)
})
