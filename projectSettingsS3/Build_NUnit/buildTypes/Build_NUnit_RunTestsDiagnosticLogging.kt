package Build_NUnit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Build_NUnit_RunTestsDiagnosticLogging : BuildType({
    name = "run tests, diagnostic logging"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "PrimeService/PrimeService.csproj"
        }
        dotnetBuild {
            projects = "PrimeService/PrimeService.csproj"
        }
        dotnetRestore {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
        }
        dotnetBuild {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
            args = "/t:vstest"
            logging = DotnetBuildStep.Verbosity.Diagnostic
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
