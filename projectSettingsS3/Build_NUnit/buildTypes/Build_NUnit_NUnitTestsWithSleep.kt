package Build_NUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Build_NUnit_NUnitTestsWithSleep : BuildType({
    name = "NUnit tests with Sleep"

    vcs {
        root(Build_NUnit.vcsRoots.Build_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "nunit_core2.sln"
        }
        dotnetBuild {
            projects = "nunit_core2.sln"
        }
        dotnetBuild {
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
