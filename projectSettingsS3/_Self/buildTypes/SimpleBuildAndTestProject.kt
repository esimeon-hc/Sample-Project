package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest

object SimpleBuildAndTestProject : BuildType({
    name = "simple build and test project"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaNunitCoreTestsRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
    }
})
