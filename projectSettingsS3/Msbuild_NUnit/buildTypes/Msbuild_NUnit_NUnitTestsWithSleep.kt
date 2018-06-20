package Msbuild_NUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Msbuild_NUnit_NUnitTestsWithSleep : BuildType({
    name = "NUnit tests with Sleep"

    vcs {
        root(Msbuild_NUnit.vcsRoots.Msbuild_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
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
        dotnetMsBuild {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
            args = "/t:vstest"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
