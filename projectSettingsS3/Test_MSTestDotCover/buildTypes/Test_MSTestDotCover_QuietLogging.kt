package Test_MSTestDotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Test_MSTestDotCover_QuietLogging : BuildType({
    name = "quiet logging"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            logging = DotnetTestStep.Verbosity.Quiet
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2017.2.20171006.131508%"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
