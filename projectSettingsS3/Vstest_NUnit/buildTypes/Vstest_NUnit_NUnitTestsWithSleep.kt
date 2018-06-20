package Vstest_NUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetVsTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Vstest_NUnit_NUnitTestsWithSleep : BuildType({
    name = "NUnit tests with Sleep"

    vcs {
        root(Vstest_NUnit.vcsRoots.Vstest_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "PrimeService/PrimeService.csproj PrimeServiceTests/PrimeServiceTests.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "PrimeService/PrimeService.csproj PrimeServiceTests/PrimeServiceTests.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetVsTest {
            assemblies = "PrimeServiceTests/bin/Debug/netcoreapp2.0/PrimeServiceTests.dll"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
