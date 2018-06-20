package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object DotCover_NunitTestDotCover : BuildType({
    name = "nunit, test + dotCover"

    vcs {
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaNunitCoreTestsGitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
                assemblyFilters = "+:PrimeService.Tests"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
