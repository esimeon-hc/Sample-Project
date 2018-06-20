package Test_NUnit

import Test_NUnit.buildTypes.*
import Test_NUnit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test_NUnit")
    name = "NUnit"

    vcsRoot(Test_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)

    buildType(Test_NUnit_2_RunTestsMinimalLogging)
    buildType(Test_NUnit_2_RunTestsDetailedLogging)
    buildType(Test_NUnit_2_RunTestsDiagnosticLogging)
    buildType(Test_NUnit_2_RunTestsDefaultLoggingLevel)
    buildType(Test_NUnit_2_RunTestsQuietLogging)
    buildType(Test_NUnit_NUnitTestsWithSleep)
    buildType(Test_NUnit_2_RunTestsNormalLogging)

    subProject(Test_NUnit_2_DotCover.Project)
})
