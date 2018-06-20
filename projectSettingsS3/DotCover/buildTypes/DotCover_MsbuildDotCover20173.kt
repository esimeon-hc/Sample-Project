package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore

object DotCover_MsbuildDotCover20173 : BuildType({
    name = "msbuild + dotCover (2017.3)"

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
        dotnetMsBuild {
            workingDir = "PrimeService.Tests"
            targets = "vstest"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2017.3.5%"
                assemblyFilters = "+:*"
            }
            param("test.names", "ReturnFalse")
        }
    }
})
