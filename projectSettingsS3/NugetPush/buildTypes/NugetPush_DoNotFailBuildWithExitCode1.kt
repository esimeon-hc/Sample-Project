package NugetPush.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetNugetPush

object NugetPush_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetNugetPush {
            packages = "/Users/nburnasheva/Downloads/**/*.nupkg"
            serverUrl = "%teamcity.nuget.feed.server%"
            apiKey = "zxx61f89bca1f9b9ac8400f518362b9dc58ec0bd1aa96f4a2c4d3bf3725bfb0a1b0"
            args = """\v=dl"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }

    requirements {
        contains("teamcity.agent.name", "MacOS")
    }
})
