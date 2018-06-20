package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object DotCover_MsbuildMstestDotnet20dotCover : BuildType({
    name = "msbuild, mstest, dotnet 2.0, dotCover"

    vcs {
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetMsBuild {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            targets = "vstest"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
