package Build.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild

object Build_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetBuild {
            projects = "**/*.csproj"
            configuration = "bla"
            args = """\jv=opio"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
