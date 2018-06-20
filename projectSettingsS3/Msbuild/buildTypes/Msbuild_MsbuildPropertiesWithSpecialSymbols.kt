package Msbuild.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetMsBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Msbuild_MsbuildPropertiesWithSpecialSymbols : BuildType({
    name = "msbuild properties with special symbols"

    params {
        param("system.myVar", "Nadia")
    }

    vcs {
        root(Msbuild.vcsRoots.Msbuild_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster)
    }

    steps {
        dotnetMsBuild {
            targets = "Msg"
            logging = DotnetMsBuildStep.Verbosity.Normal
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
