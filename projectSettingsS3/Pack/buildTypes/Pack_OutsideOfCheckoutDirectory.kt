package Pack.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPack

object Pack_OutsideOfCheckoutDirectory : BuildType({
    name = "outside of checkout directory"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        dotnetPack {
            projects = "/Users/nburnasheva/temp/dot_net_core/**/*.csproj"
            runtime = "linux-x64"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
})
