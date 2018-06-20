package Run.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRun

object Run_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetRun {
            projects = "**/*.csproj"
            runtime = "linux-x64"
            args = """\v=d"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
