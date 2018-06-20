package Vstest_XUnit_DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetMsBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Vstest_XUnit_DotCover_NormalLogging : BuildType({
    name = "normal logging"

    vcs {
        root(Vstest_XUnit_DotCover.vcsRoots.Vstest_XUnit_DotCover_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHea)
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
        dotnetMsBuild {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            args = "/t:vstest"
            logging = DotnetMsBuildStep.Verbosity.Normal
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
