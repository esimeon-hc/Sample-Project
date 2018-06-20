package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object DotCover_MstestDotnet20dotCover : BuildType({
    name = "mstest, dotnet 2.0, dotCover"

    vcs {
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetTest {
            projects = "MSTestCore.sln"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2018.1.0%"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
