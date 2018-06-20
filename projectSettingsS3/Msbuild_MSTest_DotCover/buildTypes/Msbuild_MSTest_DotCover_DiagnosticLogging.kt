package Msbuild_MSTest_DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetMsBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Msbuild_MSTest_DotCover_DiagnosticLogging : BuildType({
    name = "diagnostic logging"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetMsBuild {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            args = "/t:vstest"
            logging = DotnetMsBuildStep.Verbosity.Diagnostic
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
