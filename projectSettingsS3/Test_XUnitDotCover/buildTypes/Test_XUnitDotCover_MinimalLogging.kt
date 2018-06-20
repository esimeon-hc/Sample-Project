package Test_XUnitDotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Test_XUnitDotCover_MinimalLogging : BuildType({
    name = "minimal logging"

    vcs {
        root(Test_XUnitDotCover.vcsRoots.Test_XUnitDotCover_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMa)
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
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            logging = DotnetTestStep.Verbosity.Minimal
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
