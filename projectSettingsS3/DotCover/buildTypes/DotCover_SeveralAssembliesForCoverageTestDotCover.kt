package DotCover.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object DotCover_SeveralAssembliesForCoverageTestDotCover : BuildType({
    name = "several assemblies for coverage, test + dotCover"

    vcs {
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaNunitCoreTestsGitRefsHeadsMaster, "+:. => nunit")
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit, "+:. => mstest")
        root(DotCover.vcsRoots.DotCover_HttpsGithubComBurnashevaXunitCoreAdapterRefsHeadsMaster, "+:. => xunit")
    }

    steps {
        dotnetRestore {
            projects = "mstest/PrimeService.Tests/PrimeService.Tests.csproj xunit/PrimeService.Tests/PrimeService.Tests.csproj nunit/PrimeService.Tests/PrimeService.Tests.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetTest {
            projects = "mstest/PrimeService.Tests/PrimeService.Tests.csproj nunit/PrimeService.Tests/PrimeService.Tests.csproj xunit/PrimeService.Tests/PrimeService.Tests.csproj"
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
