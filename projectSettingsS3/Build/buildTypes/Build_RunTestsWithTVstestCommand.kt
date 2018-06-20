package Build.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore

object Build_RunTestsWithTVstestCommand : BuildType({
    name = "run tests with /t:vstest command"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit, "+:.=>first")
        root(Build.vcsRoots.Build_HttpsGithubComBurnashevaXunitCoreAdapter, "+:.=>second")
    }

    steps {
        dotnetRestore {
            projects = "**/*.csproj"
            sources = "https://api.nuget.org/v3/index.json"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "**/*.Tests/*.csproj"
            args = "/t:vstest"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
            param("test.names", "ReturnFalse")
        }
    }
})
