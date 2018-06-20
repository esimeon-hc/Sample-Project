package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object DotCover_NunitMstestDotnet20dotCover20173 : BuildType({
    name = "nunit+mstest, dotnet 2.0, dotCover (2017.3)"

    vcs {
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster, "+:. => nunit")
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster, "+:. => mstest")
    }

    steps {
        dotnetTest {
            projects = """
                nunit/PrimeServiceTests/PrimeServiceTests.csproj
                mstest/PrimeService.Tests/PrimeService.Tests.csproj
            """.trimIndent()
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.2017.3.5%"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})
