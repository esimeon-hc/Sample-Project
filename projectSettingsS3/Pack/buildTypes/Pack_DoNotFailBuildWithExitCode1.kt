package Pack.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPack

object Pack_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetPack {
            projects = "**/*.csproj"
            runtime = "linux-x64"
            args = """\v=dl"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
