package Test

import Test.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Test")
    name = "test"

    buildType(Test_OutsideOfCheckoutDirectory)
    buildType(Test_SolutionFile)
    buildType(Test_Wildcards)
    buildType(Test_DoNotFailBuildWithExitCode1)
    buildType(Test_ProjectFile)

    subProject(Test_MSTest.Project)
    subProject(Test_NUnit.Project)
    subProject(Test_XUnit.Project)
})
