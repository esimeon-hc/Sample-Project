package Build_XUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Build_XUnit_SimpleXunitTestRun : BuildType({
    name = "simple xunit test run"

    vcs {
        root(Build_XUnit.vcsRoots.Build_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "PrimeService/PrimeService.csproj"
        }
        dotnetBuild {
            projects = "PrimeService/PrimeService.csproj"
        }
        dotnetRestore {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
        dotnetBuild {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            args = "/t:vstest"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
