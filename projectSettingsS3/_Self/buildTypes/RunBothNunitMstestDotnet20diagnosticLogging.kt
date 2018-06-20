package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object RunBothNunitMstestDotnet20diagnosticLogging : BuildType({
    name = "run both nunit+mstest, dotnet 2.0, diagnostic logging"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster, "+:. => nunit")
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster, "+:. => mstest")
    }

    steps {
        dotnetTest {
            projects = """
                nunit/PrimeServiceTests/PrimeServiceTests.csproj
                mstest/PrimeService.Tests/PrimeService.Tests.csproj
            """.trimIndent()
            logging = DotnetTestStep.Verbosity.Diagnostic
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2017.2.20171006.131508%")
        }
    }

    triggers {
        vcs {
        }
    }
})
