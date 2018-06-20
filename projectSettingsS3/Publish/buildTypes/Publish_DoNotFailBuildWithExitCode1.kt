package Publish.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPublish
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Publish_DoNotFailBuildWithExitCode1 : BuildType({
    name = "do not fail build with exit code 1"

    vcs {
        root(Publish.vcsRoots.Publish_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster, "+:.=>one_directory")
        root(Publish.vcsRoots.Publish_HttpsGithubComBurnashevaCoreExeGit, "+:.=>another_directory")
    }

    steps {
        dotnetPublish {
            projects = "**/CoreEx?.csproj"
            args = """\v=d"""
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }

    failureConditions {
        nonZeroExitCode = false
    }
})
