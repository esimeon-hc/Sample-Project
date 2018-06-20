package Clean.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetClean

object Clean_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetClean {
            projects = "**/*.csproj"
            args = """\v=clf"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
