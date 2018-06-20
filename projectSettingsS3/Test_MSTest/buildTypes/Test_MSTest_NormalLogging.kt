package Test_MSTest.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Test_MSTest_NormalLogging : BuildType({
    name = "normal logging"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            logging = DotnetTestStep.Verbosity.Normal
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2017.2.20171006.131508%")
        }
    }

    triggers {
        vcs {
        }
    }
})
