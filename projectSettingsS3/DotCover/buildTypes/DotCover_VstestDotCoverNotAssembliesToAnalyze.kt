package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetVsTestStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetVsTest

object DotCover_VstestDotCoverNotAssembliesToAnalyze : BuildType({
    name = "vstest + dotCover (not assemblies to analyze)"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetRestore {
            projects = "MSTestCore.sln"
            sources = "https://api.nuget.org/v3/index.json"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
        dotnetVsTest {
            assemblies = """PrimeService.Tests\bin\Debug\netcoreapp1.1\PrimeService.Tests.dll"""
            filter = testCaseFilter {
                filter = "PrimeService"
            }
            logging = DotnetVsTestStep.Verbosity.Diagnostic
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
                assemblyFilters = "+:*"
            }
            param("test.names", "ReturnFalse")
        }
    }
})
