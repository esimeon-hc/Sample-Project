package Msbuild.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild

object Msbuild_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetMsBuild {
            projects = "PrimeService3/PrimeService3.csproj"
            targets = "build Build"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
