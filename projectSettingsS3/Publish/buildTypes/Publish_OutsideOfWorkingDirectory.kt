package Publish.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPublish
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Publish_OutsideOfWorkingDirectory : BuildType({
    name = "outside of working directory"

    vcs {
        root(Publish.vcsRoots.Publish_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster, "+:.=>one_directory")
        root(Publish.vcsRoots.Publish_HttpsGithubComBurnashevaCoreExeGit, "+:.=>another_directory")
    }

    steps {
        dotnetPublish {
            projects = "/Users/nburnasheva/temp/dot_net_core/**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
