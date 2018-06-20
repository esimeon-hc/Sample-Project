package Vstest_XUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetVsTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Vstest_XUnit_DefaultLogging : BuildType({
    name = "default logging"

    vcs {
        root(Vstest_XUnit.vcsRoots.Vstest_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)
    }

    steps {
        dotnetBuild {
            projects = "PrimeService/PrimeService.csproj"
        }
        dotnetBuild {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetVsTest {
            assemblies = "PrimeService.Tests/bin/Debug/netcoreapp2.0/PrimeService.Tests.dll"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
